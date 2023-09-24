package com.vella.URLShortenerRedirectionService.service;

import com.google.gson.Gson;
import com.vella.URLShortenerRedirectionService.exception.CustomErrorException;
import com.vella.URLShortenerRedirectionService.model.Action;
import com.vella.URLShortenerRedirectionService.model.Url;
import com.vella.URLShortenerRedirectionService.model.UrlMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public class ReceiverService {

    private final RedirectService service;
    private final Gson gson;

    public void receiveMessage(String message) {
        log.info("Received <" + message + ">");

        UrlMessage urlMessage = gson.fromJson(message, UrlMessage.class);

        Url url = new Url();
        url.setShortURL(urlMessage.getShortURL());
        url.setRealURL(urlMessage.getRealURL());

        if (urlMessage.getAction().equals(Action.SAVE)) {
            service.saveUrl(url);
        } else if (urlMessage.getAction().equals(Action.DELETE)) {
            service.deleteUrl(url);
        } else {
            throw new CustomErrorException("No action was set in the massage");
        }
    }
}
