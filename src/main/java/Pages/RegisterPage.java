package Pages;

import BasePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class RegisterPage extends BasePage {

    @FindBy(how = How.ID, using = "user_login") public WebElement new_user;
    @FindBy(how = How.ID, using = "user_email" ) public WebElement email;
    @FindBy(how = How.ID, using = "wp-submit") public WebElement submit_button;
    @FindBy(how = How.XPATH, using = "//*[@id=\"meta\"]/ul/li[1]/a") public WebElement register_button;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToRegisterPage(){
        register_button.click();
    }

    public void enterRegisterCredentials(String userName, String new_email) {
        new_user.sendKeys(userName);
        email.sendKeys(new_email);
        submit_button.click();
    }
}