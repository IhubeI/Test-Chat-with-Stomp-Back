package com.chat.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.chat.dao.RefreshTokenDao;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

@Repository
public class RefreshTokenDaoImpl implements RefreshTokenDao {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public void save(String userId, String token) {
        // 현재 시간 기준으로 1년 후 만료 시간을 설정
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 1); // 1년 추가
        
        long expiryTimeInMillis = calendar.getTimeInMillis() - System.currentTimeMillis(); // 현재 시간과 만료 시간의 차이 계산
        
        redisTemplate.opsForValue().set(userId + "_refreshToken", token, expiryTimeInMillis, TimeUnit.MILLISECONDS); // 만료 시간 설정
    }

    @Override
    public String findByUserId(String userId) {
        return redisTemplate.opsForValue().get(userId + "_refreshToken"); // 저장된 리프레시 토큰 조회
    }

    @Override
    public void deleteByUserId(String userId) {
        redisTemplate.delete(userId + "_refreshToken"); // 리프레시 토큰 삭제
    }
}
