package Pages;

import BasePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class RegisterPage extends BasePage {

    @FindBy(id = "user_login") public WebElement new_user;
    @FindBy(id = "user_email" ) public WebElement email;
    @FindBy(id = "wp-submit") public WebElement submit_button;
    @FindBy(xpath = "//*[@id=\"meta\"]/ul/li[1]/a") public WebElement register_button;
    @FindBy(id = "login_error") public WebElement register_error_message;

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
    public boolean isRegisterErrorMessagePresent(){
        return register_error_message.getText().contains("ERROR");
    }
}