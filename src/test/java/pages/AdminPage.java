package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

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
    @FindBy(css = "input[placeholder='Type for hints...']")
    public WebElement employeeName;
    @FindBy(css = "div[class$='oxd-input-field-bottom-space'] > div>input")
    public WebElement userName;
    @FindBy(css = "div[class='oxd-autocomplete-option']")
    public WebElement selectName;
    //Whit Role
    @FindBy(xpath = "(//div[text()='-- Select --'])[1]")
    public WebElement role;
    @FindBy(xpath = "//span[text()='ESS']")
    public WebElement ESSSelect;
    @FindBy(xpath = "(//div[text()='ESS'])[2]")
    public WebElement roleValidation;

    //Whit Job
    @FindBy(xpath = "//span[text()='Job ']")
    public WebElement job;
    @FindBy(xpath = "//a[text()='Job Titles']")
    public WebElement jobTitles;
    @FindBy(xpath = "//button[text()=' Save ']")
    public WebElement buttonSave;
    @FindBy(xpath = "(//button[@class='oxd-icon-button oxd-table-cell-action-space'])[2]")
    public WebElement editJob;
    @FindBy(css = "div[class$='oxd-input-group oxd-input-field-bottom-space']>div>input")
    public WebElement inputNewjob;
    @FindBy(xpath = "/html/body/div/div[2]/div")
    public WebElement validationMessage;

    //Delete user and admin
    @FindBy(xpath = "//button[text()=' Yes, Delete ']")
    public WebElement yesDelete;
    @FindBy(css = "button[class='oxd-icon-button oxd-table-cell-action-space']:nth-child(1)")
    public WebElement deleteUser;
    @FindBy(css = "button[class$='oxd-icon-button oxd-table-cell-action-space']:nth-child(1)")
    public WebElement deleteAdmin;


    public void editJob() {
        job.click();
        jobTitles.click();
        WaitUntilElementVisible(editJob);
       // BasePage.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        editJob.click();
        inputNewjob.sendKeys(" and Test automator");
        buttonSave.click();
    }

    public void searchUserWithUserName() {
        WaitUntilElementVisible(usernameField);
        //BasePage.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        usernameField.sendKeys("Alice.Duval");
        searchButton.click();
    }

    public void searchUserWithRole() {
        WaitUntilElementVisible(role);
        //BasePage.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        role.click();
        ESSSelect.click();
        searchButton.click();
    }


    public void addAdmin() {
        //BasePage.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        add.click();
        categories.get(0).click();
        WaitUntilElementVisible(optionsRole.get(1));
        optionsRole.get(1).click();
        categories.get(1).click();
        optionsStatus.get(1).click();
        employeeName.sendKeys(NAME);
        selectName.click();
        int random = (int) Math.rint(Math.random() * 10);
        userName.sendKeys(USERNAME + random);
        password.get(0).sendKeys(PASSWORD);
        password.get(1).sendKeys(PASSWORD);
        buttonSave.click();
    }

    public void deleteUser() throws InterruptedException {
        WaitUntilElementVisible(deleteUser);
       // BasePage.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        deleteUser.click();
        yesDelete.click();
    }

    public void deleteAdmin() {
        WaitUntilElementVisible(categories.get(0));
        //BasePage.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        categories.get(0).click();
        optionsRole.get(1).click();
        searchButton.click();
        //Thread.sleep(1000);
        deleteAdmin.click();
    }

    public String validationNames() {
        return nameValidation.getText();
    }

    public String roleValidation() {
        return roleValidation.getText();
    }

    public Boolean validationMessageAssert() {
        return isDisplayed(validationMessage);
    }

}
