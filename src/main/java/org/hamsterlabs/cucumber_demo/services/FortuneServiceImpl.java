package org.hamsterlabs.cucumber_demo.services;

import java.util.List;
import org.hamsterlabs.cucumber_demo.json.CookieJson;
import org.hamsterlabs.cucumber_demo.repository.LoadCookies;
import org.springframework.stereotype.Service;

@Service
public class FortuneServiceImpl implements FortuneService {

    private LoadCookies loadCookies;

    public FortuneServiceImpl(LoadCookies loadCookies) {
        this.loadCookies = loadCookies;
    }

      @Override
      public CookieJson getRandomFortune() {
          return loadCookies.getRandomCookie();
      }

      @Override
      public List<CookieJson> getAllFortunes() {
          return loadCookies.getAllCookies();
      }

      @Override
      public void saveFortune(CookieJson cookie) {
        loadCookies.saveCookie(cookie);
      }

}
