package com.vella.URLShortenerRedirectionService.controller;


import com.vella.URLShortenerRedirectionService.service.RedirectService;
import com.vella.URLShortenerRedirectionService.exception.CustomErrorException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class RedirectController {

    private final RedirectService service;

    @GetMapping("{hash}")
    public RedirectView redirect(@PathVariable String hash) throws CustomErrorException, IOException, URISyntaxException {
        return new RedirectView(service.getRealUrl(hash));
    }

}
