package demowebshop.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    @Test
    public void newUserRegisterPositiveTest(){

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

        //assert
        Assert.assertTrue(isElementPresent(By.xpath("//*[@class='header']//li[2]")));
    }
}
