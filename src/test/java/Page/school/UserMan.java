package Page.school;

import Page.Page;
import Po.UserTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserMan extends Page {

    public WebDriver driver;
    By get_user =By.xpath("//td[@class='operate']/a[3]");
    By totle_page = By.cssSelector(".total-page.ng-binding");
    By ocreate = By.cssSelector("[ng-show='!d.is_over_limit']>a");
    By uploadjpg = By.cssSelector("[type='file']");
    By loading =By.cssSelector(".mask.ng-hide");

    public UserMan(WebDriver driver){
        super(driver);
        this.driver=driver;
    }

    public void addTeacher() throws InterruptedException{
        driver.get("https://admin-ecampus-test.dtedu.com/#/layout/schoolmanage/school_list/%E9%BB%91%E9%BE%99%E6%B1%9F%E5%B0%8F%E5%AD%A6/1");
       Thread.sleep(2000);
        click(get_user);
        waitElement(totle_page);
        Thread.sleep(2000);
        click(ocreate);
        Thread.sleep(2000);
        inputText(uploadjpg,"c:\\t.jpg");
    }
}
