package demowebshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @Test
    public void loginPositiveTest() {
        app.getUser().clickOnLoginLink();

        app.getUser().fillLoginRegisterForm(
                new User()
                        .setEmail(UserData.email)
                        .setPassword(UserData.password)
        );

        app.getUser().clickOnLoginButton();

        Assert.assertTrue(app.getUser().isSignButtonPresent());
    }

    @Test
    public void loginNegativeWithoutEmailTest() {
        app.getUser().clickOnLoginLink();

        app.getUser().fillLoginRegisterForm(
                new User().setPassword("Aa12345!")
        );

        app.getUser().clickOnLoginButton();

        Assert.assertTrue(app.getUser().isErrorMessagePresent());
    }
}
