package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

public class Hooks {
    @Before
    public void setUp(){
        System.out.println("Bu bir hooks @After methotudur.");
    }
    @After
    public void tearDown(Scenario scenario) {
        //screen shot almak icin getScreenshotAs metodunu kullandık
        final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);

        //screen shot scenario raporun eklenir
        if (scenario.isFailed()) {
            scenario.attach(screenshot, "image/png", "screenshot");
        }
    }
}
