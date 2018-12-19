package BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class BasePage {

    // driver init
    protected final WebDriver driver;

    // driver constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    // driver getter
    public WebDriver getDriver() {return driver; }

    // navigation to MyAccount for LoginPage and RegisterPage
    public void navigateToMyAccountPage() {
        getDriver().findElement(By.xpath("//*[@id=\"account\"]/a/span[1]")).click();
        Assert.assertEquals("Your Account | ONLINE STORE", driver.getTitle());
    }
    // navigation to Product Category for ProductCategoryPage
    public void navigateToProductCategoryPage(){
        getDriver().findElement(By.xpath("//a[contains(.,'All Product')]")).click();
        Assert.assertEquals("Product Category | ONLINE STORE", driver.getTitle() );
    }
    // navigation to Checkout for CheckoutPage
    public void navigateToCheckoutPage(){
        getDriver().findElement(By.xpath("//em[@class='item']")).click();
        Assert.assertEquals("Checkout | ONLINE STORE", driver.getTitle());
    }
}
