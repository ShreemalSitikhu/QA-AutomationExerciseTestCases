package Page_Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login_Page_Object {
    WebDriver driver;
    public Login_Page_Object(WebDriver driver){
        this.driver = driver;
    }
    private By Signup_Login = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
    private By emailField = By.name("email");
    private By passwordField = By.name("password");
    private By LoginButton = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button");
    private By DeleteAccount = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a");
    private By Logout = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
    private By CartBtn = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a");

    public void Signup_LoginButton(){
        driver.findElement(Signup_Login).click();
    }

    public void EnterEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    public void EnterPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void ClickOnLoginButton(){
        driver.findElement(LoginButton).click();
    }

    public void DeleteAccountButton(){
        driver.findElement(DeleteAccount).click();
    }

    public void LogoutButton(){
        driver.findElement(Logout).click();
    }

    public void ClickCartBtn(){
        driver.findElement(CartBtn).click();
    }
}
