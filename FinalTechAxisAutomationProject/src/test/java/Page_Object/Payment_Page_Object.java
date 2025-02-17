package Page_Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Payment_Page_Object {
    WebDriver driver;
    public Payment_Page_Object(WebDriver driver){
        this.driver = driver;
    }

    private By NameOnCard = By.xpath("//*[@id=\"payment-form\"]/div[1]/div/input");
    private By CardNumber = By.xpath("//*[@id=\"payment-form\"]/div[2]/div/input");
    private By CVC = By.xpath("//*[@id=\"payment-form\"]/div[3]/div[1]/input");
    private By ExpiryMonth = By.xpath("//*[@id=\"payment-form\"]/div[3]/div[2]/input");
    private By ExpiryYear = By.xpath("//*[@id=\"payment-form\"]/div[3]/div[3]/input");
    private By PayandConfirmOrder = By.xpath("//*[@id=\"submit\"]");
    private By DownloadInvoice = By.xpath("//*[@id=\"form\"]/div/div/div/a");

    public void EnterNameOnCard(String name){
        driver.findElement(NameOnCard).sendKeys(name);
    }

    public void EnterCardNumber(String cardNumber){
        driver.findElement(CardNumber).sendKeys(cardNumber);
    }

    public void EnterCVC(String cvc){
        driver.findElement(CVC).sendKeys(cvc);
    }

    public void EnterExpiryMonth(String month){
        driver.findElement(ExpiryMonth).sendKeys(month);
    }

    public void EnterExpiryYear(String year){
        driver.findElement(ExpiryYear).sendKeys(year);
    }

    public void ClickPayandConfirmOrder(){
        driver.findElement(PayandConfirmOrder).click();
    }

    public void ClickDownloadInvoice(){driver.findElement(DownloadInvoice).click();}
}
