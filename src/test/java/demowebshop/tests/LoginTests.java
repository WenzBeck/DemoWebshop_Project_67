package demowebshop.tests;

import demowebshop.core.TestBase;
import demowebshop.data.UserData;
import demowebshop.details.UserDetails;
import demowebshop.models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginPositiveTest() {
        app.getUser().clickOnLoginLink();

        app.getUser().fillLoginRegisterForm(
                new User()
                        .setEmail(UserDetails.EMAIL)
                        .setPassword(UserDetails.PASSWORD)
        );

        app.getUser().clickOnLoginButton();

        Assert.assertTrue(app.getUser().isSignButtonPresent());
    }

    @Test
    public void loginNegativeWithoutEmailTest() {
        app.getUser().clickOnLoginLink();

        app.getUser().fillLoginRegisterForm(
                new User().setPassword(UserDetails.PASSWORD)
        );

        app.getUser().clickOnLoginButton();

        Assert.assertTrue(app.getUser().isErrorMessagePresent());
    }
}
