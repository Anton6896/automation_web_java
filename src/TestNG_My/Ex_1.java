package TestNG_My;

import DriverProperties.DriverData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ex_1 {
    WebDriver driver = new DriverData("chrome").getDriver();
    String webPage = "https://www.seleniumeasy.com/test/ajax-form-submit-demo.html";

    @Test
    void ajaxForm() {
        driver.get(webPage);

        driver.findElement(By.id("title")).sendKeys("nametext");
        driver.findElement(By.id("description")).sendKeys("mainText");
        driver.findElement(By.id("btn-submit")).click();

        // see if ajax request is starting
        String control = driver.findElement(By.id("submit-control")).getText();
        Assert.assertEquals("Ajax Request is Processing!", control);

        driver.quit();
    }
}
