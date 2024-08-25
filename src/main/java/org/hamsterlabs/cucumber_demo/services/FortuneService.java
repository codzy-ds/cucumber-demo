package org.hamsterlabs.cucumber_demo.services;

import java.util.List;
import org.hamsterlabs.cucumber_demo.json.CookieJson;

public interface FortuneService {

    CookieJson getRandomFortune();

    List<CookieJson> getAllFortunes();

    void saveFortune(CookieJson cookie);
}
