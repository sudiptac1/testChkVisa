package com.sudipta;

import org.junit.runner.RunWith;
import io.cucumber.junit.*;




@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/feature/",
        glue = {"com.sudipta.stepDefintions","com.sudipta.stepDefintions.ApiSteps"},
        plugin = { "pretty","json:target/cucumber-json/cucumber.json",
                "junit:target/cucumber-reports/Cucumber.xml","html:target/cucumber-reports/html.html"},
        tags = "@test1"

        )






public class TestRunner {

}



