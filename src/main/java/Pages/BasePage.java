package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void completeElement(By locator , String content){
        findElementByLocator(locator).sendKeys(content);
    }
    public void completeElement(By locator , Keys key){
        findElementByLocator(locator).sendKeys(key);
    }
    public WebElement findElementByLocator(By locator){
        return driver.findElement(locator);
    }

    public void clickElement(By locator){
        findElementByLocator(locator).click();
    }
}
