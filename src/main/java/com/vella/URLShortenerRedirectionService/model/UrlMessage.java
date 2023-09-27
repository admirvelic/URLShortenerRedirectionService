package com.vella.URLShortenerRedirectionService.model;


import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UrlMessage {

    private Long id;

    private String realURL;

    private String shortURL;

    private Action action;
}

