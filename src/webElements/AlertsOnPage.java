package webElements;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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


//        drop(driver);
        alertCheck(driver);


    }

    /**
     * select data from drop down menu (countries ...)
     * @param driver WebDriver obj
     */
    static void drop(WebDriver driver) {
        driver.get("https://www.seleniumeasy.com/test/input-form-demo.html");
        WebElement drop = driver.findElement(By.name("state"));
        // select Iowa from drop down
        Select select = new Select(drop);

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

    /**
     * over to js alerts
     * accept or decline and send text to it
     * @param driver WebDriver obj
     */
    static void alertCheck(WebDriver driver) {
        driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");

        // the alert box with prompt
        driver.findElement(By.cssSelector("div.panel:nth-child(4) > div:nth-child(2) > button:nth-child(4)")).click();
        Alert alert = driver.switchTo().alert();
        String alertMess = alert.getText();
        System.out.println("mess from alert : " + alertMess);
        alert.accept();

        // accept or dismiss
        driver.findElement(By.cssSelector("div.panel:nth-child(5) > div:nth-child(2) > button:nth-child(4)")).click();
        Alert alert1 = driver.switchTo().alert();
        alert.dismiss();
        String mess = driver.findElement(By.id("confirm-demo")).getText();
        System.out.println("second box after dismiss : " + mess);

        // enter text to alert box
        driver.findElement(By.cssSelector("div.panel:nth-child(6) > div:nth-child(2) > button:nth-child(4)")).click();
        Alert alert2 = driver.switchTo().alert();
        alert.sendKeys("super");
        alert.accept();
        // return :: You have entered 'super' !  (use regex to look for the word)
        String mess2 = driver.findElement(By.id("prompt-demo")).getText();
        if (mess2.matches(".*\\bsuper\\b.*")) {
            System.out.println("super");
        }

        driver.close();
    }

}
