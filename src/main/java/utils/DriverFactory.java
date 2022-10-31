package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverFactory {
    static WebDriver driver;
    public WebDriverWait wait;

    public static WebDriver managerDriver(){
        WebDriverWait wait;
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
       // wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        return driver;
    }

    public static WebDriver getDriver(){
        return driver;
    }

}

