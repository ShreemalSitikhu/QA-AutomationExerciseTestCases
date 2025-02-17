import Page_Object.DeleteAccount_Page_Object;
import Page_Object.Login_Page_Object;
import Page_Object.Payment_Page_Object;
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

public class PlaceOrder_LoginBeforeCheckout {
    WebDriver driver;

    @BeforeClass
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\IdeaProjects\\TechAxisProject\\src\\test\\chromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/");
    }

    @Test(priority = 1)
    public void loginBeforeCheckout() throws InterruptedException {
        Login_Page_Object login = new Login_Page_Object(driver);

        //verify homepage is visible
        WebElement homePage = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a"));
        String actualResults = homePage.getText();
        Assert.assertEquals(actualResults, "Home");

        login.Signup_LoginButton();
        login.EnterEmail("shreemalsitikhu@gmail.com");
        login.EnterPassword("cmalctkhu");
        login.ClickOnLoginButton();

        //verify Logged in as username (Shreemal Sitikhu)
        WebElement loggedinAsUsername = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a"));
        String actualUsername = loggedinAsUsername.getText();
        Assert.assertEquals(actualUsername, "Logged in as Shreemal Sitikhu");
    }
    @Test(priority = 2)
    public void products() throws InterruptedException {
        Registration_Page_Object product = new Registration_Page_Object(driver);

        product.AddToCartproduct1();
        Thread.sleep(1000);
        product.Product1ViewCartBtn();

        //verify that Cart Page is displayed
        WebElement cartPage = driver.findElement(By.xpath("//*[@id=\"cart_items\"]/div/div[1]/ol/li[2]"));
        String ShoppingCartText = cartPage.getText();
        Assert.assertEquals(ShoppingCartText, "Shopping Cart");

        product.ProceedToCheckoutCartPage();
        Thread.sleep(500);

        //verify Address Details AND Review your Order
        //Expected Address Details
        List<String> expectedDeliveryAddress = new ArrayList<>();
        expectedDeliveryAddress.add("YOUR DELIVERY ADDRESS");
        expectedDeliveryAddress.add("Mr. Shreemal Sitikhu");
        expectedDeliveryAddress.add("TechAxis");
        expectedDeliveryAddress.add("Goldmodi Bhaktapur");
        expectedDeliveryAddress.add("Bhaktapur, Bagmati Nepal");
        expectedDeliveryAddress.add("Kathmandu Bagmati 44600");
        expectedDeliveryAddress.add("India");
        expectedDeliveryAddress.add("9876543210");

        //Billing is same as Delivery so making List for Billing via expectedDeliveryAddress
        List<String> expectedBillingAddress = new ArrayList<>();
        expectedBillingAddress.add("YOUR BILLING ADDRESS");
        expectedBillingAddress.add("Mr. Shreemal Sitikhu");
        expectedBillingAddress.add("TechAxis");
        expectedBillingAddress.add("Goldmodi Bhaktapur");
        expectedBillingAddress.add("Bhaktapur, Bagmati Nepal");
        expectedBillingAddress.add("Kathmandu Bagmati 44600");
        expectedBillingAddress.add("India");
        expectedBillingAddress.add("9876543210");

        //Extract actual delivery address details
        List<WebElement> deliveryElements = driver.findElements(By.xpath("//ul[@id='address_delivery']/li"));
        List<String> actualDeliveryAddress = new ArrayList<>();
        for (WebElement element : deliveryElements) {
            actualDeliveryAddress.add(element.getText());
        }

        //Extract actual billing address details
        List<WebElement> billingElements = driver.findElements(By.xpath("//ul[@id='address_invoice']/li"));
        List<String> actualBillingAddress = new ArrayList<>();
        for (WebElement element : billingElements) {
            actualBillingAddress.add(element.getText());
        }

        // Now, Verify the address details
        Assert.assertEquals(actualDeliveryAddress, expectedDeliveryAddress, "Delivery address doesn't match.");
        Assert.assertEquals(actualBillingAddress, expectedBillingAddress, "Billing address doesn't match");

        //review order
        WebElement product1 = driver.findElement(By.xpath("//*[@id=\"product-1\"]/td[2]/p"));
        Boolean productAddedToCart = product1.isDisplayed();
        Assert.assertTrue(productAddedToCart);

        product.EnterCommentText("This is a text message in comment about the order for QA testing.");
        product.ClickPlaceOrderBtn();
    }
    @Test(priority = 3)
    public void paymentSection() throws InterruptedException {
        Payment_Page_Object payment = new Payment_Page_Object(driver);

        payment.EnterNameOnCard("Shreemal Sitikhu");
        payment.EnterCardNumber("123456789");
        payment.EnterCVC("123");
        payment.EnterExpiryMonth("01");
        payment.EnterExpiryYear("2026");
        payment.ClickPayandConfirmOrder();
        Thread.sleep(2000);

        //verify success message
        WebElement successMessage = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/p"));
        String verifyMessage = successMessage.getText().trim();
        System.out.println(verifyMessage);
        Assert.assertEquals(verifyMessage,"Congratulations! Your order has been confirmed!");
    }
    @Test(priority = 4)
    public void DeleteAccount(){
        DeleteAccount_Page_Object delete = new DeleteAccount_Page_Object(driver);
        // Delete Account
        delete.DeleteAccountButton();

        //verify ACCOUNT DELETED! is visible
        WebElement accountDeleted = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b"));
        String actualAccountDeletedMessage = accountDeleted.getText();
        Assert.assertEquals(actualAccountDeletedMessage,"ACCOUNT DELETED!");

        //Click Continue button of Delete Account
        delete.DeleteAccountContinueButton();
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
