import Page_Object.Login_Page_Object;
import Page_Object.Product_Page_Object;
import Page_Object.Registration_Page_Object;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchProductsAndVerifyCartAfterLogin {
    WebDriver driver;
    @BeforeClass
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\IdeaProjects\\TechAxisProject\\src\\test\\chromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/");
    }
    @Test(priority = 1)
    public void SearchProducts() throws InterruptedException {
        Product_Page_Object product = new Product_Page_Object(driver);
        product.ClickProductBtn();

        //verify user is navigated to ALL PRODUCTS page successfully
        WebElement allProductsPage = driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/h2"));
        String allProductsText = allProductsPage.getText();
        Assert.assertEquals(allProductsText,"ALL PRODUCTS");

        product.EnterProductNameToSearch("Tshirt");
        product.ClickSearchBtn();

        //verify searched products is visible
        WebElement searchedProducts = driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/h2"));
        String searchedProductsText = searchedProducts.getText();
        Assert.assertEquals(searchedProductsText,"SEARCHED PRODUCTS");

        //verify all the products related to search are visible
        WebElement productSearched = driver.findElement(By.xpath("//*[@id=\"search_product\"]"));
        Boolean Product = productSearched.isDisplayed();
        Assert.assertTrue(Product);

        product.AddtoCartSearchedProduct1();
        Thread.sleep(1000);
        product.ClickSearchedProduct1ContinueShopping();
        product.AddtoCartSearchedProduct2();
        Thread.sleep(1000);
        product.ClickSearchedProduct2ViewCart();

        //verify products are visible in cart
        WebElement product1 = driver.findElement(By.xpath("//*[@id=\"product-2\"]"));
        Boolean product1Visible = product1.isDisplayed();
        Assert.assertTrue(product1Visible);

        WebElement product2 = driver.findElement(By.xpath("//*[@id=\"product-28\"]"));
        Boolean product2Visible = product2.isDisplayed();
        Assert.assertTrue(product2Visible);
    }

    @Test(priority = 2)
    public void Signup_Login() throws InterruptedException {
        Login_Page_Object product = new Login_Page_Object(driver);
        product.Signup_LoginButton();
        product.EnterEmail("shreemalsitikhu@gmail.com");
        product.EnterPassword("cmalctkhu");
        product.ClickOnLoginButton();
        product.ClickCartBtn();

        //verify those products are visible in cart after login as well
        WebElement product1 = driver.findElement(By.xpath("//*[@id=\"product-2\"]"));
        Boolean product1Visible = product1.isDisplayed();
        Assert.assertTrue(product1Visible);

        WebElement product2 = driver.findElement(By.xpath("//*[@id=\"product-28\"]"));
        Boolean product2Visible = product2.isDisplayed();
        Assert.assertTrue(product2Visible);
    }
    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
