package utils.listeners;

import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.BaseTest;
import utils.reports.Reporter;

/**
 * Overrides the TestNG listener methods to log results in the ExtentReport.
 * This setup does not support parallel execution
 */

public class TestNGListener extends BaseTest implements ITestListener {
    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onTestStart(ITestResult result) {
        Reporter.test = Reporter.extent.createTest(getTestMethodName(result));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Reporter.test.log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        //TODO add Failure log with images
    }

    @Override
    public void onStart(ITestContext context) {
        Reporter.setupExtentReport();
        context.setAttribute("WebDriver", this.driver);
    }

    @Override
    public void onFinish(ITestContext context) {
        Reporter.extent.flush();
    }
}
