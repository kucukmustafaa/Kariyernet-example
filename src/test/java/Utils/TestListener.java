package Utils;

import Base.BaseTest;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends BaseTest implements ITestListener {

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        ExtentReportManager.flushReport();
    }
    @Override
    public void onTestStart(ITestResult iTestResult) {
        ExtentReportManager.createExtentTest(getTestMethodName(iTestResult));
    }
    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        ExtentReportManager.getExtentTest().pass(getTestMethodName(iTestResult));
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println(getTestMethodName(iTestResult) + " test is failed.");
        ExtentReportManager.getExtentTest().fail(getTestMethodName((ITestResult) iTestResult.getThrowable()));
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        ExtentReportManager.getExtentTest().skip(getTestMethodName(iTestResult)+" test skipped");
    }

}