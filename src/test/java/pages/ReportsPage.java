package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ReportsPage extends BasePage {

    public ReportsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[text()=' Add ']")
    public WebElement addButton;
    @FindBy(css = "input.oxd-input:nth-child(1)")
    public WebElement reportName;
    @FindBy(css = "div.oxd-select-text")
    public List<WebElement> displayFileds;
    @FindBy(xpath = "//*[text()='Personal']")
    public WebElement valuesDisplayFiledsOne;
    @FindBy(xpath = "//*[text()='Employee Id']")
    public WebElement ValuesDisplayFiledsTwo;
    @FindBy(xpath = "//button[text()=' Save ']")
    public WebElement buttonSave;
    @FindBy(css = "i[class='oxd-icon bi-plus']")
    public List<WebElement> buttonPlus;
    @FindBy(xpath = "//button[text()=' Yes, Delete ']")
    public WebElement yesDelete;
    @FindBy(xpath = "//button[text()=' No, Cancel ']")
    public WebElement notDelete;
    @FindBy(xpath = "/html/body/div/div[2]")
    public WebElement validationDelete;
    @FindBy(css = " button[class='oxd-icon-button oxd-table-cell-action-space']")
    public List<WebElement> updateRecord;
    @FindBy(css = "input[class='oxd-input oxd-input--active']")
    public List<WebElement> updateReportName;
    @FindBy(css = "input[placeholder='Type for hints...']")
    public WebElement searchReport;
    @FindBy(xpath = "//button[text()=' Search ']")
    public WebElement searchButton;
    @FindBy(css = "div[class='oxd-table-cell oxd-padding-cell']:nth-child(2)")
    public WebElement searchText;

    public void addReport(String report) throws InterruptedException {
        Thread.sleep(1000);
        addButton.click();
        Thread.sleep(2000);
        reportName.sendKeys(report);
        Thread.sleep(2000);
        displayFileds.get(2).click();
        Thread.sleep(1000);
        valuesDisplayFiledsOne.click();
        //click(displayFiledsTwo);
        displayFileds.get(3).click();
        ValuesDisplayFiledsTwo.click();
        buttonPlus.get(1).click();
        buttonSave.click();
    }

    public void deleteReport() throws InterruptedException {
        Thread.sleep(1000);
        updateRecord.get(0).click();
        yesDelete.click();
        Thread.sleep(1000);
    }

    public void notDeleteReport() throws InterruptedException {
        Thread.sleep(2000);
        updateRecord.get(0).click();
        Thread.sleep(2000);
        notDelete.click();
        Thread.sleep(3000);
    }

    public void modifyReport(String reportName) throws InterruptedException {
        updateRecord.get(1).click();
        Thread.sleep(1000);
        updateReportName.get(1).sendKeys(reportName);
        buttonSave.click();

    }

    public void SearchReport(String nameReport) throws InterruptedException {
        searchReport.sendKeys(nameReport);
        Thread.sleep(1000);
        searchReport.sendKeys(Keys.ARROW_DOWN);
        searchButton.click();
        Thread.sleep(2000);
    }

    public Boolean validationMessage() {
        return isDisplayed(validationDelete);
    }

    public Boolean validationMessageReport() {
        return isDisplayed(searchText);
    }

}
