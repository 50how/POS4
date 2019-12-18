package Page;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class ContentPage extends Page{
    public WebDriver driver;
    By content_home = By.xpath("//div[@class='pure-u-3-4']/a[3]");
    By word_home = By.cssSelector("[ui-sref='layout.contentmanage.teachingplan']>span");
    By playword = By.xpath("//tbody/tr[2]/td[7]");
    By clickword = By.cssSelector(".foot-list>li");
    By closeword = By.xpath("//div[@class='ngdialog-close']/*");

    public ContentPage(WebDriver driver){
        super(driver);
        this.driver= driver;

    }

    public void contentTitle () throws  InterruptedException{

        super.click(content_home);

        click(word_home);
        Thread.sleep(2000);
        waitElement(playword);
        click(playword);
        Thread.sleep(1000);
        List<WebElement> we = findElements(clickword);
        for(WebElement w:we){
            //w.click();
        }
        Thread.sleep(1000);
        //click(closeword);
        //driver.manage().window().maximize();
        WebElement s=driver.findElement(By.cssSelector(".title.ng-binding"));
        Dimension d =s.getSize();
        Actions actions= new Actions(driver);

        //伪元素控制
        actions.moveToElement(s,d.width/2,0).click().build().perform();
        Thread.sleep(10000);
        driver.quit();

    }

}
