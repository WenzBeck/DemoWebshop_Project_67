package demowebshop.fw;

import demowebshop.models.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserHelper extends BaseHelper {

    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnLoginLink() {
        click(By.cssSelector("[href='/login']"));
    }

    public void fillLoginRegisterForm(User user) {
        type(By.id("Email"), user.getEmail());
        type(By.id("Password"), user.getPassword());
    }

    public void clickOnLoginButton() {
        click(By.cssSelector("[value='Log in']"));
    }

    public boolean isSignButtonPresent() {
        return isElementPresent(By.cssSelector("[href='/logout']"));
    }

    public boolean isAlertPresent() {
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent());
        return alert != null;
    }

    public void clickOnRegisterLink() {
        click(By.cssSelector("[href='/register']"));
    }

    public void fillRegisterForm(User user) {
        type(By.name("FirstName"), "Wenzel");
        type(By.name("LastName"), "Becker");
        type(By.name("Email"), user.getEmail());
        type(By.name("Password"), user.getPassword());
        type(By.name("ConfirmPassword"), user.getPassword());
    }

    public void submitRegistration() {
        click(By.name("register-button"));
    }

    //добавляем метод т.к. на сайте нет Алерт а есть только сообщение об ошибке
    public boolean isErrorMessagePresent() {
        return isElementPresent(By.cssSelector(".validation-summary-errors"));
    }
}
