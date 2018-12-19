package Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WaitHelper {
    public static Boolean waitUntilElementISVisible(WebDriver driver, By locator, long seconds) {
        WebDriverWait driverWait = new WebDriverWait(driver, seconds);
        try {
            driverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
