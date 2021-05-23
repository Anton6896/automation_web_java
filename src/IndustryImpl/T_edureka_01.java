package IndustryImpl;

import DriverProperties.DriverData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

/**
 * user registered at https://www.edureka.co/ wants to update all detail available in the portal
 * write selenium script to do same and explore the portal at eduraka
 * <p>
 * steps :
 * 1. login
 * 2. nav to my profile
 * 3. update personal details, career interests
 * 4. logout
 */


public class T_edureka_01 {

    WebDriver driver;

    @BeforeTest
    void pre_test() {
        driver = new DriverData("chrome").getDriver();
    }

    @Test(priority = 1)
    void t_logIn() throws InterruptedException {
        driver.get("https://www.edureka.co/");

        // log in
        driver.findElement(By.cssSelector("li.hidden-xs:nth-child(4) > a:nth-child(1)")).click();
        driver.findElement(By.id("si_popup_email")).sendKeys("anton-r@live.com");
        driver.findElement(By.id("si_popup_passwd")).sendKeys("6896180An!");
        driver.findElement(By.cssSelector("button.clik_btn_log:nth-child(4)")).click();

        // goto my profile
        driver.findElement(By.cssSelector(".webinar-profile-name")).click();
        driver.findElement(By.linkText("My Profile")).click();

        // update personal data
        driver.findElement(By.linkText("Topics of Interest")).click();
        driver.findElement(By.cssSelector("button.btn:nth-child(3)")).click();
        WebElement categories = driver.findElement(By.cssSelector(".categories-section"));
        List<WebElement> list_of_categories = categories.findElements(By.className("category-item"));
        for (WebElement category : list_of_categories) {
            if (category.getText().equals("Big Data")) {
                category.click();
            } else if (category.getText().equals("Software Testing")) {
                category.click();
            }
        }
        driver.findElement(By.cssSelector(".btn")).click();
        Thread.sleep(1000); // slow down operations

        // logout
        driver.findElement(By.cssSelector(".user_name")).click();
        driver.findElement(By.linkText("Log Out")).click();
    }


    @AfterTest
    void finish() {
        driver.quit();
    }
}
