package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (
		features = "src\\test\\java\\features",
		glue = "stepDefination",
		tags = "@knowitSuite",
		plugin = {"pretty","html:target/cucumber.html", "json:target/jsonReport.json", "junit:target/cukes.xml"}
		)
public class TestRunner extends AbstractTestNGCucumberTests{

	
}
