package webElements;

import Data.DriverData;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ListenersSel {

    @Test
    void scrollPage() throws InterruptedException {
        WebDriver driver = new DriverData("chrome").getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        EventFiringWebDriver event = new EventFiringWebDriver(driver);
        EventCapture eCapture = new EventCapture();
        event.register(eCapture);

        event.navigate().to("https://www.guru99.com/scroll-up-down-selenium-webdriver.html");

//        try {
//            WebDriverWait wait = new WebDriverWait(DRIVER, 5);
//            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"om-dgojyzueujjf7huvd8jh-yesno\"]" +
//                    "/div/button/svg"))).click();
//        } catch (TimeoutException e) {
//            System.out.println(" no elem");
//        }

        // scroll till see element
        WebElement element = driver.findElement(By.cssSelector(".item-page > div:nth-child(3) > pre:nth-child(59)"));
        js.executeScript("arguments[0].scrollIntoView();", element);


        event.quit();
        event.unregister(eCapture);
        driver.quit();
    }

    @Test
    void beforeAndAfter() {
        WebDriver DRIVER = new DriverData("chrome").getDriver();
        EventCapture eCapture = new EventCapture();
        EventFiringWebDriver event = new EventFiringWebDriver(DRIVER);
        event.register(eCapture);

        event.navigate().to("https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html");
        DRIVER.findElement(By.cssSelector(".glyphicon-th")).click();
        DRIVER.findElement(By.cssSelector(".datepicker-days > table:nth-child(1) > tbody:nth-child(2) >" +
                " tr:nth-child(2) > td:nth-child(5)")).click();

        event.quit();
        event.unregister(eCapture);
        DRIVER.quit();
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

