package org.hamsterlabs.cucumber_demo.service;

import org.hamsterlabs.cucumber_demo.json.CookieJson;
import org.hamsterlabs.cucumber_demo.persistence.entities.CookieEntity;
import org.hamsterlabs.cucumber_demo.persistence.repository.CookieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class CookieJarService {

    private final CookieRepository cookieRepository;

    public CookieJarService(CookieRepository cookieRepository) {
        this.cookieRepository = cookieRepository;
    }

    public CookieJson getRandomCookie() {
        long count = cookieRepository.count();
        if (count == 0) {
            return null; // or throw an exception if preferred
        }
        long randomId = new Random().nextLong(count) + 1;
        Optional<CookieEntity> randomCookie = cookieRepository.findById(randomId);
        return randomCookie.map(cookie -> new CookieJson(cookie.getQuote(), cookie.getCategory(), cookie.getSignature()))
                .orElse(null);
    }

    public List<CookieJson> getAllCookies() {
        return cookieRepository.findAll().stream().map(cookie -> new CookieJson(cookie.getQuote(), cookie.getCategory(), cookie.getSignature())).toList();
    }
}
