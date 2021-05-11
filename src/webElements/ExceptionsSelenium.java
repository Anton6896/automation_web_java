package webElements;

import Data.DriverData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ExceptionsSelenium {
    @Test
    void look() {
        DriverData dd = new DriverData("firefox");
        WebDriver driver = dd.getDriver();

        try {
            driver.get("https://www.google.com");
            driver.findElement(By.id("fake")).click();

        } catch (NoSuchElementException e) {
            System.out.println("Have no element fond ");
        } finally {
            // will always execute
            driver.close();
        }

        System.out.println("suite is continue to work");
    }
}

