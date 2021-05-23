package Grid_my;

import DriverProperties.DriverData;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.DuplicateFormatFlagsException;
import java.util.concurrent.TimeUnit;

/**
 * by creating grid you can control couple machines by user -> host
 * max capable connection is 5  (i tried on windows ! don't do that on windows ! )
 *
 * <p>
 * creating server selenium (by ip)
 * >>> java -jar /home/ant/Documents/testing_all/grid_elenium/drivers_for_selenium/selenium-server-standalone-3.141.59.jar -role hub
 * <p>
 * create node that will be connected to server
 * >>> java -Dwebdriver.chrome.driver=/home/ant/Documents/testing_all/grid_elenium/drivers_for_selenium/ubuntu_drivers/chromedriver -jar /home/ant/Documents/testing_all/grid_elenium/drivers_for_selenium/selenium-server-standalone-3.141.59.jar -role node -hub http://192.168.232.131:4444/wd/hub
 * <p>
 * testing grid
 */

public class Grid_1 {
    static WebDriver driver;
    static String hub = " http://192.168.232.131:4444/wd/hub";

    @BeforeTest
    void before() throws MalformedURLException {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.LINUX);

//        driver = new DriverData("chrome").getDriver();
        driver = new RemoteWebDriver(new URL(hub), capabilities);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1000, 1200));
    }

    // look in drop down menu
    @Test
    void t_1() {
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        driver.findElement(By.id("isAgeSelected")).click();
        String txt = driver.findElement(By.id("txtAge")).getText().toLowerCase();
        Assert.assertTrue(txt.contains("success"));
    }


    @AfterTest
    void finish() {
        driver.quit();
    }


}
