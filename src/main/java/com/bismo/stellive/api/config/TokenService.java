package com.bismo.stellive.api.config;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final RedisTemplate<String, String> redisTemplate;

    // RefreshToken 저장 (유효기간 1시간)
    public void saveRefreshToken(String userId, String refreshToken) {
        redisTemplate.opsForValue().set(
                "RT:" + userId,
                refreshToken,
                Duration.ofHours(1)
        );
    }

    public String getRefreshToken(String userId) {
        return redisTemplate.opsForValue().get("RT:" + userId);
    }

    public void deleteRefreshToken(String userId) {
        redisTemplate.delete("RT:" + userId);
    }
}
