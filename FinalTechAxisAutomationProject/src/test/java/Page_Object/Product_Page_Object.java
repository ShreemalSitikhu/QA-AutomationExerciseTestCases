package Page_Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Product_Page_Object {
    WebDriver driver;

    public Product_Page_Object(WebDriver driver) {
        this.driver = driver;
    }
    private By ProductBtn = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a");
    private By Product1addToCart = By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[2]/div/div[1]/div[1]/a");
    private By Product1ViewCart = By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u");
    private By Product2addToCart = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[1]/div[1]/a");
    private By Product2ViewCart = By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u");
    private By ContinueShopping = By.xpath("//*[@id=\"cartModal\"]/div/div/div[3]/button");
    private By CartBtn = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a");
    private By CartPageProceedToCheckout = By.xpath("//*[@id=\"do_action\"]/div[1]/div/div/a");
    private By Register_Login = By.xpath("//*[@id=\"checkoutModal\"]/div/div/div[2]/p[2]/a/u");
    private By Product1crossBtn = By.xpath("//*[@id=\"product-1\"]/td[6]/a/i");

    private By PoloBrand = By.xpath("/html/body/section[2]/div/div/div[1]/div/div[3]/div/ul/li[1]/a");
    private By MadameBrand = By.xpath("/html/body/section/div/div[2]/div[1]/div/div[2]/div/ul/li[3]/a");

    private By SearchProduct = By.xpath("//*[@id=\"search_product\"]");
    private By SearchBtn = By.xpath("//*[@id=\"submit_search\"]");
    private By SearchedProduct1 = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/a");
    private By SearchedProduct1ContinueShopping = By.xpath("//*[@id=\"cartModal\"]/div/div/div[3]/button");
    private By SearchedProduct2 = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[1]/div[1]/a");
    private By SearchedProduct2ViewCart = By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u");
    private By CommentText = By.xpath("//*[@id=\"ordermsg\"]/textarea");
    private By PlaceOrderBtn = By.xpath("//*[@id=\"cart_items\"]/div/div[7]/a");

    private By Product1ViewDetail = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[2]/ul/li/a");
    private By ReviewName = By.xpath("//*[@id=\"name\"]");
    private By ReviewEmail = By.xpath("//*[@id=\"email\"]");
    private By ReviewNote = By.xpath("//*[@id=\"review\"]");
    private By ReviewSubmitBtn = By.xpath("//*[@id=\"button-review\"]");

    private By RecommendedProduct1AddtoCart = By.xpath("//*[@id=\"recommended-item-carousel\"]/div/div[2]/div[1]/div/div/div/a");
    private By RecommendedProduct1ViewCart = By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u");

    public void ClickProductBtn(){driver.findElement(ProductBtn).click();}

    public void AddToCartproduct1(){
        driver.findElement(Product1addToCart).click();
    }

    public void Product1ViewCartBtn(){
        driver.findElement(Product1ViewCart).click();
    }

    public void ClickCartBtn(){
        driver.findElement(CartBtn).click();
    }

    public void ProceedToCheckoutCartPage(){
        driver.findElement(CartPageProceedToCheckout).click();
    }

    public void AddToCartProduct2(){driver.findElement(Product2addToCart).click();}

    public void Product2ViewCartBtn(){driver.findElement(Product2ViewCart).click();}

    public void ClickContinueShopping(){driver.findElement(ContinueShopping).click();}

    public void ClickCrossBtnProduct1(){driver.findElement(Product1crossBtn).click();}

    public void ClickPoloUnderBrands(){driver.findElement(PoloBrand).click();}

    public void ClickMadameUnderBrands(){driver.findElement(MadameBrand).click();}

    public void EnterProductNameToSearch(String productname){driver.findElement(SearchProduct).sendKeys(productname);}

    public void AddtoCartSearchedProduct1(){driver.findElement(SearchedProduct1).click();}

    public void ClickSearchedProduct1ContinueShopping(){driver.findElement(SearchedProduct1ContinueShopping).click();}

    public void AddtoCartSearchedProduct2(){driver.findElement(SearchedProduct2).click();}

    public void ClickSearchedProduct2ViewCart(){driver.findElement(SearchedProduct2ViewCart).click();}

    public void ClickSearchBtn(){driver.findElement(SearchBtn).click();}

    public void EnterCommentText(String comment){
        driver.findElement(CommentText).sendKeys(comment);
    }

    public void ClickPlaceOrderBtn(){
        driver.findElement(PlaceOrderBtn).click();
    }

    public void ClickProduct1ViewDetail(){driver.findElement(Product1ViewDetail).click();}

    public void EnterNameinReview(String name){driver.findElement(ReviewName).sendKeys(name);}

    public void EnterEmailinReview(String email){driver.findElement(ReviewEmail).sendKeys(email);}

    public void EnterReviewNoteHere(String review){driver.findElement(ReviewNote).sendKeys(review);}

    public void ClickSubmitBtnInReview(){driver.findElement(ReviewSubmitBtn).click();}

    public void ClickAddtoCartRecommendedItemProduct1(){driver.findElement(RecommendedProduct1AddtoCart).click();}

    public void ClickViewCartRecommendedItemProduct1(){driver.findElement(RecommendedProduct1ViewCart).click();}
}
