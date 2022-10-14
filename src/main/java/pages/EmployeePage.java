package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmployeePage extends BasePage{

    public EmployeePage(WebDriver driver) {
        super(driver);
    }

    By ValidationName = By.className(("oxd-text oxd-text--h6 --strong"));

}
