package Po.school;

import Base.BaseDriver;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Page.school.SchoolPage;;

@Test(dependsOnGroups = {"init.*"},groups= "d2")
@Feature("学校管理")
public class SchoolTest  {
	static WebDriver driver = BaseDriver.getDriver();
	SchoolPage school = new SchoolPage(driver);
	String s_name="黑龙江小学";


  @BeforeClass
  public void beforeClass() {
	  ChromeOptions chromeOptions = new ChromeOptions();
	  chromeOptions.addArguments("--headless","--disable-gpu","--window-size=1290,1080");
	  //driver = new ChromeDriver();


  }


  @Test(priority=1,enabled = true,description = "添加学校")//(priority=2,dependsOnMethods="login")
  @Story("添加学校")
  public void schoolAdd() throws InterruptedException {
  	/*
	   Thread.sleep(2000);
	    school.getHomePage();
	    Thread.sleep(2000);
	    school.addSchool();
	    Thread.sleep(1000);
	    school.inputname("天河小学1");
	    school.selectPro("广东省");
	    school.selectCity("广州市");
	    school.selectDis("天河区");
	    school.inputStreet("187号");
	    school.inputTimeStart("2019/12/11");
	    school.inputTimeEnd("2020/12/11");
	    school.inputUserNumber("100");
	    ///////school.saveSchool();
	    Thread.sleep(3000);
	    //school.waitSemester();
	    school.setSemester();
	    Thread.sleep(1000);
	    school.setStartSemester("2019/12/11");
	    school.setEndSemester("2020/1/11");
	    school.saveSemester();
	    Thread.sleep(1000);
	*/
  }

  @Test(priority=2,enabled = true,description = "学校搜索")
  @Story("页面基本功能")
  public void schoolSearch() throws InterruptedException{

	  school.getHomePage();
	  Thread.sleep(2000);
	  school.sSearch(s_name);
	  school.sSearchClick();
	  Thread.sleep(1000);
	  Assert.assertTrue(school.sGetTable().contains(s_name),"学校搜索失败");


  }

  @Test(priority=3,enabled = true,description = "表格翻页")
  @Story("页面基本功能")
  public void schoolChangePage(){
	  System.out.println(school.getSchoolTotalPage());
  }

  @Test(priority=4,description = "学校详情查询",enabled = false)
  @Story("学校详情")
  public void schoolDetails()throws InterruptedException{

	  Assert.assertTrue(school.schoolDetails().contains(s_name),"学校详情查看失败");
  }

  @AfterClass
  public void afterClass() {
	  //driver.quit();
  }
  
}
