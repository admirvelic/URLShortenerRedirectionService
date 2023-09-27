package com.vella.URLShortenerRedirectionService.repository;

import com.vella.URLShortenerRedirectionService.model.Url;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepo extends CrudRepository<Url, String> {

    Url findByShortURL(String shortURL);
}