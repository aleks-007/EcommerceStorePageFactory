package Pages;

import BasePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {


    @FindBy(xpath = "//h1[@class='entry-title']") public WebElement checkoutText;
    @FindBy(xpath = "//*[@id=\"post-29\"]/div/div[1]/ul") public WebElement stepBar;

    //Checkout Information
    @FindBy(xpath = "//span[@class='yourtotal']") public  WebElement sub_totalText;
    @FindBy(className = "pricedisplay") public WebElement sub_totalPrice;
    @FindBy(xpath = "//th[@colspan='2']")  public WebElement productText;
    @FindBy(xpath = "//th[contains(.,'Quantity:')]")public WebElement quantityText;
    @FindBy(xpath = "//th[contains(.,'Price:')]") public WebElement priceText;
    @FindBy(xpath = "//th[contains(.,'Total:')]") public WebElement totalText;

    //Product1 information
    @FindBy(xpath = "(//img[@class='product_image'])[1]") public WebElement pictureProduct1;
    @FindBy(xpath = "    //*[@id=\"checkout_page_container\"]/div[1]/table/tbody/tr[2]/td[2]/a\n") public WebElement linkProduct1;
    @FindBy(xpath = "(//input[@size='2'])[1]") public WebElement quantityCheckboxProduct1;
    @FindBy(xpath = "(//input[@type='submit'])[1]") public WebElement updateButtonProduct1;
    @FindBy(xpath = "(//span[contains(@class,'pricedisplay')])[2]") public WebElement priceValueProduct1;
    @FindBy(xpath = "(//span[contains(@class,'pricedisplay')])[4]") public WebElement totalValueProduct1;
    @FindBy(xpath = "(//input[@type='submit'])[2]") public WebElement removeButtonProduct1;

    //Product2 information
    @FindBy(xpath = "(//img[@class='product_image'])[2]") public WebElement pictureProduct2;
    @FindBy(xpath = "//*[@id=\"checkout_page_container\"]/div[1]/table/tbody/tr[3]/td[2]/a") public WebElement linkProduct2;
    @FindBy(xpath = "(//input[@size='2'])[2]") public WebElement quantityCheckboxProduct2;
    @FindBy(xpath = "(//input[@type='submit'])[3]") public WebElement updateButtonProduct2;
    @FindBy(xpath = "(//span[contains(@class,'pricedisplay')])[5]") public WebElement priceValueProduct2;
    @FindBy(xpath = "(//span[@class='pricedisplay'])[7]") public WebElement totalValueProduct2;
    @FindBy(xpath = "(//input[@name='submit'])[4]") public WebElement removeButtonProduct2;
    @FindBy(xpath = "//span[contains(.,'Continue')]") public WebElement continueButton;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPictureProduct1CheckboxPresent(String numberOfProducts) {
        return quantityCheckboxProduct1.toString().contains(numberOfProducts);
    }
    public boolean isPictureProduct2CheckboxPresent() {
        return quantityCheckboxProduct2.isEnabled();
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
