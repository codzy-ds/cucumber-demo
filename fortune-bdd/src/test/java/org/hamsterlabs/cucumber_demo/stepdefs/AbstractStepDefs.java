package org.hamsterlabs.cucumber_demo.stepdefs;

import org.hamsterlabs.cucumber_demo.entities.BddContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
public abstract class AbstractStepDefs {

    protected String baseUrl = "http://localhost:8080";


    @Autowired
    protected RestTemplate restTemplate;

    @Autowired
    protected BddContext bddContext;

    protected void callService(Class<?> resposneType) {
        bddContext.setResponse(restTemplate.getForEntity(baseUrl + getPath(), resposneType));
    }

    protected abstract String getPath();
}
