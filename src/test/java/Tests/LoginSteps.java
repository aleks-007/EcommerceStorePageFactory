package Tests;

import BaseTest.BaseTest;
import Helpers.WaitHelper;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static Helpers.PropertiesReader.getProperty;

public class LoginSteps extends BaseTest {

    LoginPage loginPage;

    private String user = getProperty("username");
    private String pass = getProperty("password");
    private String invalid_pass = getProperty("invalid_password");
    private String invalid_user = getProperty("invalid_username");

    public LoginSteps() throws IOException {
    }

    @BeforeMethod
    public void initializePageObjects(){
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @Test
    public void loginWithValidCredentials()   {
        loginPage.navigateToMyAccountPage();
        loginPage.enterLoginDate(user, pass);
        Assert.assertEquals("Your Account | ONLINE STORE", driver.getTitle());
    }
    @Test
    public void loginWithInvalidPassword()  {
        loginPage.navigateToMyAccountPage();
        loginPage.enterLoginDate(user, invalid_pass);
        WaitHelper.waitUntilElementISVisible(driver, By.xpath("(//p[@class='response'])[1]"), 10);
        Assert.assertTrue(loginPage.isErrorMessagePresent());
    }
    @Test
    public void loginWithNoCredentials()  {
        loginPage.navigateToMyAccountPage();
        loginPage.enterLoginDate("","");
        WaitHelper.waitUntilElementISVisible(driver, By.cssSelector("p[class='response']"), 10);
        Assert.assertTrue(loginPage.isSecondErrorMessagePresent());
    }
   @Test
    public void loginWithInvalidUsername() {
        loginPage.navigateToMyAccountPage();
        loginPage.enterLoginDate(invalid_user, pass);
       WaitHelper.waitUntilElementISVisible(driver, By.cssSelector("p[class='response']"), 10);
       Assert.assertTrue(loginPage.isThirdErrorMessagePresent());
    }
}