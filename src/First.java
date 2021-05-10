import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class First {

    public static WebDriver driver = null;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "drivers_for_selenium" + File.separator +
                        "chromedriver_win32" + File.separator +
                        "chromedriver.exe");

        itsWorking();

    }

    static void itsWorking() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        // open web
        driver.navigate().to("https://www.seleniumeasy.com/test/");

        String title = driver.getTitle();
        System.out.println("title : " + title);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }


}