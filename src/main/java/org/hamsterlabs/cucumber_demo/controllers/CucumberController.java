package org.hamsterlabs.cucumber_demo.controllers;

import java.util.List;
import org.hamsterlabs.cucumber_demo.json.CookieJson;
import org.hamsterlabs.cucumber_demo.services.FortuneService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cookie")
public class CucumberController {

    private FortuneService fortuneService;

    public CucumberController(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @GetMapping("/open")
    public CookieJson openCookie() {
        return fortuneService.getRandomFortune();
    }

    @GetMapping("/indigestion")
    public List<CookieJson> indigestion() {
        return fortuneService.getAllFortunes();
    }

    @PostMapping("/putcookieinjar")
    public String putCookieInJar(@RequestBody CookieJson cookie) {
        fortuneService.saveFortune(cookie);
        return "Cookie in jar : " + cookie;
    }

}
