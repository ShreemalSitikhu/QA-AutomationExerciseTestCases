import Page_Object.Registration_Page_Object;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegisterUserWithExistingEmail {
    WebDriver driver;

    @BeforeClass
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\IdeaProjects\\TechAxisProject\\src\\test\\chromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/");
    }

    @Test
    public void RegisterUserWithExistingEmail(){
        Registration_Page_Object register = new Registration_Page_Object(driver);

        //verify homepage is visible
        WebElement homePage = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a"));
        String actualResults = homePage.getText();
        Assert.assertEquals(actualResults, "Home");

        register.Signup_LoginButton();

        //verify New User Signup is visible
        WebElement a = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2"));
        String actualResult = a.getText();
        Assert.assertEquals(actualResult,"New User Signup!");

        register.EnterName("Cmal Sitikhu");
        register.EnterEmail("shreemalsitikhu@gmail.com");
        register.SignupButton();

        //Verify Email Address already exist! is visible
        WebElement EmailAddressExists = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/p"));
        String emailAddressExistsMessage = EmailAddressExists.getText();
        Assert.assertEquals(emailAddressExistsMessage,"Email Address already exist!");
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
