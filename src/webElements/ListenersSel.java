package webElements;

import org.openqa.selenium.*;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.annotations.Test;


public class ListenersSel {

    private static final WebDriver DRIVER = new DriverData().getDriver();
    private static final EventCapture EVENT_CAPTURE = new EventCapture();

    public static void main(String[] args) throws InterruptedException {
        scrollPage();

    }

    @Test
    static void scrollPage() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) DRIVER;
        EventFiringWebDriver event = new EventFiringWebDriver(DRIVER);
        event.register(new EventCapture());

        event.navigate().to("https://www.guru99.com/scroll-up-down-selenium-webdriver.html");
        // scroll till see element
        WebElement element = DRIVER.findElement(By.cssSelector(".item-page > div:nth-child(3) > pre:nth-child(59)"));
        js.executeScript("arguments[0].scrollIntoView();", element);


        Thread.sleep(4000);
        DRIVER.close();
    }
}

/**
 * after ech event create your part of code that will be executed
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
