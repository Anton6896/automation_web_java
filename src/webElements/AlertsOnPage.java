package webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AlertsOnPage {

    static String driverPath = null;
    static WebDriver driver;
    private static String OS = null;

    static void mySys() {
        if (OS == null) {
            OS = System.getProperty("os.name");
        }

        if ("Windows 10".equals(OS)) {
            driverPath = "drivers_for_selenium" + File.separator +
                    "chromedriver_win32" + File.separator +
                    "chromedriver.exe";
        }

    }

    public static void main(String[] args) {

        mySys();
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        drop(driver);

    }

    static void drop(WebDriver driver) {
        driver.get("https://www.seleniumeasy.com/test/input-form-demo.html");
        WebElement drop = driver.findElement(By.name("state"));
        // select Iowa from drop down
        Select select = new Select(drop);

//        select.selectByVisibleText("Iowa"); // select element on web from drop
//        Thread.sleep(1000);
        List<WebElement> allOptions = select.getOptions();

        // straight forward
        for (WebElement el : allOptions) {
            if (el.getText().equals("Iowa")) {
                System.out.println("Iowa is in");
            }
        }

        // faster way
        allOptions.stream().filter(
                opt -> "Iowa".equals(opt.getText())
        ).findAny().ifPresent(iowa -> System.out.println("working ok"));

        driver.close();
    }


}
