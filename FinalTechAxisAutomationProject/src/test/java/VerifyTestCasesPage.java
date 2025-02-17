import Page_Object.TestCases_Page_Object;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VerifyTestCasesPage {
    WebDriver driver;

    @BeforeClass
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\IdeaProjects\\TechAxisProject\\src\\test\\chromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/");
    }

    @Test
    public void TestCases(){
        TestCases_Page_Object testCase = new TestCases_Page_Object(driver);

        //verify homepage is visible
        WebElement homePage = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a"));
        String actualResults = homePage.getText();
        Assert.assertEquals(actualResults, "Home");

        //Click on 'Test Cases' button
        testCase.TestCasesBtn();

        //verify user is navigated to test cases page successfully
        WebElement TestCase = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div[2]/h5/span"));
        String testCaseText = TestCase.getText();
        Assert.assertEquals(testCaseText,"Below is the list of test Cases for you to practice the Automation. Click on the scenario for detailed Test Steps:");
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
