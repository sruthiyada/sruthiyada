package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/main/resources/Features/"},
        glue = {"stepDefinition"},
        plugin={"html:target/cucumber-report.html"}

)


public class TestRunner {

}
