package Page;
import org.checkerframework.common.value.qual.ArrayLenRange;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class Page {
	public static String LOGIN_TOKEN ;
	public static String LOGIN_USER ;
	public static String HOMEURL="https://admin-ecampus-test.dtedu.com";
	
	public WebDriver driver;
	
	public Page(WebDriver driver){
		
		this.driver=driver;
		
	}
	
	public WebElement findElement(By by) {
		WebElement element = driver.findElement(by);
		return element;
	}

	public List findElements(By by){
		List <WebElement> e = driver.findElements(by);
		return e;
	}

	public void waitElement(By by){
		new WebDriverWait(driver, 10).until(
				ExpectedConditions.presenceOfElementLocated(by)
		);
	}

/*
等待元素出现，但存在元素存在页面未加载完成的情况
 */
	public WebElement  getWaitElement(final By by){
		WebElement e=(new WebDriverWait( driver, 10)) .until(
				new ExpectedCondition< WebElement>(){
					@Override
					public WebElement apply( WebDriver d) {
						return d.findElement(by);
					}
				}
		);
		return e;
	}
	
	public void inputText(By by,String text) {
		driver.findElement(by).sendKeys(text);
	}
	
	public void click(By by) {
		driver.findElement(by).click();
	}
	
	public String  getTitle() {
		return driver.getTitle();
	}
	
	public Select select(By by){
		Select s = new Select(driver.findElement(by));
		return s;
	}
	
	public void  selectText(By by,String text) {
		Select s = new Select(driver.findElement(by));
		s.selectByVisibleText(text);
	
	}
	
	public void  selectIndex(By by,int i) {
		Select s = new Select(driver.findElement(by));
		s.selectByIndex(i);
	
	}

	/*
	取token的值用于多线程免登录
	 */

	public void getLocalStorage(){
		LocalStorage localStorage = ((WebStorage) driver).getLocalStorage();
		LOGIN_TOKEN =localStorage.getItem("token");
		LOGIN_USER =localStorage.getItem("user");
		//String token =((WebStorage) driver).getLocalStorage().getItem("token");
	}

	private void setLocalStorage(){
		LocalStorage localStorage = ((WebStorage) driver).getLocalStorage();
		localStorage.setItem("token",LOGIN_TOKEN);
		localStorage.setItem("user",LOGIN_USER);
	}

	public void getHomePage(){

		driver.get(HOMEURL);
		setLocalStorage();
		driver.get(HOMEURL);
	}



	public ArrayList getTable(By by){
		ArrayList<String> table = new ArrayList<String>();
		WebElement t= driver.findElement(by);
		List<WebElement> trs=t.findElements(By.tagName("tr"));
		for (WebElement tr: trs){
			List<WebElement>tds =tr.findElements(By.tagName("td"));
			for(WebElement td :tds){
				table.add(td.getText());
			}
		}
		for(String a:table){
			System.out.println(a);
		}
		return table;
	}


	/*
	通过JS取input框上的值
	 */
	public  String getInputValue(WebElement element)
	{
		JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;
		try
		{
			String value = javaScriptExecutor.executeScript("return arguments[0].value", element).toString();
			return value;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
/*
移动鼠标到元素中心点延申的x,y位置后点击，也可控伪元素点击
 */
	public void moveElement(WebElement e,int x,int y){
		Actions at = new Actions(driver);
		at.moveToElement(e,x,y).click().build().perform();
	}


	/*
	将元素A拖拉到元素B的位置
	 */
	public void dragAndDrop(By a,By b){
		Actions at = new Actions(driver);
		at.dragAndDrop(findElement(a),findElement(b)).build().perform();
	}


}
