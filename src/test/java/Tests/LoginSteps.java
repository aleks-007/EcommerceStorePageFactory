package Tests;

import BaseTest.BaseTest;
import Helpers.PropertiesReader;
import Helpers.WaitHelper;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginSteps extends BaseTest {

    LoginPage loginPage;
    PropertiesReader propertyReader;

    private String user = propertyReader.getProperty("username");
    private String pass = propertyReader.getProperty("password");
    private String invalid_pass = propertyReader.getProperty("invalid_password");
    private String invalid_user = propertyReader.getProperty("invalid_username");

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
        Assert.assertTrue(driver.findElement(By.xpath("(//p[@class='response'])[1]")).getText().contains("is incorrect"));
    }
    @Test
    public void loginWithNoCredentials()  {
        loginPage.navigateToMyAccountPage();
        loginPage.enterLoginDate("","");
        WaitHelper.waitUntilElementISVisible(driver, By.cssSelector("p[class='response']"), 10);
        Assert.assertTrue(driver.findElement(By.cssSelector("p[class='response']")).getText().contains("enter your username"));
    }
   @Test
    public void loginWithInvalidUsername() {
        loginPage.navigateToMyAccountPage();
        loginPage.enterLoginDate(invalid_user, pass);
       WaitHelper.waitUntilElementISVisible(driver, By.cssSelector("p[class='response']"), 10);
       Assert.assertTrue(driver.findElement(By.cssSelector("p[class='response']")).getText().contains("Invalid username"));
    }
}