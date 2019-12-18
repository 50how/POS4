package Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.testng.Reporter;

import Page.Page;

import org.openqa.selenium.By;

public class LoginPage extends Page{
	public WebDriver driver;
	By user = By.id("username");
	By pwd = By.id("password");
	By l_click = By.className("submit");
	

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		
	}
	
	public void getHomePage() {
		driver.get(HOMEURL);
	}
	
	public void inputUser(String text) {
		super.inputText(user, text);
		
	}
	
	public void inputPwd(String text) {
		super.inputText(pwd, text);
		
	}
	
	public void loginClick() {
		super.click(l_click);
		Reporter.log("Login success");
	}



}
