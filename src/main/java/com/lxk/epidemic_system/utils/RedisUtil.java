package com.lxk.epidemic_system.utils;

import com.lxk.epidemic_system.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisUtil {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void setUser(String userId, User user) {
        redisTemplate.opsForValue().set(userId, user);
    }

    public User getUser(String userId) {
        return (User) redisTemplate.opsForValue().get(userId);
    }

    public void deleteUser(String userId) {
        redisTemplate.delete(userId);
    }
    public void expire(String userId, long time) {
        redisTemplate.expire(userId, time, java.util.concurrent.TimeUnit.SECONDS);
    }
}
