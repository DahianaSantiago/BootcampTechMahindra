package test;

import net.thucydides.core.annotations.Title;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.EmployeePage;
import pages.LoginPage;

import static org.junit.Assert.assertEquals;

public class LoginPageTest {

    private WebDriver driver;
    LoginPage loginPage;
    EmployeePage employeePage;


    @Before
    public void setUp() throws Exception {
        loginPage = new LoginPage(driver);
        driver = loginPage.chromeDriverConnection();
        loginPage.visit("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Title("Login Successful")
    @Test
    public void loginSuccessful() throws InterruptedException {
        loginPage.Login("Admin", "admin123");
        assertEquals(true, loginPage.loginSuccessful());
    }

    @Title("Login No Successful")
    @Test
    public void loginNotSuccessful() throws InterruptedException {
        loginPage.Login("Admin", "noadmin123");
        Thread.sleep(2000);
        assertEquals("Invalid credentials", loginPage.loginNotSuccessful());
    }

    @Title("Login without credencials")
    @Test
    public void loginWithoutCredencials() throws InterruptedException {
        loginPage.Login("", "");
        assertEquals("Required", loginPage.withoutCredentials());
    }

    @Title("Logout Successful")
    @Test
    public void logout() throws InterruptedException {
        loginPage.Login("Admin", "admin123");
        loginPage.Logout();
        assertEquals(true, loginPage.logoutSuccessful());
    }

    @Title("Add new employee")
    @Test
    public void addEmployee() throws InterruptedException {
        employeePage = new EmployeePage(driver);
        loginPage.Login("Admin", "admin123");
        employeePage.addEmployee("Dahia", "Santiago");
    }

    @Title("Search an employee")
    @Test
    public void searchEmployee() throws InterruptedException {
        employeePage = new EmployeePage(driver);
        loginPage.Login("Admin", "admin123");
        employeePage.serchEmployee("0217");
        assertEquals("0217", employeePage.validateId());
    }

    @Title("Search for non existent employee")
    @Test
    public void searchNoEmployee() throws InterruptedException {
        employeePage = new EmployeePage(driver);
        loginPage.Login("Admin", "admin123");
        employeePage.serchEmployee("000000");
        assertEquals("No Records Found", employeePage.validateNoFound());
    }

    @Title("Delete an employee")
    @Test
    public void deleteEmployee() throws InterruptedException {
        employeePage = new EmployeePage(driver);
        loginPage.Login("Admin", "admin123");
        employeePage.deleteEmployee();
        assertEquals(true, employeePage.deleteEmployeeValidation());
    }

    @Title("Search an employee with name")
    @Test
    public void searchEmployeeWithName() throws InterruptedException {
        employeePage = new EmployeePage(driver);
        loginPage.Login("Admin", "admin123");
        employeePage.searchEmployeeWithNames();
    }

}
