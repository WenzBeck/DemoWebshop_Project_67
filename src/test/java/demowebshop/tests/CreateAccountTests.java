package demowebshop.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CreateAccountTests extends TestBase{

    @Test (enabled = false)
    public void newUserRegisterPositiveTest(String text){

        int i = (int) ((System.currentTimeMillis()/1000)%3600); //чтобы тест много раз генерировался

        //click on Register button (Link) in the header
        existedUserRegisterNegativeTest(text);

        //assert Log Out button (link)
        Assert.assertTrue(isElementPresent(By.xpath("//*[@class='header']//li[2]")));
    }

    public void type(By locator) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys("Wenzel");
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    //negative test
    @Test
    public void existedUserRegisterNegativeTest(String text){

        //click on Register button (Link) in the header
        click(By.cssSelector("[href='/register']"));
        //enter First name
        type(By.name("FirstName"));
        //enter Last name
        click(By.name("LastName"));
        driver.findElement(By.name("LastName")).clear();
        driver.findElement(By.name("LastName")).sendKeys("Becker");
        //enter Email
        click(By.name("Email"));
        driver.findElement(By.name("Email")).clear();
        driver.findElement(By.name("Email")).sendKeys(text);
        //enter Password
        click(By.name("Password"));
        driver.findElement(By.name("Password")).clear();
        driver.findElement(By.name("Password")).sendKeys("Aa123456!");
        //confirm Password
        click(By.name("ConfirmPassword"));
        driver.findElement(By.name("ConfirmPassword")).clear();
        driver.findElement(By.name("ConfirmPassword")).sendKeys("Aa123456!");

        //click Register button
        click(By.name("register-button"));

    }

    // created method for Alert
    public boolean isAlertPresent (){
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.alertIsPresent());
            if (alert == null){
                return false;
            } else {
                return true;
            }
        }
}
