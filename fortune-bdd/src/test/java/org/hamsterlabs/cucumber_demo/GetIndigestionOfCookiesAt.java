package org.hamsterlabs.cucumber_demo;

import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@ConfigurationParameter(key = Constants.FEATURES_PROPERTY_NAME, value = "src/test/resources/org/hamsterlabs/cucumber_demo/GetIndigestionOfCookies.feature")
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value = "org.hamsterlabs.cucumber_demo.stepdefs")
@ExcludeTags({"wip", "unittest", "integrationtest", "manualtest", "manual"})
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, value = "pretty, html:target/cucumber-report/cucumber-get-indigestion.html, json:target/cucumber-report/cucumber-get-indigestion.json")
public class GetIndigestionOfCookiesAt {
    // nothing
}
