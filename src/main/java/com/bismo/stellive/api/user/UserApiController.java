package com.bismo.stellive.api.user;

import com.bismo.stellive.api.common.CommonResponse;
import com.bismo.stellive.api.user.dto.UserRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseCookie;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/user")
public class UserApiController {

    @PostMapping("/login")
    public CommonResponse login (@Validated @RequestBody UserRequest userRequest , HttpServletRequest request ) {
        HttpSession session = request.getSession(true);
        session.setAttribute("user",userRequest.getUserId() );
        log.info("로그인 시 세션 ID: {}", session.getId());
//        session.setAttribute("user",userRequest.getUserId()); //추후에는 user객체 저장

        return CommonResponse.success("성공");

    };
    @GetMapping("/me")
    public CommonResponse me(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            log.info("me 세션 ID: {}, user: {}", session.getId(), session.getAttribute("user"));
            if (session.getAttribute("user") != null) {
                return CommonResponse.success(session.getAttribute("user"));
            }
        }

            return CommonResponse.error("로그인 필요");

    }
    @GetMapping("/logout")
    public CommonResponse logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); // 세션 완전 무효화
        }

        // 선택: 클라이언트 쪽에서도 JSESSIONID 쿠키 제거 유도
        ResponseCookie cookie = ResponseCookie.from("JSESSIONID", "")
                .path("/")
                .maxAge(0)        // 즉시 만료
                .httpOnly(true)
                .build();
        response.addHeader("Set-Cookie", cookie.toString());

        return CommonResponse.success("로그아웃 되었습니다.");
    }

}
