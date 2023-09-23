package com.vella.URLShortenerRedirectionService.Model;


import jakarta.persistence.Entity;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class UrlMessage {

    private Long id;

    private String realURL;

    private String shortURL;

    private Action action;

    public UrlMessage(Url url, Action action) {
        this.shortURL = url.getShortURL();
        this.realURL = url.getRealURL();
        this.action = action;
    }

}

