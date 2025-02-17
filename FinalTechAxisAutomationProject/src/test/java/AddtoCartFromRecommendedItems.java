import Page_Object.Product_Page_Object;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddtoCartFromRecommendedItems {
    WebDriver driver;
    @BeforeClass
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\IdeaProjects\\TechAxisProject\\src\\test\\chromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/");
    }
    @Test
    public void addtoCartFromRecommendedItems() throws InterruptedException {
        Product_Page_Object product = new Product_Page_Object(driver);

        //Scroll down to Recommended Items
        WebElement recommendedSection = driver.findElement(By.xpath("//h2[text()='recommended items']"));
        // Use JavaScript Executor to scroll to the 'RECOMMENDED ITEMS' section
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", recommendedSection);

        //verify 'RECOMMENDED ITEMS' are visible
        WebElement recommendation = driver.findElement(By.xpath("//h2[text()='recommended items']"));
        String RecommendedItemText = recommendation.getText();
        Assert.assertEquals(RecommendedItemText,"RECOMMENDED ITEMS");
        Thread.sleep(1000);

        product.ClickAddtoCartRecommendedItemProduct1();
        Thread.sleep(1000);
        product.ClickViewCartRecommendedItemProduct1();

        //verify product is displayed in cart page
        WebElement productDisplay = driver.findElement(By.xpath("//*[@id=\"product-4\"]"));
        Boolean checkProductDisplayed = productDisplay.isDisplayed();
        Assert.assertTrue(checkProductDisplayed);
    }
    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
