package by.bsu.framework.util;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import by.bsu.framework.driver.DriverSingleton;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;

import static by.bsu.framework.util.FormatterPattern.CURRENT_TIME_FORMATTER;


public class TestListener implements ITestListener {
    private Logger logger = LogManager.getLogger(TestListener.class);

    public void onTestStart(ITestResult iTestResult) {}

    public void onTestSuccess(ITestResult iTestResult) {}

    public void onTestFailure(ITestResult iTestResult) {
        saveScreenshot();
    }

    public void onTestSkipped(ITestResult iTestResult) {}

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {}

    public void onStart(ITestContext iTestContext) {}

    public void onFinish(ITestContext iTestContext) {}

    private void saveScreenshot(){
        File screenCapture = ((TakesScreenshot) DriverSingleton
                .getDriver())
                .getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenCapture, new File(
                    ".//target/screenshots/"
                            + getCurrentTimeAsString() +
                            ".png"));
        } catch (IOException e) {
            logger.log(Level.ERROR, "Failed to save screenshot: ", e);
        }
    }

    private String getCurrentTimeAsString(){
        return ZonedDateTime.now().format(CURRENT_TIME_FORMATTER);
    }
}