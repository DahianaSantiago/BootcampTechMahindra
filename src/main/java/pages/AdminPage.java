package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.swing.table.TableRowSorter;
import java.util.ArrayList;
import java.util.List;

public class AdminPage extends BasePage{

    public AdminPage(WebDriver driver) {super(driver);}
    private WebDriver driver;

    By usernameField = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    By searchButton = By.xpath("//button[text()=' Search ']");
    By nameValidation = By.xpath("//div[text()='Alice.Duval']");

    //Whit Role
    By role = By.xpath("(//div[text()='-- Select --'])[1]");
    By ESSSelect = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div[3]");
    By roleValidation = By.xpath("(//div[text()='ESS'])[2]");
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
    public String validationName(){return getText(nameValidation); }

    public String roleValidation(){return getText(roleValidation);}

}
