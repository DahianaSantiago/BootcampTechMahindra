package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EmployeePage;
import pages.LoginPage;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;


public class LoginPageTest extends BasePageTest {

    EmployeePage employeePage;

    @Test
    public void loginSuccessful() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        logIn("Admin", "admin123");
        Assert.assertEquals(true,loginPage.loginSuccessfulVerify());
    }


    @Test
    public void loginNotSuccessful() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        logIn("Admin", "noadmin123");
        assertEquals("Invalid credentials", loginPage.loginNotSuccessful());
    }

    //@Title("Login without credencials")
    @Test
    public void loginWithoutCredencials() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        logIn(" ", " ");
        assertEquals("Required", loginPage.withoutCredentials());
    }

   // @Title("Logout Successful")
    @Test
    public void logout(){
        LoginPage loginPage = new LoginPage(driver);
        logIn("Admin", "admin123");
        loginPage.Logout();
        Assert.assertEquals(true,loginPage.logoutSuccessful());
    }

    @Test
    public void addEmployee() throws InterruptedException {
        EmployeePage employeePage = new EmployeePage(driver);
        logIn("Admin", "admin123");
        employeePage.addEmployee("Dahia", "Santiago");
    }

    @Test
    public void searchEmployee() throws InterruptedException {
        employeePage = new EmployeePage(driver);
        logIn("Admin", "admin123");
        employeePage.serchEmployee("0007");
        assertEquals("0007", employeePage.validateId());
    }

    //@Title("Search for non existent employee")
    @Test
    public void searchNoEmployee() throws InterruptedException {
        //loginPage = new LoginPage(driver);
        employeePage = new EmployeePage(driver);
        logIn("Admin", "admin123");
        employeePage.serchEmployee("000000");
        assertEquals("No Records Found", employeePage.validateNoFound());
    }

  //  @Title("Delete an employee")
    @Test
    public void deleteEmployee() throws InterruptedException {
        //loginPage = new LoginPage(driver);
        employeePage = new EmployeePage(driver);
        logIn("Admin", "admin123");
        employeePage.deleteEmployee();
        assertEquals(true, employeePage.deleteEmployeeValidation());
    }

   // @Title("Search an employee with name")
    @Test
    public void searchEmployeeWithName() throws InterruptedException {
        employeePage = new EmployeePage(driver);
        logIn("Admin", "admin123");
        employeePage.searchEmployeeWithNames();
    }

}
