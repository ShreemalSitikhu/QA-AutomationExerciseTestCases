import Page_Object.Product_Page_Object;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddProductsInCart {
    WebDriver driver;
    @BeforeClass
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\IdeaProjects\\TechAxisProject\\src\\test\\chromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/");
    }
    @Test
    public void addProductsInCart() throws InterruptedException {
        Product_Page_Object product = new Product_Page_Object(driver);
        //verify homepage is visible
        WebElement homePage = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a"));
        String actualResults = homePage.getText();
        Assert.assertEquals(actualResults, "Home");

        product.ClickProductBtn();
        product.AddToCartproduct1();
        Thread.sleep(1000);
        product.ClickContinueShopping();

        product.AddToCartProduct2();
        Thread.sleep(1000);
        product.Product2ViewCartBtn();

        //verify both products are added to Cart
        WebElement Product1 = driver.findElement(By.xpath("//*[@id=\"product-1\"]/td[2]"));
        Boolean item1 = Product1.isDisplayed();
        Assert.assertTrue(item1);

        WebElement Product2 = driver.findElement(By.xpath("//*[@id=\"product-2\"]/td[2]"));
        Boolean item2 = Product2.isDisplayed();
        Assert.assertTrue(item2);

        //verify their prices,quantity and total price
        WebElement Product1price = driver.findElement(By.xpath("//*[@id=\"product-1\"]/td[3]/p"));
        Boolean price1 = Product1price.isDisplayed();
        Assert.assertTrue(price1);

        WebElement Product1quantity = driver.findElement(By.xpath("//*[@id=\"product-1\"]/td[4]/button"));
        Boolean quantity1 = Product1quantity.isDisplayed();
        Assert.assertTrue(quantity1);

        WebElement Product1TotalPrice = driver.findElement(By.xpath("//*[@id=\"product-1\"]/td[5]/p"));
        Boolean TotalPrice1 = Product1TotalPrice.isDisplayed();
        Assert.assertTrue(TotalPrice1);

        WebElement Product2price = driver.findElement(By.xpath("//*[@id=\"product-2\"]/td[3]/p"));
        Boolean price2 = Product2price.isDisplayed();
        Assert.assertTrue(price2);

        WebElement Product2quantity = driver.findElement(By.xpath("//*[@id=\"product-2\"]/td[4]/button"));
        Boolean quantity2 = Product2quantity.isDisplayed();
        Assert.assertTrue(quantity2);

        WebElement Product2TotalPrice = driver.findElement(By.xpath("//*[@id=\"product-2\"]/td[5]/p"));
        Boolean TotalPrice2 = Product2TotalPrice.isDisplayed();
        Assert.assertTrue(TotalPrice2);
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
