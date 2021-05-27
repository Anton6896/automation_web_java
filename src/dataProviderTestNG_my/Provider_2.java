package dataProviderTestNG_my;

import DriverProperties.DriverData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Provider_2 {

    String path = "https://www.seleniumeasy.com/test/basic-first-form-demo.html";
    WebDriver driver;

    @Test(dataProvider = "getData")
    void checkData(String text, String tes) throws InterruptedException {
        System.out.println(tes);
        driver = new DriverData("firefox").getDriver();
        driver.get(path);
        driver.findElement(By.id("user-message")).sendKeys(text);
        driver.findElement(By.cssSelector("button.btn:nth-child(2)")).click();
        String output = driver.findElement(By.id("display")).getText();
        Assert.assertEquals(output, text);
        driver.quit();
        Thread.sleep(2000);
    }

    @DataProvider
    Object[][] getData() {
        // can have data from excel of some other source
        Object[][] data = new Object[3][2];
        data[0][0] = "text_1";
        data[0][1] = "text_1";
        data[1][0] = "text_2";
        data[1][1] = "text_2";
        data[2][0] = "text_3";
        data[2][1] = "text_3";
        return data;
    }
}
