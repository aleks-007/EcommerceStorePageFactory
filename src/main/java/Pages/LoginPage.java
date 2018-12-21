package Pages;

import BasePage.BasePage;
import Helpers.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class LoginPage extends BasePage {

    @FindBy(id="log") public WebElement username;
    @FindBy(id = "pwd") public WebElement password;
    @FindBy(id = "rememberme") public WebElement checkbox;
    @FindBy(id = "login") public WebElement login_button;
    @FindBy(xpath = "(//p[@class='response'])[1]") public WebElement login_error_message;
    @FindBy(css = "p[class='response']") public WebElement second_login_error_message;
    @FindBy(css = "p[class='response']") public WebElement third_login_error_message;


    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void enterLoginDate(String user, String pass) {
        username.sendKeys(user);
        password.sendKeys(pass);
        checkbox.click();
        login_button.click();
    }
    public boolean isErrorMessagePresent(){
        return login_error_message.getText().contains("is incorrect");
    }
    public boolean isSecondErrorMessagePresent(){
        return second_login_error_message.getText().contains("enter your username");
    }
    public boolean isThirdErrorMessagePresent(){
        return third_login_error_message.getText().contains("Invalid username");
    }
}