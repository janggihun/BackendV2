package com.bismo.stellive.api.user;

import com.bismo.stellive.api.common.CommonResponse;
import com.bismo.stellive.api.common.JwtUtil;
import com.bismo.stellive.api.user.dto.UserRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/api/v1/user")
public class UserApiController {
    //jwt
    private final JwtUtil jwtUtil;

    @Value("${spring.data.redis.port}")
    private int port;
    //무중단배포
    private final RedisTemplate<String, String> redisTemplate;

    public UserApiController(JwtUtil jwtUtil, RedisTemplate<String, String> redisTemplate) {

        this.jwtUtil = jwtUtil;
        this.redisTemplate = redisTemplate;
    }


    @PostMapping("/login")
    public CommonResponse login (@Validated @RequestBody UserRequest userRequest  ) {


        String token = jwtUtil.generateToken(userRequest.getUserId());


        redisTemplate.opsForValue().set("RT:" + userRequest.getUserId(), token, Duration.ofHours(1));


        return CommonResponse.success(token);

    };


    @GetMapping("/Authorization")
    public CommonResponse getUserIdFromToken(@RequestHeader(value = "Authorization", required = false) String authHeader) {

        //추후에 userId 확인하면서 url, crud 권한 까지 확인요망

        // "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return CommonResponse.error("토큰이 없습니다.");
        }


        String token = authHeader.substring(7);

        // 블랙리스트 체크 (로그아웃 시 토큰을 블랙리스트에 등록했다고 가정)
        Boolean isBlacklisted = redisTemplate.hasKey("BL:" + token);
        if (Boolean.TRUE.equals(isBlacklisted)) {
            return CommonResponse.error("이미 로그아웃된 토큰입니다.");
        }

        if (!jwtUtil.validateToken(token)) {
            return CommonResponse.error("토큰의 기한이 완료되었습니다. 재로그인해주세요");
        }

        String userId = jwtUtil.getUserId(token);

        log.info("8080 버전1 업뎃 2025-07-26");
        return CommonResponse.success(userId);
    }

    @GetMapping("/logout")
    public CommonResponse logout(@RequestHeader(value = "Authorization", required = false) String authHeader) {

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return CommonResponse.success("토큰이 없습니다.");
        }
        String token = authHeader.substring(7);

        // 토큰 만료시간까지 블랙리스트 등록 (토큰 만료시간 계산 필요)
        Date expiryDate = jwtUtil.getExpirationDate(token); // JwtUtil에 getExpirationDate 메서드 구현 필요
        long expireSeconds = (expiryDate.getTime() - System.currentTimeMillis()) / 1000;

        redisTemplate.opsForValue().set("BL:" + token, "logout", Duration.ofSeconds(expireSeconds));

        // 로그아웃 완료 응답 반환
        return CommonResponse.success("로그아웃 되었습니다.");

    };

}
