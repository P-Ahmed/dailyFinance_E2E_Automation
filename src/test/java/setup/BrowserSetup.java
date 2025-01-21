package setup;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.BrowserFactory;

public class BrowserSetup {

    @BeforeTest(groups = {"regression", "smoke"})
    public void openBrowser() {
        BrowserFactory.getDriver().get("https://dailyfinance.roadtocareer.net/login");
    }

//    @AfterTest(groups = {"regression", "smoke"})
//    public void closeBrowser() {
//        BrowserFactory.quitDriver();
//    }

}
