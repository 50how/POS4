package Page.school;

import Page.Page;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class SchoolPage extends Page {
	WebDriver dirver;
	By addschool = By.cssSelector("a[href='#/layout/schoolmanage/school_detail//1///']");
	By schoolname = By.cssSelector("input[ng-model='d.school_name']");
	By province = By.id("province");
	By city = By.id("city");
	By district = By.id("district");
	By street =By.cssSelector("input[placeholder='请输入街道等详细地址']");
	By timestart = By.cssSelector("input[model='d.effective_time.start']");
	By timeend = By.cssSelector("input[model='d.effective_time.end']");
	By usernumber = By.cssSelector("input[ng-model='d.account_number']");
	By saveschool = By.cssSelector("button[ng-click='f.saveSchool()']");
	By wait_first_semester = By.cssSelector("div[ng-show='!d.calendar.term[0][0]']");
	By button_firstsem = By.cssSelector("button[ng-click='f.setStartEnd(0)']");
	By start_semester = By.cssSelector("input[model='d.dialog.start']");
	By end_semester = By.cssSelector("input[model='d.dialog.end']");
	By save_semester =By.cssSelector("a[ng-click='f.saveStartEnd()']");
	By schoolsearch = By.id("keywords");
	By school_search_click= By.cssSelector("button[ng-click='search()']");
	By s_table = By.className("middle");
	By total_page = By.cssSelector("span[ng-bind='config.total_page']");
	By school_details = By.cssSelector(".operate>a");
	By school_Date =By.xpath("//ul[@class='tabs']/li[2]");
	By first_Date = By.cssSelector("[ng-show='d.calendar.term[0][0]']>div>span");


	public SchoolPage(WebDriver driver) {
		
		super(driver);
		// TODO Auto-generated constructor stub
		this.dirver=driver;
	}

	public WebDriver getDirver(){
		return dirver;
	}


	public void addSchool() {
		super.click(addschool);
	}
	
	public void inputname(String text) {
		super.inputText(schoolname, text);
	}
	
	public void selectPro(String text) {
		super.selectText(province,text);
		
	}
	
	public void selectCity(String text) {
		super.selectText(city,text);
		
	}
	
	public void selectDis(String text) {
		super.selectText(district,text);
		
	}
	
	public void inputStreet(String text) {
		super.inputText(street, text);
	}
	
	public void inputTimeStart(String text) {
		super.inputText(timestart, text);
		super.click(timestart);
	}
	
	public void inputTimeEnd(String text) {
		super.inputText(timeend, text);
		super.click(timeend);
	}
	
	public void inputUserNumber(String text) {
		super.inputText(usernumber, text);
	}

	public void saveSchool(){
		super.click(saveschool);
	}

	public WebElement waitSemester(){
		return super.getWaitElement(wait_first_semester);
	}

	public void setSemester(){
		waitSemester().findElement(button_firstsem).click();
	}

	public void setStartSemester(String t){
		super.inputText(start_semester,t);
		super.click(start_semester);
	}

	public void setEndSemester(String t){
		super.inputText(end_semester,t);
		super.click(end_semester);
	}

	public void saveSemester(){
		super.click(save_semester);
	}

	public void sSearch(String t){
		super.inputText(schoolsearch,t);
	}

	public void sSearchClick(){
		super.click(school_search_click);
	}

	public  ArrayList sGetTable(){
		return super.getTable(s_table);
	}

	public int getSchoolTotalPage(){
		return Integer.parseInt(super.findElement(total_page).getText());
	}

	public String schoolDetails()throws InterruptedException{
		super.click(school_details);
		Thread.sleep(1000);
		String value = super.getInputValue(super.findElement(schoolname));
		System.out.println(value);
		super.click(school_Date);
		Thread.sleep(1000);
		System.out.println(super.findElement(first_Date).getText());
		return value;

	}






}
