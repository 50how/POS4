package Base;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
/*
失败重试，,断言和notfindID都不会重试
 */
    private int retryCount = 1;
    private static int maxRetryCount =2;//重试次数

            public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
    }
     return false;
 }

}
