package Page_Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUs_Page_Object {
    WebDriver driver;
    public ContactUs_Page_Object(WebDriver driver){
        this.driver = driver;
    }
    private By ContactUs = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[8]/a");
    private By NameField = By.xpath("//*[@id=\"contact-us-form\"]/div[1]/input");
    private By EmailField = By.xpath("//*[@id=\"contact-us-form\"]/div[2]/input");
    private By SubjectField = By.xpath("//*[@id=\"contact-us-form\"]/div[3]/input");
    private By MessageHereField = By.xpath("//textarea[@placeholder='Your Message Here']");
    private By ChooseFile = By.xpath("//*[@id=\"contact-us-form\"]/div[5]/input");
    private By SubmitBtn = By.xpath("//*[@id=\"contact-us-form\"]/div[6]/input");
    private By Home = By.xpath("//*[@id=\"form-section\"]/a/span");

    public void ContactUsButton(){
        driver.findElement(ContactUs).click();
    }

    public void EnterName(String name){
        driver.findElement(NameField).sendKeys(name);
    }

    public void EnterEmail(String email){
        driver.findElement(EmailField).sendKeys(email);
    }

    public void EnterSubject(String subject){
        driver.findElement(SubjectField).sendKeys(subject);
    }

    public void EnterMessageHere(String message){
        driver.findElement(MessageHereField).sendKeys(message);
    }

    public  void UploadFile(String file){
       driver.findElement(ChooseFile).sendKeys(file);
    }

    public void ClickSubmitBtn(){
        driver.findElement(SubmitBtn).submit();
    }

    public void ClickHomeBtn(){
        driver.findElement(Home).click();
    }
}
