package org.mobile;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features/", glue="org.mobile",
        plugin = "json:target/destination/cucumber.json",
        tags= "@PhoneDialerApp")
public class DefinitionTestSuite {}
