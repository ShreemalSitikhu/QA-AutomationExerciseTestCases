import Page_Object.ProductQuantityInCart_Object_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VerifyProductQuantityInCart {
    WebDriver driver;
    @BeforeClass
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\IdeaProjects\\TechAxisProject\\src\\test\\chromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/");
    }

    @Test
    public void productQuantityInCart() throws InterruptedException {
        ProductQuantityInCart_Object_Page product = new ProductQuantityInCart_Object_Page(driver);

        //verify homepage is visible
        WebElement homePage = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a"));
        String actualResults = homePage.getText();
        Assert.assertEquals(actualResults, "Home");

        //click view product for second product on homepage
        product.viewProduct();

        //verify product detail is opened
        WebElement productDetail = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div"));
        Boolean detail = productDetail.isDisplayed();
        Assert.assertTrue(detail);

        //Increase quantity to 4
        product.IncreaseQuantity("4");
        Thread.sleep(100);

        //add to cart
        product.AddToCart();
        Thread.sleep(1000);

        //View cart
        product.ViewCart();

        //verify product is displayed in cart page with exact quantity(4)
        WebElement Product = driver.findElement(By.xpath("//*[@id=\"product-2\"]/td[2]/p"));
        Boolean productName = Product.isDisplayed();
        Assert.assertTrue(productName);

        WebElement QuantityCheck = driver.findElement(By.xpath("//*[@id=\"product-2\"]/td[4]/button"));
        String quantity = QuantityCheck.getText();
        Assert.assertEquals(quantity,"4");
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
