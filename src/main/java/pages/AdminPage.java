package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.swing.table.TableRowSorter;
import java.util.ArrayList;
import java.util.List;

public class AdminPage extends BasePage{

    public AdminPage(WebDriver driver) {super(driver);}
    private WebDriver driver;

    By usernameField = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    By searchButton = By.xpath("//button[text()=' Search ']");
    By nameValidation = By.xpath("//div[text()='Alice.Duval']");
    By add = By.xpath("//button[text()=' Add ']");
    //By clicKCategories = By.cssSelector("div.oxd-select-text--after");
    @FindBy(css = "div.oxd-select-text--after")
            public List<WebElement> categories;

    @FindBy(css= "div.oxd-select-option")
            public List<WebElement> options;

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
    public void editJob() throws InterruptedException {
        click(job);
        click(jobTitles);
        Thread.sleep(1000);
        click(editJob);
        Thread.sleep(1000);
        type(" and Test automator",inputNewjob);
        click(buttonSave);
        Thread.sleep(1000);
    }

    public void searchUserWithUserName() throws InterruptedException {
        type("Alice.Duval",usernameField);
        click(searchButton);
        Thread.sleep(1000);
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
        Thread.sleep(3000);
        options.get(1).click();
        Thread.sleep(2000);
    }
    public String validationName(){return getText(nameValidation); }

    public String roleValidation(){return getText(roleValidation);}

    public Boolean validationMessageJob(){return isDisplayed(validationMessage);}

}
