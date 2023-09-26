package com.vella.URLShortenerRedirectionService.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@RedisHash("Url")
public class Url implements Serializable {

    private String id;

    private String realURL;

    private String shortURL;
}
