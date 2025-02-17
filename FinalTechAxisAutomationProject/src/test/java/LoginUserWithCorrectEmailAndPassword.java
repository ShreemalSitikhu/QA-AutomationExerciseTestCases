import Page_Object.Login_Page_Object;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginUserWithCorrectEmailAndPassword {
    WebDriver driver;

    @BeforeClass
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\IdeaProjects\\TechAxisProject\\src\\test\\chromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/");
    }

    @Test
    public void LoginUserWithCorrectCredentials(){
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

        login.EnterEmail("shreemalsitikhu@gmail.com");
        login.EnterPassword("cmalctkhu");
        login.ClickOnLoginButton();

        //verify Logged in as username (Shreemal Sitikhu)
        WebElement loggedinAsUsername = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a"));
        String actualUsername = loggedinAsUsername.getText();
        Assert.assertEquals(actualUsername, "Logged in as Shreemal Sitikhu");

        login.DeleteAccountButton();

        //verify ACCOUNT DELETED! is visible
        WebElement accountDeleted = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b"));
        String actualAccountDeletedMessage = accountDeleted.getText();
        Assert.assertEquals(actualAccountDeletedMessage, "ACCOUNT DELETED!");
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
