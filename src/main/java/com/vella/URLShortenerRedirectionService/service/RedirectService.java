package com.vella.URLShortenerRedirectionService.service;


import com.vella.URLShortenerRedirectionService.model.Url;
import com.vella.URLShortenerRedirectionService.repository.UrlRepo;
import com.vella.URLShortenerRedirectionService.exception.CustomErrorException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;


@RequiredArgsConstructor
@Slf4j
@Service
public class RedirectService {

    private final UrlRepo repo;

    public String redirectToRealUrl(String hash) {
        try {
            if (hash.isEmpty()) {
                throw new IOException("No URL found");
            }

            String baseShortUrl = "http://localhost:8080/";
            String redirect = "redirect:/";
            String shortURL = baseShortUrl + hash;
            Url url = repo.findUrlByShortUrl(shortURL);
            String realURL = url.getRealURL();
            String response = redirect + realURL;
            return response;

        } catch (Exception e) {
            throw new CustomErrorException("Filed redirecting to real URL", e);
        }
    }


    public void saveUrl(Url url) {
        try {
            if (url == null) {
                throw new IOException("No url was set");
            }

            repo.saveUrl(url);
        } catch (Exception e) {
            throw new CustomErrorException("Filed saving URL to database", e);
        }
    }

    public void deleteUrl(Url url) {
        try {
            if (url == null) {
                throw new IOException("No url was set");
            }

            repo.deleteUrl(url);
        } catch (Exception e) {
            throw new CustomErrorException("Filed deleting URL to database", e);
        }
    }
}
