package Tests;

import BaseTest.BaseTest;
import Helpers.PropertiesReader;
import Helpers.WaitHelper;
import Pages.CheckoutPage;
import Pages.ProductCategory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class CheckoutSteps extends BaseTest {
    CheckoutPage checkoutPage;
    ProductCategory productCategory;
    PropertiesReader propertyReader;

    private String numberOfProducts = propertyReader.getProperty("productsNumber");

    public CheckoutSteps() throws IOException {
    }

    @BeforeMethod
    public void initializePageObjects(){
        checkoutPage = PageFactory.initElements(driver, CheckoutPage.class);
        productCategory = PageFactory.initElements(driver, ProductCategory.class);
    }
    // Happy Flow buying products without login to the site.
    @Test
    public void checkoutWithValidInformation()  {
        productCategory.navigateToProductCategoryPage();
        productCategory.addProducts();
        checkoutPage.navigateToCheckoutPage();
        WaitHelper.waitUntilElementISVisible(driver, By.xpath("(//img[@class='product_image'])[2]"), 10);

        checkoutPage.updateQuantityOfFirstProduct(numberOfProducts);
        checkoutPage.clickUpdateButton();
        WaitHelper.waitUntilElementISVisible(driver, By.xpath("(//input[@size='2'])[1]"), 10);
        Assert.assertTrue(checkoutPage.isPictureProduct1CheckboxPresent(numberOfProducts));

        WaitHelper.waitUntilElementISVisible(driver, By.xpath("(//input[@size='2'])[2]"), 10);
        Assert.assertTrue(checkoutPage.isPictureProduct2CheckboxPresent());
        checkoutPage.removeProduct2();

        checkoutPage.clickContinueButton();
        WaitHelper.waitUntilElementISVisible(driver, By.xpath("//h2[contains(.,'Calculate Shipping Price')]\""), 20);
        Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(.,'Calculate Shipping Price')]")).getText().contains("Calculate"));
    }
        //Next step filling checkout form
}
