package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserFactory;
import utils.Utility;

import java.io.IOException;

public class RegisterPage extends BasePage {

    @FindBy(id = "firstName")
    WebElement firstNameField;
    @FindBy(id = "email")
    WebElement emailField;
    @FindBy(id = "phoneNumber")
    WebElement phoneNumberField;
    @FindBy(id = "password")
    WebElement passwordField;
    @FindBy(css = "input[value='Female']")
    WebElement genderRadio;
    @FindBy(id = "register")
    WebElement registerButton;
    @FindBy(css = "input[type='checkbox']")
    WebElement termAndConditionsCheckBox;
    @FindBy(className = "Toastify__toast-body")
    WebElement registrationSuccessfulNotification;


    public RegisterPage() {
        PageFactory.initElements(BrowserFactory.getDriver(), this);
    }

    public void doRegistar() throws InterruptedException {

        String firstName = Utility.randomFirstName();
        String email = Utility.randomEmail();
        String phoneNumber = Utility.randomPhoneNumber();
        String password = Utility.randomPassword();

        Utility.writeJSONFile(firstName, email, phoneNumber, password);

        clearAndType(firstNameField, firstName);
        clearAndType(emailField, email);
        clearAndType(phoneNumberField, phoneNumber);
        clearAndType(passwordField, password);

        genderRadio.click();
        termAndConditionsCheckBox.click();
        registerButton.click();

        Thread.sleep(5000);
        Assert.assertTrue(registrationSuccessfulNotification.isDisplayed());
    }
}
