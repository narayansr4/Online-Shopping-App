package com.shoppingApp.testComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.shoppingApp.base.Base;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends Base implements ITestListener {

    ExtentReports extent = ExtentReporter.getExtentReportsObj();
    ExtentTest test;
    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS,"Test is Passed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP,"Test is Skipped");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        //test.log(Status.FAIL,"Screenshot Below: " + test.addScreenCaptureFromPath(ScreenshotUtils.captureScreenshot(result.getMethod().getMethodName())));
        test.fail(result.getThrowable());
        String path = ScreenShot.captureScreenshot(result.getMethod().getMethodName());
        test.addScreenCaptureFromPath(path);
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
