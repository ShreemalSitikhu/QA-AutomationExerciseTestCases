package Page_Object;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductQuantityInCart_Object_Page {
    WebDriver driver;

    public ProductQuantityInCart_Object_Page(WebDriver driver) {
        this.driver = driver;
    }

    private By product2 = By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[3]/div/div[2]/ul/li/a");
    private By Quantity = By.id("quantity");
    private By addToCart = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button");
    private By viewCart = By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u");

    public void viewProduct(){
        driver.findElement(product2).click();
    }

    public void IncreaseQuantity(String quantity){
        WebElement quantityInput = driver.findElement(Quantity);
        quantityInput.clear();
        quantityInput.sendKeys(quantity);
        quantityInput.sendKeys(Keys.RETURN);
    }

    public void AddToCart(){
        driver.findElement(addToCart).click();
    }

    public void ViewCart(){
        driver.findElement(viewCart).click();
    }
}
