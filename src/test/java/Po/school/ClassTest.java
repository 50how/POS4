package Po.school;

import Page.school.ClassMan;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ClassTest {

    ClassMan classman = new ClassMan(SchoolTest.driver);

    @BeforeClass
    public void beforeClass(){

    }

    @Test(dependsOnGroups = {"d2"},groups = "d3")
    public void goClass() throws InterruptedException{
        classman.addClass("1班","一年级");
        classman.addT_S();

    }




}
