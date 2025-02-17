import Page_Object.Login_Page_Object;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginUserWithIncorrectEmailAndPassword {
    WebDriver driver;

    @BeforeClass
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\IdeaProjects\\TechAxisProject\\src\\test\\chromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/");
    }

    @Test
    public void LoginUserWithIncorrectCredentials() {
        Login_Page_Object login = new Login_Page_Object(driver);

        //verify homepage is visible
        WebElement homePage = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a"));
        String actualResults = homePage.getText();
        Assert.assertEquals(actualResults, "Home");

        //Click on 'Signup/Login' button
        login.Signup_LoginButton();

        //verify Login to your account is visible
        WebElement a = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/h2"));
        String actualResult = a.getText();
        Assert.assertEquals(actualResult,"Login to your account");

        login.EnterEmail("shreemal@gmail.com");
        login.EnterPassword("cmalctkhu1");
        login.ClickOnLoginButton();

        //verify Your email or password is incorrect! is visible
        WebElement valueIncorrectMessage = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/p"));
        String incorrectValue = valueIncorrectMessage.getText();
        Assert.assertEquals(incorrectValue,"Your email or password is incorrect!");
    }
    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
