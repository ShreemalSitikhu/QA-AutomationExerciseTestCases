import Page_Object.Registration_Page_Object;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegisterUser {
    WebDriver driver;

    @BeforeClass
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\IdeaProjects\\TechAxisProject\\src\\test\\chromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/");
    }

    @Test
    public void registerUser() {
        Registration_Page_Object register = new Registration_Page_Object(driver);

        //verify homepage is visible
        WebElement homePage = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a"));
        String actualResults = homePage.getText();
        Assert.assertEquals(actualResults, "Home");

        //Click 'Signup / Login' button
        register.Signup_LoginButton();

        //verify New User Signup is visible
        WebElement a = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2"));
        String actualResult = a.getText();
        Assert.assertEquals(actualResult,"New User Signup!");

        register.EnterName("Shreemal Sitikhu");
        register.EnterEmail("shreemalsitikhu@gmail.com");
        register.SignupButton();

        //verify ENTER ACCOUNT INFORMATION is visible
        WebElement b = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/h2/b"));
        String c = b.getText();
        Assert.assertEquals(c,"ENTER ACCOUNT INFORMATION");

        // Enter Account Information
        register.Gender1();
        register.PasswordField("cmalctkhu");
        register.selectDay("6");
        register.selectMonth("February");
        register.selectYear("2001");
        register.NewsletterClick();
        register.OfferClick();

        //Address Information
        register.FirstnameField("Shreemal");
        register.LastnameField("Sitikhu");
        register.CompanyField("TechAxis");
        register.Address1Field("Goldmodi Bhaktapur");
        register.Address2Field(" Bhaktapur, Bagmati Nepal");
        register.CountryDropdown("India");
        register.StateField("Bagmati");
        register.CityField("Kathmandu");
        register.ZipcodeField("44600");
        register.MobileField("9876543210");
        register.CreateAccount();

        //verify ACCOUNT CREATED! is visible
        WebElement accountCreated = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b"));
        String actualAccountCreated = accountCreated.getText();
        Assert.assertEquals(actualAccountCreated,"ACCOUNT CREATED!");

        //Click Continue button of Account Created
        register.AccountCreateContinueButton();

        //verify Logged in as Shreemal Sitikhu
        WebElement loggedinAsUsername = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a"));
        String actualUsername = loggedinAsUsername.getText();
        Assert.assertEquals(actualUsername,"Logged in as Shreemal Sitikhu");

       // Delete Account
        register.DeleteAccountButton();

        //verify ACCOUNT DELETED! is visible
        WebElement accountDeleted = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b"));
        String actualAccountDeletedMessage = accountDeleted.getText();
        Assert.assertEquals(actualAccountDeletedMessage,"ACCOUNT DELETED!");

        //Click Continue button of Delete Account
        register.DeleteAccountContinueButton();
    }
    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }

}
