package webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class WebElements {

    static String driverPath = "drivers_for_selenium" + File.separator +
            "chromedriver_win32" + File.separator +
            "chromedriver.exe";
    static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();

//        text input
        driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
        driver.findElement(By.id("user-message")).sendKeys("testing");
        driver.findElement(By.cssSelector("button.btn:nth-child(2)")).click();
        String txt1 = driver.findElement(By.id("display")).getText();
        System.out.println("text is : " + txt1);

//        check box
        driver.findElement(By.cssSelector("ul.nav:nth-child(1) > li:nth-child(1) > a:nth-child(1)")).click();
        driver.findElement(By.cssSelector(".open > ul:nth-child(2) > li:nth-child(2) > a:nth-child(1)")).click();
        driver.findElement(By.id("isAgeSelected")).click();
        String txt2 = driver.findElement(By.id("txtAge")).getText();
        System.out.println(txt2);



        driver.close();
    }
}
