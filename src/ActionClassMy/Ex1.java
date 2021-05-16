package ActionClassMy;

import DriverProperties.DriverData;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Ex1 {
    WebDriver driver = null;
    String dragAndDrop = "https://www.seleniumeasy.com/test/drag-and-drop-demo.html";

    @BeforeTest
    void before() {
        driver = new DriverData("chrome").getDriver();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1000, 1200));
    }

    @Test
    void dropDemo() {
        driver.navigate().to(dragAndDrop);

        // find element to drag
        WebElement elemToDrag = driver.findElement(By.cssSelector("#todrag > span:nth-child(2)"));
        WebElement dropZone = driver.findElement(By.cssSelector("#mydropzone"));

        // drag and drop // position 409, 64
        Actions action = new Actions(driver);
        action.dragAndDrop(elemToDrag, dropZone).build().perform(); // not working here !!!!

        // find after drag
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("droppedlist")));
        List<WebElement> list = driver.findElement(By.id("droppedlist")).findElements(By.tagName("span"));
        WebElement dr1 = list.stream()
                .filter(dr -> "Draggable 1".equals(dr.getText()))
                .findAny()
                .orElse(null);

        // check
        Assert.assertNotNull(dr1);
    }

    @Test
    void drop2Guru() {
        driver.get("http://demo.guru99.com/test/drag_drop.html");

        //Element which needs to drag.
        WebElement From = driver.findElement(By.id("credit2"));
        WebElement fourth = driver.findElement(By.id("fourth"));


        //Element on which need to drop.
        WebElement To = driver.findElement(By.id("bank"));
        WebElement amt7 = driver.findElement(By.id("amt7"));

        //Using Action class for drag and drop.
        Actions act = new Actions(driver);

        //Dragged and dropped.
        act.dragAndDrop(From, To).build().perform();
        act.dragAndDrop(fourth, amt7).build().perform();

        Assert.assertEquals(
                driver.findElement(By.id("t7")).getText(),
                "5000"
        );
    }

    @Test
    void droppableJquery() {
        driver.navigate().to("https://jqueryui.com/droppable/#content");

        // eky fo find elements is to switch to the frame ! that elements exists in
        driver.switchTo().frame(0);

        WebElement dragMe = driver.findElement(By.id("draggable"));
        WebElement dropTo = driver.findElement(By.id("droppable"));

//        Actions builder = new Actions(driver);
//        builder.dragAndDrop(dragMe, dropTo).build().perform();

        Actions builder = new Actions(driver);
        Action seriesOfActions;
        seriesOfActions = builder
                .moveToElement(dragMe)
                .clickAndHold()
                .moveToElement(dropTo)
                .release()
                .build();
        seriesOfActions.perform();

        String dropped = driver.findElement(By.id("droppable")).getText();

        Assert.assertEquals(
                "Dropped!",
                dropped
        );


    }

    @AfterTest
    void finish() {
        if (driver != null) {
            driver.quit();
        }
    }
}
