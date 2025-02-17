package Page_Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import static java.lang.Thread.sleep;

public class Category_Page_Object {
    WebDriver driver;
    public Category_Page_Object(WebDriver driver){
        this.driver = driver;
    }
    private By Women = By.xpath("//*[@id=\"accordian\"]/div[1]/div[1]/h4/a");
    private By WomenDress = By.xpath("//*[@id=\"Women\"]/div/ul/li[1]/a");
    private By Men = By.xpath("//*[@id=\"accordian\"]/div[2]/div[1]/h4/a");
    private By MenTshirts = By.xpath("//*[@id=\"Men\"]/div/ul/li[1]/a");

    public void ClickWomenCategory() throws InterruptedException {
        driver.findElement(Women).click();
        sleep(1000);
    }

    public void ClickDressUnderWomenCategory() throws InterruptedException {
        driver.findElement(WomenDress).click();
        sleep(1000);
    }

    public void ClickMenCategory() throws InterruptedException {
        driver.findElement(Men).click();
        sleep(1000);
    }

    public void ClickTshirtsUnderMenCategory() throws InterruptedException {
        driver.findElement(MenTshirts).click();
        sleep(1000);
    }
}
