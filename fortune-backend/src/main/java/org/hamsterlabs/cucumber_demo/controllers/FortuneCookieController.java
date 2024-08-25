package org.hamsterlabs.cucumber_demo.controllers;

import org.hamsterlabs.cucumber_demo.json.CookieJson;
import org.hamsterlabs.cucumber_demo.service.CookieJarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class FortuneCookieController {

    private final CookieJarService cookieJarService;

    @Autowired
    public FortuneCookieController(CookieJarService cookieJarService) {
        this.cookieJarService = cookieJarService;
    }

    @GetMapping("/cookie")
    public CookieJson getCookie() {
        return cookieJarService.getRandomCookie();
    }

    @GetMapping("/cookies")
    public List<CookieJson> getCookies() {
        return cookieJarService.getAllCookies();
    }

}
