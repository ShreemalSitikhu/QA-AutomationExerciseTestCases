import Page_Object.ContactUs_Page_Object;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ContactUsForm {
    WebDriver driver;

    @BeforeClass
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\IdeaProjects\\TechAxisProject\\src\\test\\chromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/");
    }

    @Test
    public void ContactUs(){
        ContactUs_Page_Object contact = new ContactUs_Page_Object(driver);

        //verify homepage is visible
        WebElement homePage = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a"));
        String actualResults = homePage.getText();
        Assert.assertEquals(actualResults, "Home");

        contact.ContactUsButton();

        //verify GET IN TOUCH is visible
        WebElement getInTouch = driver.findElement(By.xpath("//*[@id=\"contact-page\"]/div[2]/div[1]/div/h2"));
        String getInTouchText = getInTouch.getText();
        Assert.assertEquals(getInTouchText,"GET IN TOUCH");

        contact.EnterName("Shreemal");
        contact.EnterEmail("shreemalsitikhu@gmail.com");
        contact.EnterSubject("Maths");
        contact.EnterMessageHere("This is contact us form message");
        contact.UploadFile("C:\\Users\\user\\IdeaProjects\\FinalTechAxisAutomationProject\\src\\test\\images\\SidhiKali-Thimi.jpg");
        contact.ClickSubmitBtn();

        Alert alert = driver.switchTo().alert(); // Switch to the alert
        String alertMessage = alert.getText(); // Get the text from the alert
        System.out.println("Popup message: " + alertMessage); // Optional: Print the alert message
        alert.accept();

        //verify for Success! Your details have been submitted successfully. is visible
        WebElement successMessage = driver.findElement(By.xpath("//*[@id=\"contact-page\"]/div[2]/div[1]/div/div[2]"));
        String successMessageText = successMessage.getText();
        Assert.assertEquals(successMessageText,"Success! Your details have been submitted successfully.");

        contact.ClickHomeBtn();

        //verify homepage is visible
        WebElement backToHomePage = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a"));
        String homepageResult = backToHomePage.getText();
        Assert.assertEquals(homepageResult, "Home");
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
