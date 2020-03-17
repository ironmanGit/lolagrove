package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import controllers.WebDriverFactory;
import utils.ExtentReports.ExtentManager;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.ExtentReports.ExtentTestManager;

public class TestListener extends WebDriverFactory implements ITestListener {
 
	private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }
 
    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("I am in onStart method " + iTestContext.getName());
        iTestContext.setAttribute("WebDriver", getWebDriver());
    }
 
    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("I am in onFinish method " + iTestContext.getName());
        //Do tier down operations for extentreports reporting!
        ExtentTestManager.endTest();
        ExtentManager.getReporter().flush();
    }
 
    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("I am in onTestStart method " + getTestMethodName(iTestResult) + " start");
    }
 
    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("I am in onTestSuccess method " + getTestMethodName(iTestResult) + " succeed");
        //ExtentReports log operation for passed tests.
        ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed");
    }
 
    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("I am in onTestFailure method " + getTestMethodName(iTestResult) + " failed");
 
        //Get driver from BaseTest and assign to local webDriver variable.
        Object testClass = iTestResult.getInstance();
        WebDriver webDriver = getWebDriver();
 
        //Take base64Screenshot screenshot.
        String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) webDriver).
            getScreenshotAs(OutputType.BASE64);
 
        //ExtentReports log and screenshot operations for failed tests.
        ExtentTestManager.getTest().log(LogStatus.FAIL, "Test Failed",
            ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
    }
 
    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("I am in onTestSkipped method " + getTestMethodName(iTestResult) + " skipped");
        //ExtentReports log operation for skipped tests.
        ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
    }
 
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }
//    
//    //Extent Report Declarations
//    private static ExtentReports extent = ExtentManager.createInstance();
//    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
// 
//    @Override
//    public synchronized void onStart(ITestContext context) {
//        System.out.println("Campaign Test Suite started!");
//    }
// 
//    @Override
//    public synchronized void onFinish(ITestContext context) {
//        System.out.println(("Campaign Test Suite is ending!"));
//        extent.flush();
//    }
// 
//    @Override
//    public synchronized void onTestStart(ITestResult result) {
//        System.out.println((result.getTestContext().getAttribute("description").toString() + " started!"));
//        ExtentTest extentTest = extent.createTest(result.getTestContext().getAttribute("description").toString(),result.getTestContext().getAttribute("description").toString());
//        test.set(extentTest);
//    }
// 
//    @Override
//    public synchronized void onTestSuccess(ITestResult result) {
//        System.out.println((result.getTestContext().getAttribute("description").toString() + " passed!"));
//        test.get().pass("Test passed");
//    }
// 
//    @Override
//    public synchronized void onTestFailure(ITestResult result) {
//        System.out.println((result.getTestContext().getAttribute("description").toString() + " failed!"));
//        test.get().fail(result.getThrowable());
//    }
// 
//    @Override
//    public synchronized void onTestSkipped(ITestResult result) {
//        System.out.println((result.getTestContext().getAttribute("description").toString() + " skipped!"));
//        test.get().skip(result.getThrowable());
//    }
// 
//    @Override
//    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//        System.out.println(("onTestFailedButWithinSuccessPercentage for " + result.getTestContext().getAttribute("description").toString()));
//    }
}