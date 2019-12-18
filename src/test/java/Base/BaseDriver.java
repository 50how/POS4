package Base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.WebDriver;

public class BaseDriver {
    //public  static WebDriver driver ;

   public static WebDriver getDriver(){


       ChromeOptions chromeOptions = new ChromeOptions();
       chromeOptions.addArguments("--headless","--disable-gpu","--window-size=1920,1080");
       WebDriver driver = new ChromeDriver();

       return driver;
   }

     /*@BeforeClass
     public void beforeSuite() throws InterruptedException {

         driver = new ChromeDriver();
 
         //Thread.sleep(3000);

     }

     //@AfterMethod
     public void afterM(){

         //        System.out.println("after suite 运行");
         driver.quit();
     }

     //@AfterSuite
     public void afterSuite(){
      
 //        System.out.println("after suite 运行");
         driver.quit();
     } */

}