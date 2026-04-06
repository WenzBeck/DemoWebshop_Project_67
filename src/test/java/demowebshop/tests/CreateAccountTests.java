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
        existedUserRegisterNegativeTest();

        //assert Log Out button (link)
        Assert.assertTrue(isElementPresent(By.xpath("//*[@class='header']//li[2]")));
    }



    //negative test
    @Test
    public void existedUserRegisterNegativeTest(){

        String text = "test" + System.currentTimeMillis() + "@test.com";

        //click Register link
        click(By.cssSelector("[href='/register']"));

        //enter First name
        type(By.name("FirstName"), "Wenzel");

        //enter Last name
        type(By.name("LastName"), "Becker");

        //enter Email
        type(By.name("Email"), text);

        //enter Password
        type(By.name("Password"), "Aa123456!");

        //confirm Password
        type(By.name("ConfirmPassword"), "Aa123456!");

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
