package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public static WebDriver driver;


    public static WebDriver driverInit()
    {
        System.out.println("initializing the driver");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        return driver;
    }

    public static void urlNavigation(String url){
        driver.navigate().to(url);
    }

    public static void closeDriver()
    {

        driver.quit();
    }
}
