package demowebshop.tests;

import demowebshop.core.TestBase;
import demowebshop.data.UserData;
import demowebshop.details.UserDetails;
import demowebshop.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ItemTests extends TestBase {

    @BeforeMethod
    public void precondition() {

        app.getUser().logout(); // ✅ добавили стабильность

        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(
                new User()
                        .setEmail(UserDetails.EMAIL)
                        .setPassword(UserDetails.PASSWORD)
        );
        app.getUser().clickOnLoginButton();
        app.getUser().waitForLoginSuccess();
    }

    @Test
    public void addItemToCartTest() {

        app.getHome().addSecondItemToCart();
        app.getHome().openCart();

        Assert.assertTrue(
                app.getHome().isItemInCart("14.1-inch Laptop")
        );
    }
}

