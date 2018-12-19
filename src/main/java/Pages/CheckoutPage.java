package Pages;

import BasePage.BasePage;
import Helpers.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class CheckoutPage extends BasePage {


    @FindBy(how = How.XPATH, using = "//h1[@class='entry-title']") public WebElement checkoutText;
    @FindBy(how = How.XPATH, using = "//*[@id=\"post-29\"]/div/div[1]/ul") public WebElement stepBar;

    //Checkout Information
    @FindBy(how = How.XPATH, using = "//span[@class='yourtotal']") public  WebElement sub_totalText;
    @FindBy(how = How.CLASS_NAME, using = "pricedisplay") public WebElement sub_totalPrice;
    @FindBy(how = How.XPATH, using = "//th[@colspan='2']")  public WebElement productText;
    @FindBy(how = How.XPATH, using = "//th[contains(.,'Quantity:')]")public WebElement quantityText;
    @FindBy(how = How.XPATH, using = "//th[contains(.,'Price:')]") public WebElement priceText;
    @FindBy(how = How.XPATH, using = "//th[contains(.,'Total:')]") public WebElement totalText;

    //Product1 information
    @FindBy(how = How.XPATH, using = "(//img[@class='product_image'])[1]") public WebElement pictureProduct1;
    @FindBy(how = How.XPATH, using = "    //*[@id=\"checkout_page_container\"]/div[1]/table/tbody/tr[2]/td[2]/a\n") public WebElement linkProduct1;
    @FindBy(how = How.XPATH, using = "(//input[@size='2'])[1]") public WebElement quantityCheckboxProduct1;
    @FindBy(how = How.XPATH, using = "(//input[@type='submit'])[1]") public WebElement updateButtonProduct1;
    @FindBy(how = How.XPATH, using = "(//span[contains(@class,'pricedisplay')])[2]") public WebElement priceValueProduct1;
    @FindBy(how = How.XPATH, using = "(//span[contains(@class,'pricedisplay')])[4]") public WebElement totalValueProduct1;
    @FindBy(how = How.XPATH, using = "(//input[@type='submit'])[2]") public WebElement removeButtonProduct1;

    //Product2 information
    @FindBy(how = How.XPATH, using = "(//img[@class='product_image'])[2]") public WebElement pictureProduct2;
    @FindBy(how = How.XPATH, using = "//*[@id=\"checkout_page_container\"]/div[1]/table/tbody/tr[3]/td[2]/a") public WebElement linkProduct2;
    @FindBy(how = How.XPATH, using = "(//input[@size='2'])[2]") public WebElement quantityCheckboxProduct2;
    @FindBy(how = How.XPATH, using = "(//input[@type='submit'])[3]") public WebElement updateButtonProduct2;
    @FindBy(how = How.XPATH, using = "(//span[contains(@class,'pricedisplay')])[5]") public WebElement priceValueProduct2;
    @FindBy(how = How.XPATH, using = "(//span[@class='pricedisplay'])[7]") public WebElement totalValueProduct2;
    @FindBy(how = How.XPATH, using = "(//input[@name='submit'])[4]") public WebElement removeButtonProduct2;

    @FindBy(how = How.XPATH, using = "//span[contains(.,'Continue')]") public WebElement continueButton;


    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    public void areElementsVisible()  {
        checkoutText.isDisplayed();
        stepBar.isDisplayed();
        sub_totalText.isDisplayed();
        sub_totalPrice.isDisplayed();
        productText.isDisplayed();
        quantityText.isDisplayed();
        priceText.isDisplayed();
        totalText.isDisplayed();

        pictureProduct1.isDisplayed();
        linkProduct1.isDisplayed();
        priceValueProduct1.isDisplayed();
        totalValueProduct1.isDisplayed();
        removeButtonProduct1.isDisplayed();

       // WaitHelper.waitUntilElementISVisible(driver, By.xpath("(//img[@class='product_image'])[2]"), 10);
        pictureProduct2.isDisplayed();
        linkProduct2.isDisplayed();
        quantityCheckboxProduct2.isDisplayed();
        updateButtonProduct2.isDisplayed();
        priceValueProduct2.isDisplayed();
        totalValueProduct2.isDisplayed();

    }
    public void updateQuantityOfFirstProduct(String productsNumber){
        quantityCheckboxProduct1.clear();
        quantityCheckboxProduct1.sendKeys(productsNumber);
    }
    public void clickUpdateButton(){
        updateButtonProduct1.click();
    }
    public void removeProduct2(){
        removeButtonProduct2.click();
    }
    public void clickContinueButton(){
        continueButton.click();
    }
}
