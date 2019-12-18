package Base;

import Page.Page;
import Po.LoginTest;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

//监听截图
public class TestFailListener extends TestListenerAdapter {
   
    @Override
    public void onTestFailure(ITestResult result) {

        takePhoto();
    }

    @Attachment(value = "screen shot",type = "image/png")
    public byte[]  takePhoto(){
        byte[] screenshotAs = ((TakesScreenshot) BaseDriver.getDriver()).getScreenshotAs(OutputType.BYTES);
        return screenshotAs;
    }



}