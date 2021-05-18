package ActionClassMy;

import DriverProperties.DriverData;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ex2 {
    WebDriver driver;
    String page = "https://www.seleniumeasy.com/test/drag-and-drop-demo.html";

    @BeforeTest
    void before() {
        driver = new DriverData("chrome").getDriver();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1000, 1200));
    }

    // look in drop down menu
    @Test
    void look_1() throws InterruptedException {
        driver.navigate().to(page);
        Actions builder = new Actions(driver);

        WebElement dragElem = driver.findElement(By.cssSelector("#todrag > span:nth-child(2)"));
        WebElement dropPlace = driver.findElement(By.id("mydropzone"));

        Action seriesOfActions;
        seriesOfActions = builder
                .moveToElement(dragElem)
                .clickAndHold()
                .moveToElement(dropPlace)
                .release()
                .build();

        seriesOfActions.perform();
        Thread.sleep(5000);
    }


    @AfterTest
    void finish() {
        driver.quit();
    }

}
