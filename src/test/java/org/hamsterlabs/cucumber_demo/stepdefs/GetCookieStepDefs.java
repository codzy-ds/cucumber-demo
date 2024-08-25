package org.hamsterlabs.cucumber_demo.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.hamsterlabs.cucumber_demo.json.CookieJson;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@CucumberContextConfiguration
@SpringBootTest(classes = org.hamsterlabs.cucumber_demo.CucumberDemoApplication.class)
public class GetCookieStepDefs {

    private RestTemplate restTemplate = new RestTemplate();
    private CookieJson response;

    @When("I get a cookie")
    public void i_get_a_cookie() {
        String url = "http://localhost:8080/cookie/open";
        response = restTemplate.getForObject(url, CookieJson.class);
        System.out.println("Response: " + response);
    }

    @Then("I have a cookie")
    public void i_have_a_cookie() {
        assertThat(response).extracting(CookieJson::quote).isNotNull();
    }
}
