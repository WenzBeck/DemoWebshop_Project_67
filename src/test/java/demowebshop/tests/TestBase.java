package demowebshop.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    WebDriver driver;


    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup(); //для постоянного обновления
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    // перенес type и click т.к ItemTests не находила метод click
    public void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }


    public void click(By locator) {
        driver.findElement(locator).click();
    }
    // 1е действие, ищем элемент на главной странице
    public boolean isHomeComponentPresent(){
         //наверху меняем на boolean, дальше перед райвер ставим return, меняем findElement на findElements, в конце добавляем .size()>0
         return driver.findElements(By.xpath("//div[@class='center-3']")).size()>0;
    }

    //3е действие, создаем универсальный метод, будет возвращать любой элемент
     public boolean isElementPresent(By locator){
         return driver.findElements(locator).size()>0;
     }

     //предусловие по Логин
    public void login(String email, String password){
        click(By.cssSelector("[href='/login']"));

        typeLogin(By.id("Email"), email);
        typeLogin(By.id("Password"), password);

        click(By.cssSelector("[value='Log in']"));
    }

    public void typeLogin(By locator, String text){
        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    @AfterMethod (enabled = false)
     public void tearDown(){
         driver.quit();
     }
}
