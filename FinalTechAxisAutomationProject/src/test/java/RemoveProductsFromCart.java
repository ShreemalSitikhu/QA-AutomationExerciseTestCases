import Page_Object.Product_Page_Object;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RemoveProductsFromCart {
    WebDriver driver;

    @BeforeClass
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\IdeaProjects\\TechAxisProject\\src\\test\\chromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/");
    }
    @Test
    public void removeProduct() throws InterruptedException {
        Product_Page_Object product = new Product_Page_Object(driver);

        //verify homepage is visible
        WebElement homePage = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a"));
        String actualResults = homePage.getText();
        Assert.assertEquals(actualResults, "Home");

        product.AddToCartproduct1();
        Thread.sleep(1000);
        product.Product1ViewCartBtn();

        //verify that Cart Page is displayed
        WebElement cartPage = driver.findElement(By.xpath("//*[@id=\"cart_items\"]/div/div[1]/ol/li[2]"));
        String ShoppingCartText = cartPage.getText();
        Assert.assertEquals(ShoppingCartText, "Shopping Cart");

        product.ClickCrossBtnProduct1();
        Thread.sleep(1000);

        // Verify the product is removed from the cart
        WebElement emptyCartMessage = driver.findElement(By.xpath("//*[@id=\"empty_cart\"]/p/b"));
        String CartEmptyMessage = emptyCartMessage.getText();
        Assert.assertEquals(CartEmptyMessage,"Cart is empty!");
    }
    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
