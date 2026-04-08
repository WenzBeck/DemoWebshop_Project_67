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
    public void precondition() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(
                new User()
                        .setEmail(UserData.email)
                        .setPassword(UserData.password)
        );
        app.getUser().clickOnLoginButton();
    }

    @Test
    public void addItemToCartTest() {

        // берём имя второго товара
        String itemName = app.getHome().getSecondItemName();

        // добавляем второй товар
        app.getHome().addSecondItemToCart();

        // открываем корзину
        app.getHome().openCart();

        // проверяем
        Assert.assertTrue(
                app.getHome().isItemInCart(itemName)
        );
    }
}

