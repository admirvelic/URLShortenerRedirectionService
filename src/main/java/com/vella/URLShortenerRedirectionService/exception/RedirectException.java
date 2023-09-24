package com.vella.URLShortenerRedirectionService.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class RedirectException extends RuntimeException {
    private HttpStatus status;

    private Object data;

    public RedirectException(String s, Exception e) {
        super();
    }

    public RedirectException(String message) {
        super(message);
    }

    public RedirectException(HttpStatus status, String message) {
        this(message);
        this.status = status;
    }

    public RedirectException(HttpStatus status, String message, Object data) {
        this(status, message);
        this.data = data;
    }
}
