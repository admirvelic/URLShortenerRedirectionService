package com.vella.URLShortenerRedirectionService.service;


import com.vella.URLShortenerRedirectionService.exception.RedirectException;
import com.vella.URLShortenerRedirectionService.model.Url;
import com.vella.URLShortenerRedirectionService.repository.UrlRepo;
import com.vella.URLShortenerRedirectionService.exception.CustomErrorException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Random;


@RequiredArgsConstructor
@Slf4j
@Service
public class RedirectService {

    private final UrlRepo repo;

    public String createRedirectionUrl(String hash) {
        try {
            log.info("Redirecting from hash: " + hash);
            if (hash.isEmpty()) {
                throw new IOException("No URL found");
            }

            String baseShortUrl = "http://localhost:8080/";
            String redirect = "redirect:";
            String shortURL = baseShortUrl + hash;
            log.info("Redirecting from url: "+ shortURL);
            Url url = repo.findByShortURL(shortURL);
            if(url== null){
                throw new IOException("No URL to redirect to");
            }
            String realURL = url.getRealURL();
            log.info("Redirecting to: "+realURL);
            if (realURL.isEmpty()) {
                return null;
            }
            String redirectionUrl = redirect + realURL;
            log.info("Redirect url found: "+ redirectionUrl);
            return redirectionUrl;
        } catch (Exception e) {
            throw new RedirectException(HttpStatus.NOT_FOUND,"Failed redirecting to real URL", e);
        }
    }


    public void saveUrl(Url url) {
        try {
            if (url == null) {
                throw new IOException("No url was set");
            }
            repo.save(url);
        } catch (Exception e) {
            throw new CustomErrorException(HttpStatus.INTERNAL_SERVER_ERROR,"Failed saving URL to database", e);
        }
    }

    public void deleteUrl(Url url) {
        try {
            if (url == null) {
                throw new IOException("No url was set");
            }

            repo.delete(url);
        } catch (Exception e) {
            throw new CustomErrorException(HttpStatus.INTERNAL_SERVER_ERROR,"Failed deleting URL to database", e);
        }
    }
}
