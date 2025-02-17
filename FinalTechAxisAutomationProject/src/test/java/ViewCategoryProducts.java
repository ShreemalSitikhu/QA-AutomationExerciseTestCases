import Page_Object.Category_Page_Object;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ViewCategoryProducts {
    WebDriver driver;

    @BeforeClass
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\IdeaProjects\\TechAxisProject\\src\\test\\chromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/");
    }

    @Test
    public void ViewCategory() throws InterruptedException {
        Category_Page_Object category = new Category_Page_Object(driver);

        //verify categories are visible on left side bar
        WebElement categoryCheck = driver.findElement(By.xpath("/html/body/section[2]/div/div/div[1]/div/h2"));
        String CategoryText = categoryCheck.getText();
        Assert.assertEquals(CategoryText, "CATEGORY");

        category.ClickWomenCategory();
        category.ClickDressUnderWomenCategory();

        //verify Category page is displayed and confirm text 'WOMEN- DRESS PRODUCTS'
        WebElement dressProducts = driver.findElement(By.xpath("//div[@class='features_items']/h2"));
        String DressProductsText = dressProducts.getText();
        Assert.assertEquals(DressProductsText, "WOMEN - DRESS PRODUCTS");

        category.ClickMenCategory();
        category.ClickTshirtsUnderMenCategory();

        //verify user is navigated to that category page
        WebElement TshirtCategory = driver.findElement(By.xpath("/html/body/section/div/div[2]/div[2]/div/h2"));
        String TshirtCategoryPageText = TshirtCategory.getText();
        Assert.assertEquals(TshirtCategoryPageText, "MEN - TSHIRTS PRODUCTS");
    }
    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
