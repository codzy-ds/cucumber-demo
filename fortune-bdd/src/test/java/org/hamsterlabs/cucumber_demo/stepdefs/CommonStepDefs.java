package org.hamsterlabs.cucumber_demo.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.en.Then;
import io.cucumber.spring.CucumberContextConfiguration;
import org.hamsterlabs.cucumber_demo.config.BddConfig;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = {org.hamsterlabs.cucumber_demo.CucumberDemoApplication.class, BddConfig.class}, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CommonStepDefs extends AbstractStepDefs {

    @Then("the http status is {int}")
    public void the_http_status_is(Integer status) {
        assertThat(bddContext.getStatusCode().value()).isEqualTo(status);
    }

    @Override
    protected String getPath() {
        return "";
    }
}
