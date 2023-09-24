package com.vella.URLShortenerRedirectionService.repository;

import com.vella.URLShortenerRedirectionService.model.Url;
import com.vella.URLShortenerRedirectionService.exception.CustomErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UrlRepo {

    @Autowired
    private RedisTemplate redisTemplate;

    private static final String KEY = "URL";

    public Url saveUrl(Url url) {
        try {
            redisTemplate.opsForHash().put(KEY, url.getId().toString(), url);
            return url;
        } catch (Exception e) {
            throw new CustomErrorException("Filed saving URL to Redis", e);
        }
    }

    public List<Url> getAllUrl() {
        List<Url> urls;
        urls = redisTemplate.opsForHash().values(KEY);
        return urls;
    }

    public Url findUrlById(Long id) {
        Url url;
        url = (Url) redisTemplate.opsForHash().get(KEY, id.toString());
        return url;
    }

    public Url findUrlByShortUrl(String shortURL) {
        Url url;
        url = (Url) redisTemplate.opsForHash().get(KEY, shortURL);
        return url;
    }

    public void deleteUrl(Url url) {
        try {
            redisTemplate.opsForHash().delete(KEY, url.getId().toString());
        } catch (Exception e) {
            throw new CustomErrorException("Filed deleting URL from redis", e);
        }
    }

    public Url updateUrl(Url url) {
        try {
            redisTemplate.opsForHash().put(KEY, url.getId(), url);
            return url;
        } catch (Exception e) {
            throw new CustomErrorException("Filed updating URL in redis");
        }
    }
}
