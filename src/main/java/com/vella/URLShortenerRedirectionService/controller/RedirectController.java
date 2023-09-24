package com.vella.URLShortenerRedirectionService.controller;


import com.vella.URLShortenerRedirectionService.service.RedirectService;
import com.vella.URLShortenerRedirectionService.exception.CustomErrorException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class RedirectController {

    private final RedirectService service;

    @GetMapping("{hash}")
    public String redirect(@PathVariable String hash) throws CustomErrorException, IOException {
        return service.redirectToRealUrl(hash);
    }

}
