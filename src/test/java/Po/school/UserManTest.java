package Po.school;

import Base.BaseDriver;
import Page.Page;
import Page.school.UserMan;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class UserManTest {

    WebDriver driver = BaseDriver.getDriver();
    UserMan us = new UserMan(driver);

    @Test(dependsOnGroups = {"init"})
    public void addT() throws InterruptedException {
        us.getHomePage();
        us.addTeacher();
    }


}
