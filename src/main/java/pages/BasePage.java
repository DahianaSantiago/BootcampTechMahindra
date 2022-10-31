package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {

    static WebDriver driver;
    private static WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebDriver chromeDriverConnection() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }

    public static WebDriver getDriver(){
        return driver;
    }

    protected void WaitUntilElementVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.isDisplayed();
    }

    public Boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    protected boolean isVisible(WebElement webElement) {
        try {
            return webElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void visit(String url) {
        driver.get(url);
    }


}
