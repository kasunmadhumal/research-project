package com.research.cacheasidemediumcomplexity.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class RedisService {

    private final RedisTemplate<String, String> redisTemplate;

    @Autowired
    public RedisService(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void setValue(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public String getValue(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public List<String> getAllValues(String pattern) {
        Set<String> keys = redisTemplate.keys(pattern);
        List<String> values = new ArrayList<>();
        if (keys != null) {
            for (String key : keys) {
                String value = getValue(key);
                if (value != null) {
                    values.add(value);
                }
            }
        }
        return values;
    }

    public void clearCache() {
        redisTemplate.getConnectionFactory().getConnection().flushDb();
    }

}