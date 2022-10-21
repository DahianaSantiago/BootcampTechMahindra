package pages;

import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static utils.Constants.*;

public class AdminPage extends BasePage {

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    private WebDriver driver;

    By usernameField = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    By searchButton = By.xpath("//button[text()=' Search ']");
    By nameValidation = By.xpath("//div[text()='Alice.Duval']");

    //Add new admin
    By add = By.xpath("//button[text()=' Add ']");
    By employeeName = By.cssSelector("div[class^='oxd-autocomplete-text-input'] > input");
    By userName = By.cssSelector("div[class$='oxd-input-field-bottom-space'] > div>input");
    By password = By.xpath("(//input[@type='password'])[1]");
    By confirmPassword = By.xpath("(//input[@type='password'])[2]");
    By selectName = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div/span");
    @FindBy(css = "div.oxd-select-text--after")
    public List<WebElement> categories;
    @FindBy(css = "div.oxd-select-option")
    public List<WebElement> optionsRole;
    @FindBy(css = "div.oxd-select-option")
    public List<WebElement> optionsStatus;
    //Whit Role
    By role = By.xpath("(//div[text()='-- Select --'])[1]");
    By ESSSelect = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div[3]");
    By roleValidation = By.xpath("(//div[text()='ESS'])[2]");

    //Whit Job

    By job = By.xpath("//span[text()='Job ']");

    By jobTitles = By.xpath("//a[text()='Job Titles']");
    By editJob = By.xpath("(//button[@class='oxd-icon-button oxd-table-cell-action-space'])[2]");
    By inputNewjob = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/input");
    By buttonSave = By.xpath("//button[text()=' Save ']");
    By validationMessage = By.xpath("/html/body/div/div[2]/div");

    // delete user and admin
    By deleteUser = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[4]/div/div[6]/div/button[1]");
    By deleteAdmin = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[6]/div/button[1]");
    By yesDelete = By.xpath("//button[text()=' Yes, Delete ']");
    // By errorMessage = By.xpath("/html/body/div/div[2]/div");

    public void editJob() throws InterruptedException {
        click(job);
        Thread.sleep(1000);
        click(jobTitles);
        Thread.sleep(1000);
        click(editJob);
        Thread.sleep(1000);
        type(" and Test automator", inputNewjob);
        click(buttonSave);
        Thread.sleep(1000);
    }

    public void searchUserWithUserName() throws InterruptedException {
        type("Alice.Duval", usernameField);
        click(searchButton);
        Thread.sleep(2000);
    }

    public void searchUserWithRole() throws InterruptedException {
        click(role);
        click(ESSSelect);
        click(searchButton);
        Thread.sleep(2000);
    }

    public void addAdmin() throws InterruptedException {
        Thread.sleep(1000);
        click(add);
        categories.get(0).click();
        optionsRole.get(1).click();
        categories.get(1).click();
        optionsStatus.get(1).click();
        type(NAME, employeeName);
        Thread.sleep(2000);
        click(selectName);
        int random = (int) Math.rint(Math.random() * 10);
        type(USERNAME + random, userName);
        Thread.sleep(3000);
        type(PASSWORD, password);
        type(PASSWORD, confirmPassword);
        click(buttonSave);
        Thread.sleep(2000);
    }

    public void deleteUser() throws InterruptedException {
        Thread.sleep(1000);
        click(deleteUser);
        click(yesDelete);
        Thread.sleep(2000);
    }

    public void deleteAdmin() throws InterruptedException {
        categories.get(0).click();
        optionsRole.get(1).click();
        Thread.sleep(1000);
        click(searchButton);
        Thread.sleep(1000);
        click(deleteAdmin);
    }

    public String validationName() {
        return getText(nameValidation);
    }

    public String roleValidation() {
        return getText(roleValidation);
    }

    public Boolean validationMessage() {
        return isDisplayed(validationMessage);
    }

}
