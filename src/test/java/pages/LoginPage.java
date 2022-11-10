package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    private WebDriver driver;

    @FindBy(name = "username")
    public WebElement userName;
    @FindBy(name = "password")
    public WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;
    @FindBy(className = "oxd-userdropdown-name")
    public WebElement loginSuccessful;
    @FindBy(css = "div[class^='oxd-alert-content']>p")
    public WebElement loginUnsuccessful;
    @FindBy(xpath = "(//span[text()='Required'])[1]")
    public WebElement requiredField;
    @FindBy(xpath = "(//a[@class='oxd-userdropdown-link'])[4]")
    public WebElement logout;
    @FindBy(xpath = "//a[text()='Reports']")
    public WebElement incomeReports;
    @FindBy(xpath = "//span[text()='Admin']")
    public WebElement adminButton;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void Login(String user, String psw)  {
        WaitUntilElementVisible(userName);
        userName.sendKeys(user);
        password.sendKeys(psw);
        loginButton.click();

    }

    public Boolean loginSuccessfulVerify() {
        return isDisplayed(loginSuccessful);
    }

    public Boolean logoutSuccessful() {
        return isDisplayed(userName);
    }

    public String loginNotSuccessful() {
        return loginUnsuccessful.getText();
    }

    public String withoutCredentials() {
        return requiredField.getText();
    }

    public void Logout() {
        WaitUntilElementVisible(loginSuccessful);
        loginSuccessful.click();
        logout.click();
    }

    public void incomeReport() throws InterruptedException {
        incomeReports.click();
        Thread.sleep(1000);
    }

    public void admin() {
        adminButton.click();
    }
}
