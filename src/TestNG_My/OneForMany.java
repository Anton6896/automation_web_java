package TestNG_My;

import DriverProperties.DriverData;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OneForMany {
    /**
     * check this test in couple browser
     * in my case will use chrome and firefox
     */
    WebDriver driver = null;
    String simpleForm = "https://www.seleniumeasy.com/test/basic-first-form-demo.html";

    @BeforeTest
    void config() {
        driver = new DriverData("chrome").getDriver();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1000, 1200));
    }

    @Test
    void SimpleFormFilling() {
        driver.navigate().to(simpleForm);
        driver.findElement(By.id("user-message")).sendKeys("Test");
        driver.findElement(By.cssSelector("button.btn:nth-child(2)")).click();
        Assert.assertEquals(
                driver.findElement(By.id("display")).getText(),
                "Test"
        );
    }

    @AfterTest
    void finish() {
        driver.quit();
    }
}
