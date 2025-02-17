package Page_Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCases_Page_Object {
    WebDriver driver;
    public TestCases_Page_Object(WebDriver driver){
        this.driver = driver;
    }
     private By TestCases = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a");

    public void TestCasesBtn(){
        driver.findElement(TestCases).click();
    }
}
