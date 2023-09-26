package com.vella.URLShortenerRedirectionService.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@RedisHash("Url")
public class Url implements Serializable {

    @Id
    private String id;

    @Indexed
    private String realURL;

    @Indexed
    private String shortURL;
}
