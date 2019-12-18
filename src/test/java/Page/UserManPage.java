package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserManPage extends Page{
    public WebDriver driver;
    By user_man_home = By.xpath("//div[@class='pure-u-3-4']/a[2]");

    public UserManPage(WebDriver driver){
        super(driver);
        this.driver= driver;

    }

    public void userManTitle (){
        super.click(user_man_home);
    }

}
