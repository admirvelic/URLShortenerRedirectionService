package com.vella.URLShortenerRedirectionService.model;


import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class Url {

    private Long id;

    private String realURL;

    private String shortURL;
}
