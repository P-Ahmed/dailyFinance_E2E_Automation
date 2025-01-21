package test.runner;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import pages.LoginPage;
import setup.BrowserSetup;

import java.io.IOException;

public class LoginTestCase extends BrowserSetup {
    LoginPage loginPage = new LoginPage();

    @Test(priority = 2, description = "verify user can login with valid credentials", groups = {"regression", "smoke"})
    public void doLogin() throws IOException, ParseException, InterruptedException {
        loginPage.loginByCommandLine();
    }

    @Test(priority = 1, description = "verify user cannot login with invalid credentials", groups = {"regression"})
    public void userLoginValidation() {
        loginPage.loginValidation();
    }
}