package Grid_t;

import DriverProperties.DriverData;
import org.openqa.selenium.*;
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
 * by creating grid you can control couple machines by user -> host
 * <p>
 * creating server selenium (by ip)
 * >>> java -jar .\selenium-server-standalone-3.141.59.jar -role hub
 * <p>
 * creating hosts (by ip)  (in win must use "" for arguments)
 * >>> java "-Dwebdriver.chrome.driverD:\Documen
 * ts\dev\selenium_full_course\drivers_for_selenium\chromedriver_win32\chromedriver.exe" -jar ".\selenium-server-standalone-3.141.59.jar"
 * -role node -hub "http://192.168.232.1:4444/grid/register/"
 * <p>
 * testing grid
 */

public class Ex_1 {

//    from http://localhost:4545/wb/hub to http://localhost:4545/wd/hub


    public static void main(String[] args) throws MalformedURLException {
        String checkBox = "https://www.seleniumeasy.com/test/basic-checkbox-demo.html";
        String nodeUrl = "http://192.168.232.1:4444/wd/hub";


        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setBrowserName("chrome");
        cap.setPlatform(Platform.WIN10);

        WebDriver driver = new RemoteWebDriver(new URL(nodeUrl), cap);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1000, 1200));


        driver.get(checkBox);
        driver.findElement(By.id("isAgeSelected")).click();
        String txt = driver.findElement(By.id("txtAge")).getText().toLowerCase();
        Assert.assertTrue(txt.contains("success"));


        driver.quit();
    }
}
