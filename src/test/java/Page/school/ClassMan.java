package Page.school;

import Page.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClassMan extends Page {
    private WebDriver driver;
    By goclass =By.xpath("//td[@class='operate']/a[2]");
    By addclass = By.cssSelector(".pure-u-1-2.tr>a");
    By classname = By.cssSelector("[ng-model='d.my_class_name']");
    By sel_class = By.id("my_grade_id");
    By sure_add = By.cssSelector("[click='f.saveClass()']");
    By sel_grade = By.id("grade-id");
    By search = By.cssSelector("[ng-click='search()']");
    By t_and_s = By.xpath("//td[@class='operate']/a[2]");
    By add_t = By.cssSelector("[ng-click='f.openAddusersDialog()']");
    By input_t = By.id("keyword");
    By click_t =By.cssSelector(".ng-scope.user>span");
    By search_t = By.cssSelector("[type='button']");
    By sure_add_t = By.cssSelector("[ng-click='f.addUsers()']");
    By remove_t =By.cssSelector(".operate>a");
    By remove_ok = By.cssSelector("[ng-click='confirm()']");

    public ClassMan(WebDriver driver){
        super(driver);
        this.driver=driver;
    }



    public void addClass(String name,String adclass) throws InterruptedException{
        super.click(goclass);
        waitElement(addclass);
        super.click(addclass);
        super.waitElement(classname);
        super.inputText(classname,name);
        super.selectText(sel_class,adclass);
        super.click(sure_add);
        waitElement(sel_grade);
        Thread.sleep(500);
        selectText(sel_grade,adclass);
        click(search);

    }

    public void addT_S() throws InterruptedException {
        Thread.sleep(500);
        click(t_and_s);
        Thread.sleep(500);
        click(add_t);
        Thread.sleep(500);
        inputText(input_t,"123");
        click(search_t);
        Thread.sleep(500);
        click(click_t);
        click(sure_add_t);
        Thread.sleep(1000);
        click(remove_t);
        click(remove_ok);

    }



}