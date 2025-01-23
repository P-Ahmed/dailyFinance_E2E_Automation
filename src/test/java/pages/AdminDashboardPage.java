package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utils.BrowserFactory;
import utils.Utility;

import java.util.List;

public class AdminDashboardPage extends BasePage {
    @FindBy(css = "button")
    List<WebElement> viewButton;
    @FindBy(xpath = "//button[contains(text(),'Edit')]")
    WebElement editButton;
    @FindBy(xpath = "//button[contains(text(),'Update')]")
    WebElement updateButton;
    @FindBy(xpath = "//button[contains(text(),'Delete')]")
    WebElement deleteButton;
    @FindBy(name = "firstName")
    WebElement firstNameField;
    @FindBy(css = "button[aria-label='account of current user']")
    WebElement userMenuButton;
    @FindBy(xpath = "//li[contains(text(),'Logout')]")
    WebElement logoutList;
    @FindBy(className = "search-box")
    WebElement searchBoxField;
    @FindBy(className = "no-data")
    WebElement searchValidationMessage;

    public AdminDashboardPage() {
        PageFactory.initElements(BrowserFactory.getDriver(), this);
    }

    public void goToUserProfile() {
        viewButton.get(1).click();
    }

    public void deleteUser(){
        waitAndClick(deleteButton);
        acceptAlerts();
        acceptAlerts();
    }

    public void editUserDetails() throws InterruptedException {
        waitAndClick(viewButton.get(2));
        Thread.sleep(3000);
        waitAndClick(editButton);

        clearAndType(firstNameField, "abcd");
        waitAndClick(updateButton);
        acceptAlerts();
    }

    public void logout(){
        waitAndClick(userMenuButton);
        waitAndClick(logoutList);
    }

    public void searchByEmail(){
        clearAndType(searchBoxField, Utility.readJSONFile("email"));
        searchingEmailInTable(Utility.readJSONFile("email"));
    }

    public void searchingEmailInTable(String email) {
        WebElement element = BrowserFactory.getDriver().findElement(By.xpath("//td[contains(text()," + email + ")]"));
        wait.until(ExpectedConditions.visibilityOf(element));
        Assert.assertEquals(element.getText(), Utility.readJSONFile("email"));
    }

    public void invalidSearching(){
        clearAndType(searchBoxField, "3445345ikjdf");
        Assert.assertEquals(searchValidationMessage.getText(), "No users found");
    }
}
