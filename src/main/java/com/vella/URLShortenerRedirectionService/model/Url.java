package com.vella.URLShortenerRedirectionService.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@RedisHash("Url")
public class Url {

    @Id
    private Long id;

    private String realURL;

    private String shortURL;
}
