package TestNG_My;

import DriverProperties.DriverData;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserScript {
    /**
     * this class will execute before ech test in testing.xml
     */
    WebDriver driver;
    String simpleForm = "https://www.seleniumeasy.com/test/basic-first-form-demo.html";


    @BeforeTest
    @Parameters({"browser", "text"})
    void setup(String browser, String text) {
        // use Parameters in xml file
        System.out.println(text);
        driver = new DriverData(browser).getDriver();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1000, 1200));
    }

    @Test
    void simpleFormFilling() {
        /*
         * will be tested in couple browsers with an xml config
         */
        driver.navigate().to(simpleForm);
        driver.findElement(By.id("user-message")).sendKeys("Test");
        driver.findElement(By.cssSelector("button.btn:nth-child(2)")).click();
        Assert.assertEquals(
                driver.findElement(By.id("display")).getText(),
                "Test"
        );
    }

    @Test
    void twoInputs() {
        driver.findElement(By.id("sum1")).sendKeys("1");
        driver.findElement(By.id("sum2")).sendKeys("2");
        driver.findElement(By.cssSelector("button.btn:nth-child(3)")).click();

        Assert.assertEquals(
                "3",
                driver.findElement(By.id("displayvalue")).getText()
        );
    }


    @AfterTest
    void finish() {
        driver.quit();
    }
}
