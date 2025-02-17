package Page_Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteAccount_Page_Object {
    WebDriver driver;
    public DeleteAccount_Page_Object(WebDriver driver){
        this.driver = driver;
    }
    private By DeleteAccount = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a");
    private By DeleteAccountContinue = By.xpath("//*[@id=\"form\"]/div/div/div/div/a");

    public void DeleteAccountButton(){
        driver.findElement(DeleteAccount).click();
    }

    public void DeleteAccountContinueButton(){
        driver.findElement(DeleteAccountContinue).click();
    }
}
