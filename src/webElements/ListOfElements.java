package webElements;

import DriverProperties.DriverData;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.util.List;

public class ListOfElements {
    WebDriver driver;
    String listPage = "https://www.seleniumeasy.com/test/bootstrap-dual-list-box-demo.html";

    @BeforeTest
    void before() {
        driver = new DriverData("firefox").getDriver();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1000, 1200));
    }

    @Test
    void ulToList() {
        driver.navigate().to(listPage);
        // get data to list fro ul
        WebElement element = driver.findElement(By.cssSelector(".text-right > ul:nth-child(2)"));
        List<WebElement> list = element.findElements(By.tagName("li"));

        // look for element "Porta ac consectetur ac"
        WebElement porta = list.stream()
                .filter(elem -> "Porta ac consectetur ac".equals(elem.getText()))
                .findAny()
                .orElse(null);

        Assert.assertNotNull(porta);
    }

    @AfterTest
    void finish() {
        driver.quit();
    }
}
