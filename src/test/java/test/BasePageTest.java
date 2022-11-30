package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;

import java.time.Duration;



public class BasePageTest {

    protected static WebDriver driver;
    private static final String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions
                .addArguments("--start-maximized")
                .addArguments("--no-sandbox")
                .addArguments("--disable-download-notification")
                .addArguments("disable-gpu")
                .addArguments("--ignore-certificate-error")
                .addArguments("--always-authorize-plugins")
                .addArguments("--disable-infobars")
                //.addArguments("--window-size=1920,1080")
                .addArguments("--disable-popup-blocking");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(url);

    }

    @AfterMethod
    public void closeBrowser() {
        driver.close();
    }

    public void logIn(String user, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login(user, password);
    }

    public void logInAdmin(String user, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAdmin(user, password);
    }

    public void logInReport(String user, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginReport(user, password);
    }
}
