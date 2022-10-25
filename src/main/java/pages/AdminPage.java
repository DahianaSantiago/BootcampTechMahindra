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

    @FindBy(css = "div[class$='oxd-input-field-bottom-space']>div>input")
    public WebElement usernameField;



    @FindBy(xpath = "//button[text()=' Search ']")
    public WebElement searchButton;
    @FindBy(xpath = "//div[text()='Alice.Duval']")
    public WebElement nameValidation;
    //Add new admin
    @FindBy(xpath = "//button[text()=' Add ']")
    public WebElement add;
    @FindBy(css = "input[type='password']")
    public List<WebElement> password;
    @FindBy(css = "div.oxd-select-text--after")
    public List<WebElement> categories;
    @FindBy(css = "div.oxd-select-option")
    public List<WebElement> optionsRole;
    @FindBy(css = "div.oxd-select-option")
    public List<WebElement> optionsStatus;

    By employeeName = By.cssSelector("div[class^='oxd-autocomplete-text-input'] > input");
    By userName = By.cssSelector("div[class$='oxd-input-field-bottom-space'] > div>input");
    By selectName = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div/span");


    //Whit Role
    By role = By.xpath("(//div[text()='-- Select --'])[1]");
    By ESSSelect = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div[3]");
    By roleValidation = By.xpath("(//div[text()='ESS'])[2]");

    //Whit Job
    @FindBy(xpath = "//span[text()='Job ']")
    public WebElement job;
    @FindBy(xpath = "//a[text()='Job Titles']")
    public WebElement jobTitles;
    @FindBy(xpath = "//button[text()=' Save ']")
    public WebElement buttonSave;

    By editJob = By.xpath("(//button[@class='oxd-icon-button oxd-table-cell-action-space'])[2]");
    By inputNewjob = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/input");
    By validationMessage = By.xpath("/html/body/div/div[2]/div");

    //Delete user and admin
    @FindBy(xpath = "//button[text()=' Yes, Delete ']")
    public WebElement yesDelete;
    By deleteUser = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[4]/div/div[6]/div/button[1]");
    By deleteAdmin = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[6]/div/button[1]");

    // By errorMessage = By.xpath("/html/body/div/div[2]/div");

    public void editJob() throws InterruptedException {
        job.click();
        WaitUntilElementVisible(jobTitles);
        jobTitles.click();
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
