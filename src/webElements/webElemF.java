package webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class webElemF {

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


    public static void main(String[] args) throws InterruptedException {
        mySys();
        System.setProperty("webdriver.gecko.driver", driverPath);
        WebDriver driver = new FirefoxDriver();

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
        driver.findElement(By.id("user-message")).sendKeys("testing");
        driver.findElement(By.cssSelector("button.btn:nth-child(2)")).click();
        String txt1 = driver.findElement(By.id("display")).getText();
        if (txt1.equals("testing")) {
            System.out.println("test 1 ok");
        }

        driver.close();
    }
}