package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BrowserFactory;

import java.time.Duration;

public class BasePage {
    WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), Duration.ofSeconds(5));

    public void waitAndClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void clearAndType(WebElement element, String text) {
        waitAndClick(element);
        element.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
        element.sendKeys(text);
    }

    public void clearField(WebElement element) {
        waitAndClick(element);
        element.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
    }

    public void elementIsVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickAndType(WebElement element, String text) {
        waitAndClick(element);
        element.sendKeys(text);
    }

    public void acceptAlerts() {
        try {
            Thread.sleep(1000);
            BrowserFactory.getDriver().switchTo().alert().accept();
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void browserBack() {
        BrowserFactory.getDriver().navigate().back();
    }

    public void browserRefresh() {
        BrowserFactory.getDriver().navigate().refresh();
    }
}
