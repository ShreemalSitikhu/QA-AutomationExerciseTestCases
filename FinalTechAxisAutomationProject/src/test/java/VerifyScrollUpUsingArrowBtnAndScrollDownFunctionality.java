import Page_Object.Scroll_Page_Object;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VerifyScrollUpUsingArrowBtnAndScrollDownFunctionality {
    WebDriver driver;
    @BeforeClass
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\IdeaProjects\\TechAxisProject\\src\\test\\chromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/");
    }
    @Test
    public void ScrollUpUsingArrowBtn() throws InterruptedException {
        Scroll_Page_Object scroll = new Scroll_Page_Object(driver);
        //verify homepage is visible
        WebElement homePage = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a"));
        String actualResults = homePage.getText();
        Assert.assertEquals(actualResults, "Home");

        //Scroll down to footer
        WebElement scrollFooter = driver.findElement(By.cssSelector("footer"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", scrollFooter);
        Thread.sleep(1000);

        //verify Subscription is visible
        WebElement subscription = driver.findElement(By.xpath("//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2"));
        String subscriptionText = subscription.getText();
        Assert.assertEquals(subscriptionText,"SUBSCRIPTION");

        scroll.ClickScrollUpBtn();
        Thread.sleep(1000);

        /*Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers'
         text is visible on screen */
       WebElement afterScroll = driver.findElement(By.xpath("//h2[contains(text(), 'Full-Fledged practice website for Automation Engineers')]"));
       String text = afterScroll.getText();
       Assert.assertEquals(text,"Full-Fledged practice website for Automation Engineers");
    }
    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
