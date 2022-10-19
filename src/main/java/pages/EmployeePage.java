package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class EmployeePage extends BasePage{

    public EmployeePage(WebDriver driver) {
        super(driver);
    }

    By addButton = By.xpath("//button[text()=' Add ']");


    By ValidationName = By.className(("oxd-text oxd-text--h6 --strong"));
    By  validationNumber = By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/input[1]");
    By secondValidationNumber = By.xpath("(//input[@class='oxd-input oxd-input--active'])[3]");
    By nameEmployee = By.name("firstName");
    By lastNameEmployee = By.name("lastName");
    By saveButton = By.xpath("//button[text()=' Save ']");


    public void addEmployee(String name , String lastName) throws InterruptedException {

        click(addButton);
        type(name,nameEmployee);
        type(lastName,lastNameEmployee);
        System.out.println(getText(validationNumber));
        Thread.sleep(3000);
        click(saveButton);
    }


    public By referenceNumber(){

        return   validationNumber;}

    public String validateNumber(){return getText(secondValidationNumber);
    }

}
