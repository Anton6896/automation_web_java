

package webElements;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Use firefox as platform
 */

public class WaiteElem {

    static String driverPath = null;
    static WebDriver driver;
    private static String OS = null;

    static void mySys() {
        if (OS == null) {
            OS = System.getProperty("os.name");
        }

        if ("Windows 10".equals(OS)) {
            driverPath = "drivers_for_selenium" + File.separator +
                    "geckodriver-v0.29.1-win64" + File.separator +
                    "geckodriver.exe";
        }

    }

    public static void main(String[] args) {
        mySys();
        System.setProperty("webdriver.gecko.driver", driverPath);
        WebDriver driver = new FirefoxDriver();

        // implicit wait (all element on page will have an 10 sec for appearance)
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().deleteAllCookies();
        driver.get("https://www.seleniumeasy.com/test/table-records-filter-demo.html");

        // explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn:nth-child(1)"))).click();

        String isGreen = wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.cssSelector(".table > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(3) >" +
                        " div:nth-child(1) > div:nth-child(2) > h4:nth-child(2) > span:nth-child(1)")))).getText();

        if ("(Green)".equals(isGreen)) {
            System.out.println("isGreen ok ");
        }

        driver.close();
    }

    static void waitForValue(WebDriver driver, WebElement element, int timeout, @NotNull String value) {
        // explicit wait
        // wait for element on age and compare the value to element's text value
        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
        String txt = element.getText();
        if (value.equals(txt)) {
            System.out.println("test green ok");
        }
    }
}
