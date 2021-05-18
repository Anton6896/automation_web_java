package RobotsMy;

import DriverProperties.DriverData;
import org.openqa.selenium.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.InputEvent;

public class Rob1 {
    /**
     * control over mouse and keyboard
     */

    WebDriver driver = null;
    String page = "https://www.seleniumeasy.com/test/drag-and-drop-demo.html";

    @BeforeTest
    void before() {
        driver = new DriverData("firefox").getDriver();
        driver.manage().window().maximize();
    }


    @Test
    void rob_1() throws AWTException {
        driver.get(page);
        Robot robot = new Robot();
        robot.mouseMove(847, 439);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseMove(1263, 451);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @AfterTest
    void finish() {
        if (driver != null) {
            driver.quit();
        }

    }


}
