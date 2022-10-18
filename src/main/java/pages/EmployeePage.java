package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmployeePage extends BasePage{

    public EmployeePage(WebDriver driver) {
        super(driver);
    }

    By addButton = By.xpath("//button[text()=' Add ']");
    By ValidationName = By.className(("oxd-text oxd-text--h6 --strong"));
    String  validationNumber = driver.findElement(By.cssSelector("div.oxd-layout div.oxd-layout-container div.oxd-layout-context div.orangehrm-background-container div.orangehrm-card-container form.oxd-form div.orangehrm-employee-container div.orangehrm-employee-form div.oxd-form-row:nth-child(1) div.oxd-grid-2.orangehrm-full-width-grid div.oxd-grid-item.oxd-grid-item--gutters div.oxd-input-group.oxd-input-field-bottom-space div:nth-child(2) > input.oxd-input.oxd-input--active")).getText();
    //By validationNumber = By.cssSelector("div.oxd-layout div.oxd-layout-container div.oxd-layout-context div.orangehrm-background-container div.orangehrm-card-container form.oxd-form div.orangehrm-employee-container div.orangehrm-employee-form div.oxd-form-row:nth-child(1) div.oxd-grid-2.orangehrm-full-width-grid div.oxd-grid-item.oxd-grid-item--gutters div.oxd-input-group.oxd-input-field-bottom-space div:nth-child(2) > input.oxd-input.oxd-input--active");
    By secondValidationNumber = By.xpath("(//input[@class='oxd-input oxd-input--active'])[3]");
    By nameEmployee = By.name("firstName");
    By lastNameEmployee = By.name("lastName");
    By saveButton = By.xpath("//button[text()=' Save ']");
    public void addEmployee(String name , String lastName) throws InterruptedException {

        click(addButton);
        type(name,nameEmployee);
        type(lastName,lastNameEmployee);
        System.out.printf(validationNumber+"es :");
        //type(id,validationNumber);
        Thread.sleep(3000);
        click(saveButton);
    }


    public String referenceNumber(){ return validationNumber;}

    public String validateNumber(){return getText(secondValidationNumber);
    }

}
