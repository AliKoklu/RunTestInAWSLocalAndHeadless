package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(

//        With a plugin we are able to create multiple types of reports.
        plugin = {
                "html:target/cucumber-report",
                "json:target/cucumber.json"
        },

        features = {"src/test/java/Feature"},
        glue = {"StepDefinition"},
        dryRun = false

)

public class RegressionRunner extends AbstractTestNGCucumberTests {
}
