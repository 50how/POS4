package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class KnowledgePage extends Page{
    public WebDriver driver;
    By content_home = By.xpath("//div[@class='pure-u-3-4']/a[3]");
    By knowledge_home = By.cssSelector("[ui-sref='layout.contentmanage.knowledgepackage_tmp']>span");
    By add_know = By.cssSelector(".pure-button.button-xsmall.ng-scope");
    By know_name = By.id("name");
    By save_know =By.cssSelector("[click='ctrl.saveBasic()']");
    By last_c = By.cssSelector(".ui-tree-value.ng-binding");
    By last_s = By.cssSelector(".node_name");
    By add_k = By.cssSelector(".iconfont.dt-icon-add");
    By addStructure =By.cssSelector("[ng-click='ctrl.addStructure()']");
    By structure_name =By.id("new-structure-name");
    By move =By.cssSelector("[ng-click='ctrl.startResort()']");
    By k1 = By.xpath("//div[@ng-mousedown='ctrl.selectStructure(item)']/div[2]");
    By k2 = By.xpath("//div[@ng-mousedown='ctrl.selectStructure(item)']/div[3]");
    By h1 =By.xpath("//div[@class='kr-activities__bd sort-wrapper-mark ui-sortable']/div[1]");
    By h2 =By.xpath("//div[@class='kr-activities__bd sort-wrapper-mark ui-sortable']/div[2]");

    public KnowledgePage(WebDriver driver){
        super(driver);
        this.driver= driver;

    }

    public void know () throws  InterruptedException{

        super.click(content_home);
        Thread.sleep(500);
        click(knowledge_home);
        Thread.sleep(500);
        click(add_know);
        inputText(know_name,"语文");
        List<WebElement> sels =driver.findElements(By.cssSelector("[output='item.output']>select"));
        for(WebElement s:sels){
            Select sel = new Select(s);
            sel.selectByValue("0");
            Thread.sleep(500);
        }
        Thread.sleep(1000);
        click(last_c);
        Thread.sleep(500);
        click(last_s);

        click(save_know);
        Thread.sleep(800);
        List<WebElement> list = driver.findElements(add_k);
        for (WebElement l :list){
            System.out.println(l.getClass());
            l.click();
            Thread.sleep(500);
        }

        click(addStructure);
        inputText(structure_name,"环节2");
        driver.findElement(structure_name).sendKeys(Keys.ENTER);

        click(move);

        Actions actions= new Actions(driver);
        actions.dragAndDrop(findElement(k1),findElement(k2)).build().perform();
        actions.dragAndDrop(findElement(h1),findElement(h2)).build().perform();
        Thread.sleep(5000);

    }

}
