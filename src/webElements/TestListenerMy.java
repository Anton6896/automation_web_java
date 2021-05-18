package webElements;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


/**
 * must be a separate public class -> Logging implementation
 */
public class TestListenerMy implements ITestListener {
    @Override
    public void onStart(ITestContext context) {
        System.out.println();
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(result.getName() + " Case started -- ");
    }
}
