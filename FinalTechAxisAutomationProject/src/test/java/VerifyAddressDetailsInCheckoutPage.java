import Page_Object.DeleteAccount_Page_Object;
import Page_Object.Product_Page_Object;
import Page_Object.Registration_Page_Object;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class VerifyAddressDetailsInCheckoutPage {
    WebDriver driver;
    @BeforeClass
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\IdeaProjects\\TechAxisProject\\src\\test\\chromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/");
    }
    @Test(priority = 1)
    public void addressDetailsInCheckoutPage(){
        Registration_Page_Object register = new Registration_Page_Object(driver);

        //verify homepage is visible
        WebElement homePage = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a"));
        String actualResults = homePage.getText();
        Assert.assertEquals(actualResults, "Home");

        register.Signup_LoginButton();
        register.EnterName("Shreemal Sitikhu");
        register.EnterEmail("shreemalsitikhu@gmail.com");
        register.SignupButton();

        //verify ENTER ACCOUNT INFORMATION is visible
        WebElement b = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/h2/b"));
        String c = b.getText();
        Assert.assertEquals(c,"ENTER ACCOUNT INFORMATION");

        // Enter Account Information
        register.Gender1();
        register.PasswordField("cmalctkhu");
        register.selectDay("6");
        register.selectMonth("February");
        register.selectYear("2001");
        register.NewsletterClick();
        register.OfferClick();

        //Address Information
        register.FirstnameField("Shreemal");
        register.LastnameField("Sitikhu");
        register.CompanyField("TechAxis");
        register.Address1Field("Goldmodi Bhaktapur");
        register.Address2Field(" Bhaktapur, Bagmati Nepal");
        register.CountryDropdown("India");
        register.StateField("Bagmati");
        register.CityField("Kathmandu");
        register.ZipcodeField("44600");
        register.MobileField("9876543210");
        register.CreateAccount();

        //verify ACCOUNT CREATED!
        WebElement accountCreated = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b"));
        String actualAccountCreated = accountCreated.getText();
        Assert.assertEquals(actualAccountCreated,"ACCOUNT CREATED!");

        //Click Continue button of Account Created
        register.AccountCreateContinueButton();

        //verify Logged in as username (Shreemal Sitikhu)
        WebElement loggedinAsUsername = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a"));
        String actualUsername = loggedinAsUsername.getText();
        Assert.assertEquals(actualUsername,"Logged in as Shreemal Sitikhu");
    }
    @Test(priority = 2)
    public void AddProductsToCart() throws InterruptedException {
        Product_Page_Object product = new Product_Page_Object(driver);
        product.ClickProductBtn();
        Thread.sleep(1000);
        product.AddToCartproduct1();
        Thread.sleep(1000);
        product.ClickContinueShopping();

        product.AddToCartProduct2();
        Thread.sleep(1000);
        product.ClickContinueShopping();
        product.ClickCartBtn();

        //verify that Cart Page is displayed
        WebElement cartPage = driver.findElement(By.xpath("//*[@id=\"cart_items\"]/div/div[1]/ol/li[2]"));
        String ShoppingCartText = cartPage.getText();
        Assert.assertEquals(ShoppingCartText, "Shopping Cart");

        product.ProceedToCheckoutCartPage();
        Thread.sleep(1000);

        //verify delivery address is same address filled at the time of registration of account
        //Expected delivery address details
        List<String> expectedDeliveryAddress = new ArrayList<>();
        expectedDeliveryAddress.add("YOUR DELIVERY ADDRESS");
        expectedDeliveryAddress.add("Mr. Shreemal Sitikhu");
        expectedDeliveryAddress.add("TechAxis");
        expectedDeliveryAddress.add("Goldmodi Bhaktapur");
        expectedDeliveryAddress.add("Bhaktapur, Bagmati Nepal");
        expectedDeliveryAddress.add("Kathmandu Bagmati 44600");
        expectedDeliveryAddress.add("India");
        expectedDeliveryAddress.add("9876543210");

        //Extract actual delivery address details
        List<WebElement> deliveryElements = driver.findElements(By.xpath("//ul[@id='address_delivery']/li"));
        List<String> actualDeliveryAddress = new ArrayList<>();
        for (WebElement element : deliveryElements) {
            actualDeliveryAddress.add(element.getText());
        }

        // Now, Verify the delivery address details
        Assert.assertEquals(actualDeliveryAddress, expectedDeliveryAddress, "Delivery address doesn't match.");

        //Verify billing address is same address filled at the time of registration of account
        //Expected Billing Address Details
        List<String> expectedBillingAddress = new ArrayList<>();
        expectedBillingAddress.add("YOUR BILLING ADDRESS");
        expectedBillingAddress.add("Mr. Shreemal Sitikhu");
        expectedBillingAddress.add("TechAxis");
        expectedBillingAddress.add("Goldmodi Bhaktapur");
        expectedBillingAddress.add("Bhaktapur, Bagmati Nepal");
        expectedBillingAddress.add("Kathmandu Bagmati 44600");
        expectedBillingAddress.add("India");
        expectedBillingAddress.add("9876543210");

        //Extract actual billing address details
        List<WebElement> billingElements = driver.findElements(By.xpath("//ul[@id='address_invoice']/li"));
        List<String> actualBillingAddress = new ArrayList<>();
        for (WebElement element : billingElements) {
            actualBillingAddress.add(element.getText());
        }

        // Now, Verify the billing address details
        Assert.assertEquals(actualBillingAddress, expectedBillingAddress, "Billing address doesn't match");
    }
    @Test(priority = 3)
    public void DeleteAccount(){
        DeleteAccount_Page_Object delete = new DeleteAccount_Page_Object(driver);
        delete.DeleteAccountButton();
        delete.DeleteAccountContinueButton();
    }
    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
