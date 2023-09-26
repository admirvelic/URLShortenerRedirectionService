package com.vella.URLShortenerRedirectionService.repository;

import com.vella.URLShortenerRedirectionService.model.Url;
import com.vella.URLShortenerRedirectionService.exception.CustomErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UrlRepo {

    @Autowired
    private RedisTemplate redisTemplate;

    private static final String KEY = "URL";

    public Url saveUrl(Url url) {
        redisTemplate.opsForHash().put(KEY, url.getId().toString(), url);
        return url;
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
        redisTemplate.opsForHash().delete(KEY, url.getId().toString());
    }

    public Url updateUrl(Url url) {
        redisTemplate.opsForHash().put(KEY, url.getId(), url);
        return url;
    }
}
