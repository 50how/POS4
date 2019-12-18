package Po;

import Base.BaseDriver;
import Page.LoginPage;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;


//@Listeners({TestFailListener.class}) //监听截图
@Feature("首页")
//@Test(groups = "init")
public class LoginTest  {

     public  static  WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = BaseDriver.getDriver();

    }

   // @Feature("父级")
   @Test(description = "登录",groups = "init")
   //@Step("Type {aTest.name} / {aTest.pwd}.")
   // @Story("子级")
    public void login() throws InterruptedException {


       LoginPage login =new LoginPage(driver);
       login.getHomePage();
       login.inputUser("15647897451");
       login.inputPwd("admin123456");
       Thread.sleep(500);
       login.loginClick();
       new WebDriverWait(driver, 10).until(
               ExpectedConditions.presenceOfElementLocated(By.className("middle"))
       );
       login.getLocalStorage();
       String a = login.getTitle();
       // Thread.sleep(1000);
       //Assert.assertEquals(a, "学校管理");
       Reporter.log("Login success");
    //Assert.fail("内容访问错误");



   }

   @AfterClass
    public void afterClass(){
       driver.quit();
   }
}
