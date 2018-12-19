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
    @FindBy(how = How.ID, using = "pwd") public WebElement password;
    @FindBy(how = How.ID, using = "rememberme") public WebElement checkbox;
    @FindBy(how = How.ID, using = "login") public WebElement login_button;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterLoginDate(String user, String pass) {
        username.sendKeys(user);
        password.sendKeys(pass);
        checkbox.click();
        login_button.click();
    }
}