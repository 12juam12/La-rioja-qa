package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    By SECOND_IMG = By.xpath("//img[contains(@alt , 'Imagen 2') and @class='ui-pdp-image']");
    By PRICE = By.xpath("//span[@class='andes-money-amount__fraction']");

    public void selectSecondImage(){
        clickElement(SECOND_IMG);
    }

    public String getPrice(){
        return findElementByLocator(PRICE).getText();
    }

}
