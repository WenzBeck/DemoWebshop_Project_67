package demowebshop.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePageHelper extends BaseHelper {

    public HomePageHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isHomeComponentPresent() {
        return isElementPresent(By.xpath("//div[@class='center-3']"));
    }

    public String getSecondItemName() {
        return driver.findElements(By.cssSelector(".product-item .product-title a"))
                .get(1)
                .getText();
    }

    public void addSecondItemToCart() {
        driver.findElements(By.cssSelector("input[value='Add to cart']"))
                .get(1)
                .click();
        waitForNotificationToDisappear();
    }

    //подождали, чтобы кнопочка открылась
    public void openCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("[href='/cart']")
        ));
        click(By.cssSelector("[href='/cart']"));
    }

    public boolean isItemInCart(String itemName) {
        return isElementPresent(
                By.xpath("//a[@class='product-name' and text()='" + itemName + "']")
        );
    }

}
