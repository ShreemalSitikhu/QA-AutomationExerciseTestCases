package Page_Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Scroll_Page_Object {
    WebDriver driver;
    public Scroll_Page_Object(WebDriver driver){
        this.driver = driver;
    }
    private By scrollUp = By.xpath("//*[@id=\"scrollUp\"]");

    public void ClickScrollUpBtn(){
        driver.findElement(scrollUp).click();
    }
}
