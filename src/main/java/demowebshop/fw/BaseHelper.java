package demowebshop.fw;

import com.google.common.io.Files;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseHelper {

    protected WebDriver driver;

    public BaseHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForNotificationToDisappear() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector(".bar-notification")
        ));
    }

    public void click(By locator) {
        waitForNotificationToDisappear();
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        if (text != null) {
            click(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    public boolean isElementPresent(By locator) {

        return driver.findElements(locator).size() > 0;
    }

    public String takeScreenshot(){
        File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screen = new File("screenshots/screen-" + System.currentTimeMillis() + ".png");

        try {
            Files.copy(tmp,screen);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return screen.getAbsolutePath();
    }
}
