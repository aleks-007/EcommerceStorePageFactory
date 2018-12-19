package Tests;

import BaseTest.BaseTest;
import Helpers.PropertiesReader;
import Pages.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegisterSteps extends BaseTest {

    RegisterPage registerPage;
    PropertiesReader propertyReader;

    private String new_username = propertyReader.getProperty("new_user");
    private String new_email = propertyReader.getProperty("email");

    public RegisterSteps() throws IOException {
    }

    @BeforeMethod
    public void initializeRegisterObjects(){
        registerPage = PageFactory.initElements(driver, RegisterPage.class);
    }

    @Test
    public void userNameAcceptableChar() {
        registerPage.navigateToMyAccountPage();
        registerPage.navigateToRegisterPage();
        Assert.assertEquals("ONLINE STORE ‹ Registration Form",driver.getTitle() );
        registerPage.enterRegisterCredentials(new_username, new_email);
        Assert.assertTrue(driver.findElement(By.id("login_error")).getText().contains("ERROR"));
    }
}