package ActionClassMy;

import DriverProperties.DriverData;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Ex1 {
    WebDriver driver;
    String dragAndDrop = "https://www.seleniumeasy.com/test/drag-and-drop-demo.html";

    @BeforeTest
    void before() {
        driver = new DriverData("firefox").getDriver();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1000, 1200));
    }

    @Test
    void drop1() {
        driver.navigate().to(dragAndDrop);

        // find element to drag
        List<WebElement> listToDrag = driver.findElement(By.id("todrag")).findElements(By.tagName("span"));
        WebElement elemToDrag = listToDrag.get(0);
        WebElement dropZone = driver.findElement(By.id("mydropzone"));

        // drag and drop
        Actions builder = new Actions(driver);
        builder.dragAndDrop(elemToDrag, dropZone);

        // find after drag
        List<WebElement> list = driver.findElement(By.id("droppedlist")).findElements(By.tagName("span"));
        WebElement dr1 = list.stream()
                .filter(dr -> "Draggable 1".equals(dr.getText()))
                .findAny()
                .orElse(null);

        // check
        Assert.assertNotNull(dr1);
    }

    @AfterTest
    void finish() {
        driver.quit();
    }
}
