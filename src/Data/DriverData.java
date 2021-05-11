package Data;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Load driver and all config for it
 *
 * on class creation specify in constructor browser to use ( firefox / chrome )
 */
public class DriverData {
    private static String OS = null;
    private static String driverPath;
    private WebDriver driver = null;

    private void mySys(String browser) {
        String chrome = "chromedriver_win32" + File.separator + "chromedriver.exe";
        String fireFox = "geckodriver-v0.29.1-win64" + File.separator + "geckodriver.exe";

        if (OS == null) {
            OS = System.getProperty("os.name");
        }

        if ("Windows 10".equals(OS)) {
            if (browser.equals("chrome")) {
                driverPath = "drivers_for_selenium" + File.separator + chrome;
                System.setProperty("webdriver.chrome.driver", driverPath);
                driver = new ChromeDriver();

            } else if (browser.equals("firefox")) {
                driverPath = "drivers_for_selenium" + File.separator + fireFox;
                System.setProperty("webdriver.gecko.driver", driverPath);
                driver = new FirefoxDriver();

            } else {
                System.out.println("you entered wrong data to DriverData class");
            }
        }

    }

    public DriverData(String browser) {

        mySys(browser);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public WebDriver getDriver() {
        return driver;
    }


}
