package test.runner;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegisterPage;
import setup.BrowserSetup;

public class RegisterTestRunner extends BrowserSetup {
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();

    @Test
    public void doRegistration() throws InterruptedException {
        loginPage.goToRegisterPage();
        registerPage.doRegistar();
    }

}
