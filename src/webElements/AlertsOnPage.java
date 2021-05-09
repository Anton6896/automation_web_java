package webElements;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class AlertsOnPage {
    public static void main(String[] args) {

        DriverData dd = new DriverData();
        WebDriver driver = dd.getDriver();

//        drop(driver);
        alertCheck(driver);


    }

    /**
     * select data from drop down menu (countries ...)
     *
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
     *
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
