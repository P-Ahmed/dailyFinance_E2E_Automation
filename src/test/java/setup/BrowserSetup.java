package setup;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.BrowserFactory;

public class BrowserSetup {

    @BeforeTest
    public void openBrowser() {

        BrowserFactory.getDriver().get("https://dailyfinance.roadtocareer.net/login");
    }

//    @AfterTest
//    public void closeBrowser() {
//        BrowserFactory.quitDriver();
//    }

}
