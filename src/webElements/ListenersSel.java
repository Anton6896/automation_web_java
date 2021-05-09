package webElements;

import org.openqa.selenium.*;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(ListenerTest.class)

public class ListenersSel {

    private final WebDriver DRIVER = new DriverData("chrome").getDriver();
    private final EventCapture EVENT_CAPTURE = new EventCapture();
    private EventFiringWebDriver event = new EventFiringWebDriver(DRIVER);

    @Test
    void scrollPage() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) DRIVER;
        EventFiringWebDriver event = new EventFiringWebDriver(DRIVER);
        event.register(EVENT_CAPTURE);

        event.navigate().to("https://www.guru99.com/scroll-up-down-selenium-webdriver.html");
        // scroll till see element
        WebElement element = DRIVER.findElement(By.cssSelector(".item-page > div:nth-child(3) > pre:nth-child(59)"));
        js.executeScript("arguments[0].scrollIntoView();", element);

        Thread.sleep(4000);

//        event.quit();
//        event.unregister(EVENT_CAPTURE);
        DRIVER.close();
    }

    @Test
    void beforeAndAfter() {
        JavascriptExecutor js = (JavascriptExecutor) DRIVER;
        EventFiringWebDriver event = new EventFiringWebDriver(DRIVER);
        event.register(EVENT_CAPTURE);

        event.navigate().to("https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html");
        DRIVER.findElement(By.cssSelector(".glyphicon-th")).click();
        DRIVER.findElement(By.cssSelector(".datepicker-days > table:nth-child(1) > tbody:nth-child(2) >" +
                " tr:nth-child(2) > td:nth-child(5)")).click();

        DRIVER.close();

    }
}

/**
 * after ech event create your part of code that will be executed
 * in test events handler
 */
class EventCapture implements WebDriverEventListener {

    @Override
    public void beforeAlertAccept(WebDriver webDriver) {

    }

    @Override
    public void afterAlertAccept(WebDriver webDriver) {

    }

    @Override
    public void afterAlertDismiss(WebDriver webDriver) {

    }

    @Override
    public void beforeAlertDismiss(WebDriver webDriver) {

    }

    @Override
    public void beforeNavigateTo(String s, WebDriver webDriver) {

    }

    @Override
    public void afterNavigateTo(String s, WebDriver webDriver) {
        System.out.println("this is the listener function");
    }

    @Override
    public void beforeNavigateBack(WebDriver webDriver) {

    }

    @Override
    public void afterNavigateBack(WebDriver webDriver) {

    }

    @Override
    public void beforeNavigateForward(WebDriver webDriver) {

    }

    @Override
    public void afterNavigateForward(WebDriver webDriver) {

    }

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {

    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {

    }

    @Override
    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {

    }

    @Override
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {

    }

    @Override
    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {

    }

    @Override
    public void afterClickOn(WebElement webElement, WebDriver webDriver) {

    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {

    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {

    }

    @Override
    public void beforeScript(String s, WebDriver webDriver) {

    }

    @Override
    public void afterScript(String s, WebDriver webDriver) {

    }

    @Override
    public void beforeSwitchToWindow(String s, WebDriver webDriver) {

    }

    @Override
    public void afterSwitchToWindow(String s, WebDriver webDriver) {

    }

    @Override
    public void onException(Throwable throwable, WebDriver webDriver) {

    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> outputType) {

    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> outputType, X x) {

    }

    @Override
    public void beforeGetText(WebElement webElement, WebDriver webDriver) {

    }

    @Override
    public void afterGetText(WebElement webElement, WebDriver webDriver, String s) {

    }
}


/**
 * on test start or stop and any result handler for test
 */
class ListenerTest implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(" -- The overridden on test starts : " + result.getName());
    }

    public void onTestSuccess(ITestResult result) {
    }

    public void onTestFailure(ITestResult result) {
        System.out.println(" -- The overridden on test failure for test : " + result.getName());
    }

    public void onTestSkipped(ITestResult result) {
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }

    public void onStart(ITestContext context) {
    }

    public void onFinish(ITestContext context) {
    }
}
