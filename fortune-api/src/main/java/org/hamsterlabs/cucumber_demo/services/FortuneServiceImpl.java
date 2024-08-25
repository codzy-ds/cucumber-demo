package org.hamsterlabs.cucumber_demo.services;

import java.util.List;
import org.hamsterlabs.cucumber_demo.json.CookieJson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FortuneServiceImpl implements FortuneService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${fortune.api.url}")
    private String fortuneApiUrl;

    @Override
    public CookieJson getRandomFortune() {
        return restTemplate.getForObject(fortuneApiUrl + "/cookie", CookieJson.class);
    }

    @Override
    public List<CookieJson> getAllFortunes() {
        ResponseEntity<List<CookieJson>> response = restTemplate.exchange(
            fortuneApiUrl + "/cookies",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<CookieJson>>() {
            }
        );
        return response.getBody();
    }

    @Override
    public void saveFortune(CookieJson cookie) {
        restTemplate.postForLocation(fortuneApiUrl + "/cookie", cookie);
    }

}
