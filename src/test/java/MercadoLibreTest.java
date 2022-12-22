import Pages.HomePage;
import Pages.ProductPage;
import Pages.ResultSearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MercadoLibreTest {

    WebDriver driver;

    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "./src/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }

    private void goToLink(String link){
        driver.get(link);
    }

    @Test
    public void testMeli(){
        String link = "https://www.mercadolibre.com.ar/";
        goToLink(link);
        HomePage homePage = new HomePage(driver);
        homePage.completeWithProduct("auto");
        homePage.selectSearch();

        ResultSearchPage resultSearchPage = new ResultSearchPage(driver);
        Assert.assertEquals("Precio", resultSearchPage.getPrice());
        Assert.assertEquals("Condición", resultSearchPage.getCondition());
        resultSearchPage.selectFirstProduct();

        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }

        ProductPage productPage = new ProductPage(driver);
        productPage.selectSecondImage();
        Assert.assertEquals(productPage.getPrice(), "15.099.000");

    }
}
