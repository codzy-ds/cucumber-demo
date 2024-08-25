package org.hamsterlabs.cucumber_demo.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;

public class GetAllCookies extends AbstractStepDefs {

    @When("I get all the cookies")
    public void i_get_all_cookies() {
        this.callService(List.class);
    }

    @Then("I receive {int} cookies")
    public void i_receive_a_cookies(Integer count) {
        List cookies = this.bddContext.getResponseBody(List.class);
        assertThat(cookies).hasSize(count);
    }

    @Override
    protected String getPath() {
        return "/cookie/indigestion";
    }
}
