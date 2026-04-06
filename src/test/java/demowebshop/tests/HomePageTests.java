package demowebshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {

    @Test
    //2е действие, создаем первый тест
   public void isHomeComponentPresentTest(){
       //System.out.println("Home component" + isHomeComponentPresent()); - это чтобы увидеть в консоли результат проверки
       Assert.assertTrue(isHomeComponentPresent()); // так мы сравниваем результат, так должен заканчиваться тест
   }

}
