package pages;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserFactory;
import utils.Utility;

import java.io.IOException;

public class LoginPage extends BasePage {

    @FindBy(css = "a[href='/register']")
    WebElement registerLink;
    @FindBy(id = "email")
    WebElement emailField;
    @FindBy(id = "password")
    WebElement passwordField;
    @FindBy(css = "button[type='submit']")
    WebElement loginButton;
    @FindBy(className = "total-count")
    WebElement totalUsersLabel;
    @FindBy(tagName = "p")
    WebElement loginValidationMessage;
    @FindBy(tagName = "h1")
    WebElement loginHeading;

    public LoginPage() {
        PageFactory.initElements(BrowserFactory.getDriver(), this);
    }

    public void goToRegisterPage() {
        registerLink.click();
    }

    public void loginByCommandLine() {
        clickAndType(emailField, System.getProperty("email"));
        clickAndType(passwordField, System.getProperty("password"));
        waitAndClick(loginButton);
        Assert.assertTrue(totalUsersLabel.getText().contains("Total Users"));
    }

    public void loginByJsonRead() throws IOException, ParseException, InterruptedException {
        elementIsVisible(loginHeading);
        Thread.sleep(3000);
        clickAndType(emailField, Utility.readJSONFile("email"));
        clickAndType(passwordField, Utility.readJSONFile("password"));
        waitAndClick(loginButton);
        Assert.assertTrue(totalUsersLabel.getText().contains("Total Users"));
    }

    public void loginValidation() {
        clickAndType(emailField, "adm@test.com");
        clickAndType(passwordField, "werwer234");
        waitAndClick(loginButton);
        Assert.assertEquals(loginValidationMessage.getText(), "Invalid email or password");
        clearField(emailField);
        clearField(passwordField);
    }

}
