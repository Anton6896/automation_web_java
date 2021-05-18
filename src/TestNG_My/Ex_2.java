package TestNG_My;

import DriverProperties.DriverData;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;


/**
 * TestNG annotation helps to provide control for all tests flow
 */

public class Ex_2 {

    static int counter = 0;
    WebDriver driver = null;
    String ajax_form = "https://www.seleniumeasy.com/test/ajax-form-submit-demo.html";
    String single_select = "https://www.seleniumeasy.com/test/jquery-dropdown-search-demo.html";

    @BeforeSuite
    void suiteName() {
        System.out.println("running before group off all tests in same category ");
    }

    @BeforeTest
    void driverCreation() {
        /*
         * wil run before first test
         */
        System.out.println("i will prepare all config for testing");
        driver = new DriverData("chrome").getDriver();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1000, 1200));
    }

    @BeforeMethod
    void method_counter() {
        System.out.println(++counter + " :: iam running before ech method");
    }


    @Test(priority = 1)
    void verifyAjax() {
        // make test
        driver.navigate().to(ajax_form);
        driver.findElement(By.id("title")).sendKeys("nameText");
        driver.findElement(By.id("description")).sendKeys("mainText");
        driver.findElement(By.id("btn-submit")).click();

        // see if ajax request is starting
        String control = driver.findElement(By.id("submit-control")).getText();
        Assert.assertEquals("Ajax Request is Processing!", control);
    }

    @Test()
    void single_selection() {
        driver.navigate().to(single_select);
        // select India from dropdown
        Select select = new Select(driver.findElement(By.id("country")));
        select.selectByVisibleText("India");

        // get all option
//        List<WebElement> list = select.getOptions();
//        WebElement india = list.stream().filter(elem -> "India".equals(elem.getText())).findAny().orElse(null);


        // check selection
        String india = driver.findElement(By.id("select2-country-container")).getText();
        Assert.assertEquals(india, "India");
    }

    @AfterTest
    void afterTest() {
        // exit all
        System.out.println("after all i will start my job");
        driver.quit();
    }
}
