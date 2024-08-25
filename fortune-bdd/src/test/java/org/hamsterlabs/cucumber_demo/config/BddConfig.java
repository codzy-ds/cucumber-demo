package org.hamsterlabs.cucumber_demo.config;

import io.cucumber.spring.CucumberContextConfiguration;
import org.hamsterlabs.cucumber_demo.CucumberDemoApplication;
import org.hamsterlabs.cucumber_demo.FortuneCookieBackendApplication;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.client.RestTemplate;

@CucumberContextConfiguration
@SpringBootTest(classes = {org.hamsterlabs.cucumber_demo.CucumberDemoApplication.class, org.hamsterlabs.cucumber_demo.FortuneCookieBackendApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class BddConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public void fortuneCookieBackendApplication() {
        new SpringApplicationBuilder(FortuneCookieBackendApplication.class)
                .properties("server.port=8081") // Specify the port here
                .run();
    }

}
