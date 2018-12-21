package Pages;

import BasePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProductCategory extends BasePage {

    @FindBy(how = How.XPATH, using = "(//input[@name='Buy'])[1]") public WebElement product1AddButton;
    @FindBy(how = How.XPATH, using = "(//input[@name='Buy'])[2]") public WebElement product2AddButton;

    public ProductCategory(WebDriver driver) {
        super(driver);
    }

    public ProductCategory addProducts(){
        product1AddButton.click();
        product2AddButton.click();
        return new ProductCategory(driver);
    }
}

