package Page_Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Registration_Page_Object {
    WebDriver driver;

    public Registration_Page_Object(WebDriver driver) {
        this.driver = driver;
    }
    private By Signup_Login = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
    private By NameField = By.name("name");
    private By EmailField = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]");
    private By signup = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button");
    private By gender1 = By.id("id_gender1");
    private By Password = By.id("password");
    private By DayDropdown = By.id("days");
    private By MonthDropdown = By.id("months");
    private By YearDropdown = By.id("years");
    private By Newsletter = By.xpath("//*[@id=\"newsletter\"]");
    private By Offer = By.xpath("//*[@id=\"optin\"]");
    private By Firstname = By.id("first_name");
    private By Lastname = By.id("last_name");
    private By Company = By.id("company");
    private By Address1 = By.id("address1");
    private By Address2 = By.id("address2");
    private By CountryDropdown = By.id("country");
    private By State = By.id("state");
    private By City = By.id("city");
    private By Zipcode = By.id("zipcode");
    private By Mobile = By.id("mobile_number");
    private By CreateAccountButton = By.xpath("//*[@id=\"form\"]/div/div/div/div/form/button");
    private By AccountCreateContinue = By.xpath("//*[@id=\"form\"]/div/div/div/div/a");
    private By DeleteAccount = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a");
    private By DeleteAccountContinue = By.xpath("//*[@id=\"form\"]/div/div/div/div/a");

    private By Product1addToCart = By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[2]/div/div[1]/div[1]/a");
    private By Product1ViewCart = By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u");
    private By CartBtn = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a");
    private By CartPageProceedToCheckout = By.xpath("//*[@id=\"do_action\"]/div[1]/div/div/a");
    private By Register_Login = By.xpath("//*[@id=\"checkoutModal\"]/div/div/div[2]/p[2]/a/u");

    private By CommentText = By.xpath("//*[@id=\"ordermsg\"]/textarea");
    private By PlaceOrderBtn = By.xpath("//*[@id=\"cart_items\"]/div/div[7]/a");


    public void Signup_LoginButton(){
        driver.findElement(Signup_Login).click();
    }

    public void EnterName(String name) {
        driver.findElement(NameField).sendKeys(name);
    }

    public void EnterEmail(String email){
        driver.findElement(EmailField).sendKeys(email);
    }

    public void SignupButton(){
        driver.findElement(signup).click();
    }

    // Enter Account Information
    public void Gender1(){
        driver.findElement(gender1).click();
    }

    public void PasswordField(String password){
        driver.findElement(Password).sendKeys(password);
    }

    public void selectDay(String day) {
        Select selectDay = new Select(driver.findElement(DayDropdown));
        selectDay.selectByVisibleText(day);
    }

    public void  selectMonth(String month){
        Select selectMonth = new Select(driver.findElement(MonthDropdown));
        selectMonth.selectByVisibleText(month);
    }

    public void selectYear(String year){
        Select selectYear = new Select(driver.findElement(YearDropdown));
        selectYear.selectByVisibleText(year);
    }

    public void NewsletterClick(){
        driver.findElement(Newsletter).click();
    }

    public void OfferClick(){
        driver.findElement(Offer).click();
    }

    //Address Information
    public void FirstnameField(String fname){
        driver.findElement(Firstname).sendKeys(fname);
    }

    public void LastnameField(String lname){
        driver.findElement(Lastname).sendKeys(lname);
    }

    public void CompanyField(String company){
        driver.findElement(Company).sendKeys(company);
    }

    public void Address1Field(String address1){
        driver.findElement(Address1).sendKeys(address1);
    }

    public  void Address2Field(String address2){
        driver.findElement(Address2).sendKeys(address2);
    }

    public void CountryDropdown(String country){
        Select selectCountry = new Select(driver.findElement(CountryDropdown));
        selectCountry.selectByVisibleText(country);
    }

    public void StateField(String state){
        driver.findElement(State).sendKeys(state);
    }

    public void CityField(String city){
        driver.findElement(City).sendKeys(city);
    }

    public void ZipcodeField(String zipcode){
        driver.findElement(Zipcode).sendKeys(zipcode);
    }

    public void MobileField(String mobile){
        driver.findElement(Mobile).sendKeys(mobile);
    }

    public void CreateAccount(){
        driver.findElement(CreateAccountButton).click();
    }

    public void AccountCreateContinueButton(){
        driver.findElement(AccountCreateContinue).click();
    }

    public void DeleteAccountButton(){
        driver.findElement(DeleteAccount).click();
    }

    public void DeleteAccountContinueButton(){
        driver.findElement(DeleteAccountContinue).click();
    }

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

    public void ClickRegister_LoginBtn(){
        driver.findElement(Register_Login).click();
    }

    public void EnterCommentText(String comment){
        driver.findElement(CommentText).sendKeys(comment);
    }

    public void ClickPlaceOrderBtn(){
        driver.findElement(PlaceOrderBtn).click();
    }
}