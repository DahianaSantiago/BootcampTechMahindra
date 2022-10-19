package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Reports extends BasePage{

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
    By  Record = By.xpath("(//*[@class='oxd-icon bi-trash'])[1]");
    By deleteRecord = By.xpath("(//*[@class='oxd-icon-button oxd-table-cell-action-space'])[1]");

    By yesDelete = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--text orangehrm-button-margin']");

    public void addReport(String report) throws InterruptedException {

        click(addButton);
        Thread.sleep(1000);
        type(report,reportName);
        Thread.sleep(2000);
        //click(displayFiledsOne);
        Thread.sleep(2000);
        click(DisplayFiledsOne);
        Thread.sleep(1000);
        click(valuesDisplayFiledsOne);
        click(displayFiledsTwo);
        click(getValuesDisplayFiledsTwo);
        click(buttonPlus);
        click(buttonSave);
        Thread.sleep(2000);
    }
    public void deleteReport() throws InterruptedException {

        Thread.sleep(2000);
        click(Record);
        click(deleteRecord);
        Thread.sleep(2000);
        click(yesDelete);
        Thread.sleep(1500);
    }

}
