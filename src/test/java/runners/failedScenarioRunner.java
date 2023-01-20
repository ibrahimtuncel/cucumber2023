package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

//calistirmak istenilen feature file belrtilir.
@CucumberOptions (
        plugin = {
                "pretty",
                "html:target/default-cucumber-reports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml",
                "rerun:target/failedRerun.txt",
        },
        //run edilen dosyanın path i
        features = "@target/failedRerun.txt",//zorunlu-path girmek gerek
        glue = "stepdefinitions",//zorunlu kalsor path i girildi
        tags = "@manager_login_test",//opsiyoneldir tag kullanılmassa runners tüm featureslari calistirir
        dryRun = false//or true- opsiyoneldir
)
public class failedScenarioRunner {
}
