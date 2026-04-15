package demowebshop.tests;

import demowebshop.core.TestBase;
import demowebshop.data.UserData;
import demowebshop.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ItemTests extends TestBase {


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

