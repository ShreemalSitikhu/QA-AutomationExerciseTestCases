import Page_Object.Product_Page_Object;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddReviewOnProducts {
    WebDriver driver;

    @BeforeClass
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\IdeaProjects\\TechAxisProject\\src\\test\\chromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/");
    }

    @Test
    public void addReviewOnProducts(){
        Product_Page_Object product = new Product_Page_Object(driver);
        product.ClickProductBtn();

        //verify user is navigated to ALL PRODUCTS page successfully
        WebElement allProductsPage = driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div/h2"));
        String allProductsText = allProductsPage.getText();
        Assert.assertEquals(allProductsText,"ALL PRODUCTS");

        product.ClickProduct1ViewDetail();
        //verify 'Write Your Review' is visible
        WebElement review = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[3]/div[1]/ul/li/a"));
        String ReviewTextCheck = review.getText();
        Assert.assertEquals(ReviewTextCheck,"WRITE YOUR REVIEW");

        product.EnterNameinReview("Shreemal Sitikhu");
        product.EnterEmailinReview("shreemalsitikhu@gmail.com");
        product.EnterReviewNoteHere("This is the review note on this review textarea.");
        product.ClickSubmitBtnInReview();

        //verify success message 'Thank you for your review'.
        WebElement successMessage = driver.findElement(By.xpath("//*[@id=\"review-section\"]/div/div/span"));
        String message = successMessage.getText();
        Assert.assertEquals(message,"Thank you for your review.");
    }
    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
