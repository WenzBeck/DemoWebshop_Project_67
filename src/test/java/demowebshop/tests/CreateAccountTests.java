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
    public void newUserRegisterPositiveTest(){

        int i = (int) ((System.currentTimeMillis()/1000)%3600); //чтобы тест много раз генерировался

        //click on Register button (Link) in the header
        driver.findElement(By.cssSelector("[href='/register']")).click();
        //enter First name
        driver.findElement(By.name("FirstName")).click();
        driver.findElement(By.name("FirstName")).clear();
        driver.findElement(By.name("FirstName")).sendKeys("Wenzel");
        //enter Last name
        driver.findElement(By.name("LastName")).click();
        driver.findElement(By.name("LastName")).clear();
        driver.findElement(By.name("LastName")).sendKeys("Becker");
        //enter Email
        driver.findElement(By.name("Email")).click();
        driver.findElement(By.name("Email")).clear();
        driver.findElement(By.name("Email")).sendKeys("wbekker869" + "@gmail.com"); //чтобы тест много раз генерировался
        //enter Password
        driver.findElement(By.name("Password")).click();
        driver.findElement(By.name("Password")).clear();
        driver.findElement(By.name("Password")).sendKeys("Aa123456!");
        //confirm Password
        driver.findElement(By.name("ConfirmPassword")).click();
        driver.findElement(By.name("ConfirmPassword")).clear();
        driver.findElement(By.name("ConfirmPassword")).sendKeys("Aa123456!");

        //click Register button
        driver.findElement(By.name("register-button")).click();

        //assert Log Out button (link)
        Assert.assertTrue(isElementPresent(By.xpath("//*[@class='header']//li[2]")));
    }

    //negative test
    @Test
    public void existedUserRegisterNegativeTest(){

        //click on Register button (Link) in the header
        driver.findElement(By.cssSelector("[href='/register']")).click();
        //enter First name
        driver.findElement(By.name("FirstName")).click();
        driver.findElement(By.name("FirstName")).clear();
        driver.findElement(By.name("FirstName")).sendKeys("Wenzel");
        //enter Last name
        driver.findElement(By.name("LastName")).click();
        driver.findElement(By.name("LastName")).clear();
        driver.findElement(By.name("LastName")).sendKeys("Becker");
        //enter Email
        driver.findElement(By.name("Email")).click();
        driver.findElement(By.name("Email")).clear();
        driver.findElement(By.name("Email")).sendKeys("wbekker869@gmail.com");
        //enter Password
        driver.findElement(By.name("Password")).click();
        driver.findElement(By.name("Password")).clear();
        driver.findElement(By.name("Password")).sendKeys("Aa123456!");
        //confirm Password
        driver.findElement(By.name("ConfirmPassword")).click();
        driver.findElement(By.name("ConfirmPassword")).clear();
        driver.findElement(By.name("ConfirmPassword")).sendKeys("Aa123456!");

        //click Register button
        driver.findElement(By.name("register-button")).click();

    }

    public boolean isAlertPresent (){
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.alertIsPresent());
            if (alert == null){
                return false;
            } else {
                return true;
            }
        }
}
