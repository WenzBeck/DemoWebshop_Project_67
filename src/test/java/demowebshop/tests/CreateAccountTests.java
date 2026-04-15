package demowebshop.tests;

import demowebshop.core.TestBase;
import demowebshop.data.UserData;
import demowebshop.models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test
    public void newUserRegisterPositiveTest() {

        String email = "test" + System.currentTimeMillis() + "@test.com";

        app.getUser().clickOnRegisterLink();

        app.getUser().fillRegisterForm(
                new User()
                        .setEmail(email)
                        .setPassword("Aa123456!")
        );

        app.getUser().submitRegistration();

        Assert.assertTrue(app.getUser().isSignButtonPresent());
    }

    @Test
    public void existedUserRegisterNegativeTest() {

        app.getUser().clickOnRegisterLink();

        app.getUser().fillRegisterForm(
                new User()
                        .setEmail(UserData.email)
                        .setPassword("Aa123456!")
        );

        app.getUser().submitRegistration();

        Assert.assertTrue(app.getUser().isErrorMessagePresent());
    }
}
