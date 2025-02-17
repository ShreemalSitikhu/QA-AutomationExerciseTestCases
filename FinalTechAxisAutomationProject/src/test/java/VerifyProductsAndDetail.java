import Page_Object.Product_Page_Object;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VerifyProductsAndDetail {
    WebDriver driver;
    @BeforeClass
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\IdeaProjects\\TechAxisProject\\src\\test\\chromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/");
    }
    @Test
    public void productsAndDetails (){
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

        //click on View Product of first product
        product.ClickProduct1ViewDetail();

        //verify the detail is visible: product name,category,price,availability,condition,brand
            WebElement productName = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/h2"));
            Boolean detail1 = productName.isDisplayed();
            Assert.assertTrue(detail1);

            WebElement category = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[1]"));
            Boolean detail2 = category.isDisplayed();
            Assert.assertTrue(detail2);

            WebElement price = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/span"));
            Boolean detail3 = price.isDisplayed();
            Assert.assertTrue(detail3);

            WebElement availability = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[2]"));
            Boolean detail4 = availability.isDisplayed();
            Assert.assertTrue(detail4);

            WebElement condition = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[3]"));
            Boolean detail5 = condition.isDisplayed();
            Assert.assertTrue(detail5);

            WebElement brand = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[4]"));
            Boolean detail6 = brand.isDisplayed();
            Assert.assertTrue(detail6);
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
