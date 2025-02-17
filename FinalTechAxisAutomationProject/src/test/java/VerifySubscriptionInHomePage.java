import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VerifySubscriptionInHomePage {
    WebDriver driver;
    @BeforeClass
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\IdeaProjects\\TechAxisProject\\src\\test\\chromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/");
    }

    @Test
    public void subscriptionInHomePage() throws InterruptedException {
        //verify homepage is visible
        WebElement homePage = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a"));
        String actualResults = homePage.getText();
        Assert.assertEquals(actualResults, "Home");

        //Scroll down to footer
        WebElement scrollFooter = driver.findElement(By.cssSelector("footer"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", scrollFooter);
        Thread.sleep(1000);

        //verify Subscription text
        WebElement subscription = driver.findElement(By.xpath("//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2"));
        String subscriptionText = subscription.getText();
        Assert.assertEquals(subscriptionText,"SUBSCRIPTION");

        WebElement email = driver.findElement(By.id("susbscribe_email"));
        email.sendKeys("shreemalsitikhu@gmail.com");

        WebElement subscribeArrow = driver.findElement(By.id("subscribe"));
        subscribeArrow.click();

        //Verify success message 'You have been successfully subscribed!' is visible
        WebElement alert = driver.findElement(By.id("success-subscribe"));
        String alertMessage = alert.getText();
        Assert.assertEquals(alertMessage,"You have been successfully subscribed!");
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
