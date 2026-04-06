package demowebshop.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class ItemTests extends TestBase{


    @BeforeMethod
    public void precondition(){
        login("fbekker8@gmail.com", "Aa123456!");
    }

    @Test
    public void addItemToCartTest(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String itemName = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//div[@class='product-item']//h2/a)[2]")
        )).getText();
       // String itemName = driver.findElement(By.xpath("(//h2[@class='product-title']/a)[2]")).getText();
        List<WebElement> addButtons = driver.findElements(By.cssSelector("input[value='Add to cart']"));
        click(By.cssSelector("[href='/cart']"));

        Assert.assertTrue(
                isElementPresent(By.xpath("//a[@class='product-name' and text()='" + itemName + "']"))
        );

        // кликнуть на кнопку второго товара Add to cart
        WebElement secondAddButton = addButtons.get(1);

        //WebElement productItem = secondAddButton.findElement(By.xpath("./ancestor::div[@class='product-item']"));


        //click to Add to cart
        secondAddButton.click();

        //click Shopping cart
        click(By.cssSelector("[href='/cart']"));

        //проверить товар по имени
        Assert.assertTrue(
                isElementPresent(By.xpath("//a[@class='product-name' and text()='14.1-inch Laptop']"))
        );
    }
}

