package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EmployeePage;
import pages.LoginPage;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import static utils.Constants.ADMIN;
import static utils.Constants.PASSWORD_LOGIN;

public class LoginPageTest extends BasePageTest {

    @Test
    public void loginSuccessful() {
        LoginPage loginPage = new LoginPage(driver);
        logIn(ADMIN, PASSWORD_LOGIN);
        assertTrue(loginPage.loginSuccessfulVerify());
    }

    @Test
    public void loginNotSuccessful() {
        LoginPage loginPage = new LoginPage(driver);
        logIn(ADMIN, "noadmin123");
        assertEquals("Invalid credentials", loginPage.loginNotSuccessful());
    }

    @Test
    public void loginWithoutCredencials() {
        LoginPage loginPage = new LoginPage(driver);
        logIn(" ", " ");
        assertEquals("Required", loginPage.withoutCredentials());
    }

    @Test
    public void logout() {
        LoginPage loginPage = new LoginPage(driver);
        logIn(ADMIN, PASSWORD_LOGIN);
        loginPage.Logout();
        assertTrue(loginPage.logoutSuccessful());
    }

    @Test
    public void addEmployee(){
        EmployeePage employeePage = new EmployeePage(driver);
        logIn(ADMIN, PASSWORD_LOGIN);
        employeePage.addEmployee("Dahia", "Santiago");
    }

    @Test
    public void searchEmployee() {
        EmployeePage employeePage = new EmployeePage(driver);
        logIn(ADMIN, PASSWORD_LOGIN);
        employeePage.serchEmployee("0007");
        assertEquals("0007", employeePage.validateId());
    }

    @Test
    public void searchNoEmployee(){
        EmployeePage employeePage = new EmployeePage(driver);
        logIn(ADMIN, PASSWORD_LOGIN);
        employeePage.serchEmployee("000000");
        assertEquals("No Records Found", employeePage.validateNoFound());
    }

    @Test
    public void deleteEmployee() {
        EmployeePage employeePage = new EmployeePage(driver);
        logIn(ADMIN, PASSWORD_LOGIN);
        employeePage.deleteEmployee();
        assertTrue(employeePage.deleteEmployeeValidation());
    }

    @Test
    public void searchEmployeeWithName(){
        EmployeePage employeePage = new EmployeePage(driver);
        logIn(ADMIN, PASSWORD_LOGIN);
        employeePage.searchEmployeeWithNames();
    }

}
