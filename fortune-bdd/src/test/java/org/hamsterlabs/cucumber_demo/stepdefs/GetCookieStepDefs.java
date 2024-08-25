package org.hamsterlabs.cucumber_demo.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamsterlabs.cucumber_demo.json.CookieJson;

public class GetCookieStepDefs extends AbstractStepDefs {


    @When("I get a cookie")
    public void i_get_a_cookie() {
        this.callService(CookieJson.class);
    }

    @Then("I have a cookie")
    public void i_have_a_cookie() {
        assertThat(this.bddContext.getResponseBody(CookieJson.class)).extracting(CookieJson::quote).isNotNull();
    }

    @Override
    protected String getPath() {
        return "/cookie/open";
    }
}
