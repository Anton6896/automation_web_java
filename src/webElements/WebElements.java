package webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class WebElements {

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

//        text input
        driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
        driver.findElement(By.id("user-message")).sendKeys("testing");
        driver.findElement(By.cssSelector("button.btn:nth-child(2)")).click();
        String txt1 = driver.findElement(By.id("display")).getText();
        if (txt1.equals("testing")) {
            System.out.println("test 1 ok");
        }

//        check box
        driver.findElement(By.cssSelector("ul.nav:nth-child(1) > li:nth-child(1) > a:nth-child(1)")).click();
        driver.findElement(By.cssSelector(".open > ul:nth-child(2) > li:nth-child(2) > a:nth-child(1)")).click();
        driver.findElement(By.id("isAgeSelected")).click();
        String txt2 = driver.findElement(By.id("txtAge")).getText();
        if (txt2.split(" ")[0].equals("Success")) {
            System.out.println("test 2 ok");
        }


        driver.close();

    }


}
