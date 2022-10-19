package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmployeePage extends BasePage{

    public EmployeePage(WebDriver driver) {
        super(driver);
    }

    By addButton = By.xpath("//button[text()=' Add ']");


    By ValidationName = By.className(("oxd-text oxd-text--h6 --strong"));

    By validationNumber = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input");

    By secondValidationNumber = By.xpath("(//input[@class='oxd-input oxd-input--active'])[3]");
    By nameEmployee = By.name("firstName");
    By lastNameEmployee = By.name("lastName");
    By saveButton = By.xpath("//button[text()=' Save ']");

    By searchEmployeeField = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/input");
    By searchEmployeeButton = By.xpath("//button[text()=' Search ']");
    By idNumberSearch = By.xpath("//div[text()='0046']");
    By noFoundEmployee = By.xpath("//span[text()='No Records Found']");
    By deleteEmployee = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[9]/div/button[1]");
    By getDeleteEmployeeButton = By.xpath("//button[text()=' Yes, Delete ']");
    By deleteMessage = By.xpath("/html/body/div/div[2]/div");
    By SearchEmployeeWithName = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input");




    public void addEmployee(String name , String lastName) throws InterruptedException {
        click(addButton);
        type(name,nameEmployee);
        type(lastName,lastNameEmployee);
        System.out.println(getText(validationNumber));
        Thread.sleep(3000);
        click(saveButton);
    }

    public void serchEmployee(String num) throws InterruptedException {
        type(num,searchEmployeeField);
        click(searchEmployeeButton);
        Thread.sleep(2000);
        String message = getText(noFoundEmployee);
        System.out.println(message);
    }

    public void deleteEmployee() throws InterruptedException {
        click(deleteEmployee);
        click(getDeleteEmployeeButton);
        Thread.sleep(2000);
    }

    public void searchEmployeeWithNames() throws InterruptedException {
        type("Fiona Grace",SearchEmployeeWithName);
        scrollDown(SearchEmployeeWithName);
        click(searchEmployeeButton);
        Thread.sleep(2000);
    }

    public boolean deleteEmployeeValidation(){return isDisplayed(deleteMessage);}

    public String validateNoFound(){ return getText(noFoundEmployee);}

    public String validateId(){return getText(idNumberSearch);}

    public By referenceNumber(){ return validationNumber;}


    public String validateNumber(){return getText(secondValidationNumber);

    }

}
