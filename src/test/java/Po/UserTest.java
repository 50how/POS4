package Po;

import Base.BaseDriver;
import Page.UserManPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

;

@Test(dependsOnGroups = {"init.*"})
public class UserTest extends BaseDriver {

	WebDriver driver = BaseDriver.getDriver();
	UserManPage user = new UserManPage(driver);
  @BeforeClass
  public void beforeClass() {
	  ChromeOptions chromeOptions = new ChromeOptions();
	  chromeOptions.addArguments("--headless","--disable-gpu","--window-size=1920,1080");
	  //driver = new ChromeDriver();


  }
	
  @Test//(priority=1,description="登录")
  public void userMan() throws InterruptedException {
		user.getHomePage();
		Thread.sleep(2000);
		user.userManTitle();
  }

  
  @AfterClass
  public void afterClass() {

  }
}
