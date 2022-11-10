package utils;


import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



import java.time.Duration;

public class DriverFactory {


    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }


   /* static WebDriver driver;
    public WebDriverWait wait;


   @Before
    public void setUp() throws Exception {

      // WebDriverManager.chromedriver().setup();
       ChromeOptions chromeOptions = new ChromeOptions();
       chromeOptions.addArguments("--headless")
               .addArguments("--ignore-certificate-error")
               .addArguments("--always-authorize-plugins")
               .addArguments("--disable-extensions")
               .addArguments("--window-size=1920,1080")
               .addArguments("--disable-popup-blocking");

       driver = new ChromeDriver(chromeOptions);
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage = new LoginPage(driver);
        driver = loginPage.chromeDriverConnection();
        loginPage.visit("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
    }

    public static WebDriver managerDriver(){
        WebDriverWait wait;
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
       // wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        return driver;
    }

    public static WebDriver getDriver(){
        return driver;
    }*/

}

