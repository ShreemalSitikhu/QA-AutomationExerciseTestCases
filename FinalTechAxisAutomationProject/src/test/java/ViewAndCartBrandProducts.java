import Page_Object.Product_Page_Object;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ViewAndCartBrandProducts {
    WebDriver driver;
    @BeforeClass
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\IdeaProjects\\TechAxisProject\\src\\test\\chromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/");
    }

    @Test
    public void viewAndCartBrandProducts(){
        Product_Page_Object product = new Product_Page_Object(driver);
        product.ClickProductBtn();

        //verify that Brands are visible on left side bar
        WebElement brand = driver.findElement(By.xpath("/html/body/section[2]/div/div/div[1]/div/div[3]/h2"));
        String BrandText = brand.getText();
        Assert.assertEquals(BrandText,"BRANDS");

        product.ClickPoloUnderBrands();

        //verify user is navigated to brand page and brand products are displayed
        WebElement BrandTitle = driver.findElement(By.xpath("/html/body/section/div/div[2]/div[2]/div/h2"));
        String BrandTitleText = BrandTitle.getText();
        Assert.assertEquals(BrandTitleText,"BRAND - POLO PRODUCTS");

        WebElement polo = driver.findElement(By.xpath("/html/body/section/div/div[1]/ol/li[2]"));
        String poloText = polo.getText();
        Assert.assertEquals(poloText,"Polo");

        product.ClickMadameUnderBrands();
        //verify user is navigated to that brand page and can see products
        WebElement MadameTitle = driver.findElement(By.xpath("/html/body/section/div/div[2]/div[2]/div/h2"));
        String MadameTitleText = MadameTitle.getText();
        Assert.assertEquals(MadameTitleText,"BRAND - MADAME PRODUCTS");

        WebElement madame = driver.findElement(By.xpath("/html/body/section/div/div[1]/ol/li[2]"));
        String MadameText = madame.getText();
        Assert.assertEquals(MadameText,"Madame");
    }
    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
