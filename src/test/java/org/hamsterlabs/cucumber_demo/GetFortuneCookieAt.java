package org.hamsterlabs.cucumber_demo;

import io.cucumber.junit.platform.engine.Constants;
import io.cucumber.spring.CucumberContextConfiguration;
import org.hamsterlabs.cucumber_demo.config.BddConfig;
import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.Suite;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@Suite
@IncludeEngines({"cucumber"})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = CucumberDemoApplication.class)
@CucumberContextConfiguration
@ContextConfiguration
@ConfigurationParameter(key = Constants.FEATURES_PROPERTY_NAME, value = "src/test/resources/org/hamsterlabs/cucumber_demo/GetCookie.feature")
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value = "org.hamsterlabs.cucumber_demo.stepdefs")
@ExcludeTags({"wip", "unittest", "integrationtest", "manualtest", "manual"})
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, value = "pretty, html:target/cucumber-report/cucumber-create-test-request.html, json:target/cucumber-report/cucumber-create-test-request.json")
public class GetFortuneCookieAt {
    @Test
    public void loadContext() {
        // nothing
    }
}
