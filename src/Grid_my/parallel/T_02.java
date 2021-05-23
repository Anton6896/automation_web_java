package Grid_my.parallel;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * using machine with firefox driver
 * <p>
 * assuming that this is an individual machine some where ! not in this system
 * <p>
 * >>> java -Dwebdriver.gecko.driver=/home/ant/Documents/testing_all/grid_elenium/drivers_for_selenium/ubuntu_drivers/geckodriver -jar /home/ant/Documents/testing_all/grid_elenium/drivers_for_selenium/selenium-server-standalone-3.141.59.jar -role node -hub http://192.168.232.131:4444/grid/register/
 */

public class T_02 {

    WebDriver driver;
    String hub = "http://192.168.232.131:4444/wd/hub";

    @BeforeTest
    void before() throws MalformedURLException {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        driver = new RemoteWebDriver(new URL(hub), firefoxOptions);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1000, 1200));
    }

    @Test
    void t_2() {
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
