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

import static Helpers.PropertiesReader.getProperty;

public class RegisterSteps extends BaseTest {

    RegisterPage registerPage;

    private String new_username = getProperty("new_user");
    private String new_email = getProperty("email");

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
        Assert.assertEquals("ONLINE STORE ‹ Registration Form",driver.getTitle());
        registerPage.enterRegisterCredentials(new_username, new_email);
        Assert.assertTrue(registerPage.isRegisterErrorMessagePresent());
    }
}