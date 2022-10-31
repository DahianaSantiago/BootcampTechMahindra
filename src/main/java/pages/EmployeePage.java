package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EmployeePage extends BasePage {

    public EmployeePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[text()=' Add ']")
            public WebElement addButton;

    @FindBy(className ="oxd-text oxd-text--h6 --strong" )
    public WebElement ValidationName;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input")
    public WebElement validationNumber;
    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[3]")
    public WebElement secondValidationNumber;
    @FindBy(name = "firstName")
            public WebElement nameEmployee;
    @FindBy(name = "lastName")
    public WebElement lastNameEmployee;
    @FindBy(xpath = "//button[text()=' Save ']")
    public WebElement saveButton ;
    @FindBy(className = "oxd-input oxd-input--active")
    public List<WebElement> searchEmployeeField;
    @FindBy(xpath = "//button[text()=' Search ']")
    public WebElement searchEmployeeButton;
    @FindBy(xpath ="//div[text()='0046']" )
            public WebElement idNumberSearch;
    @FindBy(xpath = "//span[text()='No Records Found']")
            public WebElement noFoundEmployee;
    @FindBy(css = "button[class='oxd-icon-button oxd-table-cell-action-space']")
    public List<WebElement> deleteEmployee;
    @FindBy(xpath = "//button[text()=' Yes, Delete ']")
    public WebElement deleteEmployeeButton;
    @FindBy (xpath = "/html/body/div/div[2]/div")
            public WebElement deleteMessage;
    @FindBy (css = "div[class='oxd-autocomplete-text-input oxd-autocomplete-text-input--active']")
            public List<WebElement> SearchEmployeeWithName;


    public void addEmployee(String name, String lastName) throws InterruptedException {
        addButton.click();
        Thread.sleep(1000);
        nameEmployee.sendKeys(name);
        lastNameEmployee.sendKeys(lastName);
        Thread.sleep(3000);
        saveButton.click();
    }

    public void serchEmployee(String num) throws InterruptedException {
        searchEmployeeField.get(1).sendKeys(num);
        Thread.sleep(1000);
        searchEmployeeButton.click();
        Thread.sleep(2000);
    }

    public void deleteEmployee() throws InterruptedException {
        deleteEmployee.get(0).click();
        deleteEmployeeButton.click();
        Thread.sleep(2000);
    }

    public void searchEmployeeWithNames() throws InterruptedException {
        SearchEmployeeWithName.get(0).sendKeys("Fiona Grace");
        //scrollDown(SearchEmployeeWithName);
        searchEmployeeButton.click();
        Thread.sleep(2000);
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

    public String validateNumber() {
        return secondValidationNumber.getText();

    }

}
