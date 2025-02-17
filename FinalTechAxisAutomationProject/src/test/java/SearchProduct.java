import Page_Object.Product_Page_Object;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchProduct {
    WebDriver driver;
    @BeforeClass
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\IdeaProjects\\TechAxisProject\\src\\test\\chromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/");
    }

    @Test
    public void searchProduct(){
        Product_Page_Object product = new Product_Page_Object(driver);
        //verify homepage is visible
        WebElement homePage = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a"));
        String actualResults = homePage.getText();
        Assert.assertEquals(actualResults, "Home");

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
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
