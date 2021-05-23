package Grid_my.parallel;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
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
 * using machine with chrome driver
 * <p>
 * assuming that this is an individual machine some where ! not in this system
 * <p>
 * >>> java -Dwebdriver.chrome.driver=/home/ant/Documents/testing_all/grid_elenium/drivers_for_selenium/ubuntu_drivers/chromedriver -jar /home/ant/Documents/testing_all/grid_elenium/drivers_for_selenium/selenium-server-standalone-3.141.59.jar -role node -hub http://192.168.232.131:4444/grid/register/
 */

public class T_01 {

    WebDriver driver;
    String hub = "http://192.168.232.131:4444/wd/hub";

    @BeforeTest
    void before() throws MalformedURLException {
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new RemoteWebDriver(new URL(hub), chromeOptions);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1000, 1200));
    }

    @Test
    void t_1() {
        driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
        driver.findElement(By.id("user-message")).sendKeys("msg");
        driver.findElement(By.cssSelector("button.btn:nth-child(2)")).click();
        String txt = driver.findElement(By.id("display")).getText().toLowerCase();
        Assert.assertTrue(txt.contains("msg"));
    }


    @AfterTest
    void finish() {
        driver.quit();
    }
}
