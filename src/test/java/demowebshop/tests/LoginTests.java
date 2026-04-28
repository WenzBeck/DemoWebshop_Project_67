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
        app.getUser().logout(); // ✅ важно

        app.getUser().clickOnLoginLink();

        app.getUser().fillLoginRegisterForm(
                new User()
                        .setEmail(UserDetails.EMAIL)
                        .setPassword(UserDetails.PASSWORD)
        );

        app.getUser().clickOnLoginButton();
        app.getUser().waitForLoginSuccess();

        Assert.assertTrue(app.getUser().isSignButtonPresent());
    }

    @Test
    public void loginNegativeWithoutEmailTest() {
        app.getUser().logout(); // ✅ важно

        app.getUser().clickOnLoginLink();

        app.getUser().fillLoginRegisterForm(
                new User().setPassword(UserDetails.PASSWORD)
        );

        app.getUser().clickOnLoginButton();

        Assert.assertTrue(app.getUser().isErrorMessagePresent());
    }

    @Test(dataProvider = "loginDataFromCsv", dataProviderClass = MyDataProviders.class)
    public void loginWithDataProviderTest(String email, String password, String expectedResult) {

        app.getUser().logout(); // ✅ КЛЮЧЕВОЕ исправление

        app.getUser().clickOnLoginLink();

        app.getUser().fillLoginRegisterForm(
                new User()
                        .setEmail(email)
                        .setPassword(password)
        );

        app.getUser().clickOnLoginButton();

        if ("success".equalsIgnoreCase(expectedResult.trim())) {
            app.getUser().waitForLoginSuccess(); // ✅ добавили
            Assert.assertTrue(app.getUser().isSignButtonPresent());
        } else {
            Assert.assertTrue(app.getUser().isErrorMessagePresent());
        }
    }
}
