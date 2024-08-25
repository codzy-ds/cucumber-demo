package org.hamsterlabs.cucumber_demo.controllers;

import org.hamsterlabs.cucumber_demo.json.CookieJson;
import org.hamsterlabs.cucumber_demo.repository.LoadCookies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class FortuneCookieController {

    private final LoadCookies loadCookies;

    @Autowired
    public FortuneCookieController(LoadCookies loadCookies) {
        this.loadCookies = loadCookies;
    }

    @GetMapping("/cookie")
    public CookieJson getCookie() {
        return loadCookies.getRandomCookie();
    }

    @GetMapping("/cookies")
    public List<CookieJson> getCookies() {
        return loadCookies.getAllCookies();
    }

}
