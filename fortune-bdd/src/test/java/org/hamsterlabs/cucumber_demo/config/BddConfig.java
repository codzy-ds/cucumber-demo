package org.hamsterlabs.cucumber_demo.config;

import io.cucumber.spring.CucumberContextConfiguration;
import org.hamsterlabs.cucumber_demo.CucumberDemoApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@CucumberContextConfiguration
@SpringBootTest(classes = CucumberDemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class BddConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
