package pages;

import net.serenitybdd.screenplay.BackendTask;
import net.serenitybdd.screenplay.waits.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static net.serenitybdd.screenplay.waits.Wait.until;

public class Reports extends BasePage {

    public Reports(WebDriver driver) {
        super(driver);
    }

    By addButton = By.xpath("//button[text()=' Add ']");
    By reportName = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    By DisplayFiledsOne = By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/i[1]");
    By valuesDisplayFiledsOne = By.xpath("//*[text()='Personal']");
    By getValuesDisplayFiledsTwo = By.xpath("//*[text()='Employee Id']");
    By displayFiledsTwo = By.xpath("(//*[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[4]");
    By buttonSave = By.xpath("//button[text()=' Save ']");
    By buttonPlus = By.xpath("//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[3]/div[1]/div[2]/div[2]/div[2]/button[1]/i[1]");
    By record = By.xpath("(//*[@class='oxd-icon bi-trash'])[1]");
    By deleteRecord = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[3]/div/button[1]/i");
    By yesDelete = By.xpath("//button[text()=' Yes, Delete ']");

    By notDelete = By.xpath("//button[text()=' No, Cancel ']");
    By validationDelete = By.xpath("/html/body/div/div[2]");

    By updateRecord = By.xpath("(//*[@class='oxd-icon-button oxd-table-cell-action-space'])[2]");

    By updatReportName = By.xpath("(//*[@class='oxd-input oxd-input--active'])[2]");

    By searchReport = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input");

    By searchButton = By.xpath("//button[text()=' Search ']");
    By searchText = By.xpath("(//div[@class='oxd-table-cell oxd-padding-cell'])[2]");

    public void addReport(String report) throws InterruptedException {
        Thread.sleep(1000);
        click(addButton);
        Thread.sleep(2000);
        type(report, reportName);
        Thread.sleep(2000);
        click(DisplayFiledsOne);
        Thread.sleep(1000);
        click(valuesDisplayFiledsOne);
        click(displayFiledsTwo);
        click(getValuesDisplayFiledsTwo);
        click(buttonPlus);
        click(buttonSave);
    }

    public void deleteReport() throws InterruptedException {
        Thread.sleep(1000);
        click(deleteRecord);
        click(yesDelete);
        Thread.sleep(1000);
    }

    public void notDeleteReport() throws InterruptedException {
        Thread.sleep(2000);
        click(deleteRecord);
        Thread.sleep(2000);
        click(notDelete);
        Thread.sleep(3000);
    }

    public void modifyReport(String reportName) throws InterruptedException {
        click(updateRecord);
        Thread.sleep(1000);
        type(reportName, updatReportName);
        click(buttonSave);

    }

    public void SearchReport(String nameReport) throws InterruptedException {
        type(nameReport, searchReport);
        Thread.sleep(1000);
        scrollDown(searchReport);
        click(searchButton);
        Thread.sleep(2000);
    }

    public Boolean validationMessage() {
        return isDisplayed(validationDelete);
    }

    public Boolean validationMessageReport() {
        return isDisplayed(searchText);
    }

}
