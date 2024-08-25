package org.hamsterlabs.cucumber_demo.controllers;

import org.hamsterlabs.cucumber_demo.repository.LoadCookies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FortuneCookieController {

    private final LoadCookies loadCookies;

    @Autowired
    public FortuneCookieController(LoadCookies loadCookies) {
        this.loadCookies = loadCookies;
    }

    @GetMapping("/cookie")
    public String getCookie() {
        return loadCookies.getRandomCookie();
    }

    @GetMapping("/cookies")
    public String getCookies() {
        return "You will have a great day!";
    }

}
