package Po;

import Base.BaseDriver;
import Page.ContentPage;
import Page.KnowledgePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

;

@Test(dependsOnGroups = {"init.*"})
public class KnowledgeTest extends BaseDriver {

	WebDriver driver = BaseDriver.getDriver();
    KnowledgePage know = new KnowledgePage(driver);
  @BeforeClass
  public void beforeClass() {
	  ChromeOptions chromeOptions = new ChromeOptions();
	  chromeOptions.addArguments("--headless","--disable-gpu","--window-size=1920,1080");
	  //driver = new ChromeDriver();


  }
	
  @Test//(priority=1,description="登录")
  public void content() throws InterruptedException {
      know.getHomePage();
      Thread.sleep(1000);
      know.know();

  }

  
  @AfterClass
  public void afterClass() {
        driver.quit();
  }
}
