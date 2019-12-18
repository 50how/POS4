package Po;

import Base.BaseDriver;
import Page.ContentPage;
import Page.UserManPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

;

@Test(dependsOnGroups = {"init.*"})
public class ContentTest extends BaseDriver {

	WebDriver driver = BaseDriver.getDriver();
    ContentPage cont = new ContentPage(driver);
  @BeforeClass
  public void beforeClass() {
	  ChromeOptions chromeOptions = new ChromeOptions();
	  chromeOptions.addArguments("--headless","--disable-gpu","--window-size=1920,1080");
	  //driver = new ChromeDriver();


  }
	
  @Test//(priority=1,description="登录")
  public void content() throws InterruptedException {
		cont.getHomePage();
		Thread.sleep(2000);
		cont.contentTitle();
  }

  
  @AfterClass
  public void afterClass() {
        driver.quit();
  }
}
