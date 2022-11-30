package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.List;

public class EmployeePage extends BasePage {

    public EmployeePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[text()=' Add ']")
    public WebElement addButton;

    @FindBy(xpath = "//span[text()='PIM']")
    public WebElement pimButton;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input")
    public WebElement validationNumber;
    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[3]")
    public WebElement secondValidationNumber;
    @FindBy(name = "firstName")
    public WebElement nameEmployee;
    @FindBy(name = "lastName")
    public WebElement lastNameEmployee;
    @FindBy(xpath = "//button[text()=' Save ']")
    public WebElement saveButton;
    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    public WebElement searchEmployeeField;
    @FindBy(xpath = "//button[text()=' Search ']")
    public WebElement searchEmployeeButton;
    @FindBy(xpath = "//div[text()='0007']")
    public WebElement idNumberSearch;
    @FindBy(xpath = "//span[text()='No Records Found']")
    public WebElement noFoundEmployee;
    @FindBy(css = "button[class='oxd-icon-button oxd-table-cell-action-space']")
    public List<WebElement> deleteEmployee;
    @FindBy(xpath = "//button[text()=' Yes, Delete ']")
    public WebElement deleteEmployeeButton;
    @FindBy(xpath = "/html/body/div/div[2]/div")
    public WebElement deleteMessage;
    @FindBy(xpath = "//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div/input")
    public WebElement searchEmployeeWithName;
    @FindBy(xpath = "//span[text()='Admin']")
    public WebElement adminButton;


    public void addEmployee(String name, String lastName) {
        pimButton.click();
        addButton.click();
        WaitUntilElementVisible(nameEmployee);
        nameEmployee.sendKeys(name);
        lastNameEmployee.sendKeys(lastName);
        WaitUntilElementVisible(saveButton);
        saveButton.click();
    }

    public void serchEmployee(String num) {
        pimButton.click();
        searchEmployeeField.sendKeys(num);
        WaitUntilElementVisible(searchEmployeeButton);
        searchEmployeeButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
    }

    public void deleteEmployee() {
        adminButton.click();
        deleteEmployee.get(10).click();
        WaitUntilElementVisible(deleteEmployeeButton);
        deleteEmployeeButton.click();
        WaitUntilElementVisible(deleteMessage);
    }

    public void searchEmployeeWithNames(){
        adminButton.click();
        WaitUntilElementVisible(searchEmployeeWithName);
        searchEmployeeWithName.sendKeys("Tester Testing");
        searchEmployeeButton.click();
    }

    public boolean deleteEmployeeValidation() {
        return isDisplayed(deleteMessage);
    }

    public String validateNoFound() {
        return noFoundEmployee.getText();
    }

    public String validateId() {
        return idNumberSearch.getText();
    }


}
