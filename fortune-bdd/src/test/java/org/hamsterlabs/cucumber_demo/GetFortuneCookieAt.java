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
import org.springframework.test.context.TestPropertySource;

@Suite
@IncludeEngines("cucumber")
@ContextConfiguration(classes = BddConfig.class)
@ConfigurationParameter(key = Constants.FEATURES_PROPERTY_NAME, value = "src/test/resources/org/hamsterlabs/cucumber_demo/GetCookie.feature")
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value = "org.hamsterlabs.cucumber_demo.stepdefs")
@ExcludeTags({"wip", "unittest", "integrationtest", "manualtest", "manual"})
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, value = "pretty, html:target/cucumber-report/cucumber-get-cookie.html, json:target/cucumber-report/cucumber-get-cookie.json")
public class GetFortuneCookieAt {
    // nothing
}
