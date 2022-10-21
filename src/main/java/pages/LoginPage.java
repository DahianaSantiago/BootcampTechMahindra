package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private WebDriver driver;

    By userName = By.name(("username"));
    By password = By.name("password");
    By loginButton = By.xpath("//button[@type='submit']");
    By loginSuccessful = By.className("oxd-userdropdown-name");
    By loginUnsuccessful = By.cssSelector("div[class^='oxd-alert-content']>p");
    By requiredField = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/span");
    By logout = By.xpath("(//a[@class='oxd-userdropdown-link'])[4]");

    By logoutSuccessful = By.className("oxd-text oxd-text--h5 orangehrm-login-title");
    By incomeReports = By.xpath("//a[text()='Reports']");
    By adminButton = By.xpath("//span[text()='Admin']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void Login(String user, String psw) throws InterruptedException {
        Thread.sleep(3000);
        type(user, userName);
        type(psw, password);
        click(loginButton);
    }

    public Boolean loginSuccessful() {
        return isDisplayed(loginSuccessful);
    }

    public Boolean logoutSuccessful() {
        return isDisplayed(userName);
    }

    public String loginNotSuccessful() {
        return getText(loginUnsuccessful);
    }

    public String withoutCredentials() {
        return getText(requiredField);
    }

    public void Logout() throws InterruptedException {
        Thread.sleep(1000);
        click(loginSuccessful);
        click(logout);
    }

    public void IncomeReport() throws InterruptedException {
        click(incomeReports);
        Thread.sleep(1000);
    }

    public void admin() {
        click(adminButton);
    }
}
