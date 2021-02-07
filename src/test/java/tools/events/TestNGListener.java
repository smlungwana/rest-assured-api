package tools.events;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener {

    private long startTime;

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("TestNG Listener : Starting Test "+result.getName());
        startTime = result.getStartMillis();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        long endTime = result.getEndMillis();
        System.out.println("TestNG Listener : Test Time : "+ (endTime - startTime));
    }

}
