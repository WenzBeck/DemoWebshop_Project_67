package demowebshop.tests;

import demowebshop.core.TestBase;
import demowebshop.data.UserData;
import demowebshop.details.UserDetails;
import demowebshop.models.User;
import demowebshop.utils.MyDataProviders;
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

    // параметризация
    @Test(dataProvider = "loginDataFromCsv", dataProviderClass = MyDataProviders.class)
    public void loginWithDataProviderTest(String email, String password, String expectedResult) {

        app.getUser().clickOnLoginLink();

        app.getUser().fillLoginRegisterForm(
                new User()
                        .setEmail(email)
                        .setPassword(password)
        );

        app.getUser().clickOnLoginButton();

        if (expectedResult.equals("success")) {
            Assert.assertTrue(app.getUser().isSignButtonPresent());
        } else {
            Assert.assertTrue(app.getUser().isErrorMessagePresent());
        }
    }
}
