package test;

import net.thucydides.core.annotations.Title;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.EmployeePage;
import pages.LoginPage;
import pages.Reports;

import static org.junit.Assert.*;

public class LoginPageTest {

    private WebDriver driver;
    LoginPage loginPage;
    EmployeePage employeePage;

    Reports reports;

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

    @Test
    public void loginSuccessful() throws InterruptedException {
        loginPage.Login("Admin", "admin123");
        assertEquals(true, loginPage.loginSuccessful());
    }

    @Test
    public void loginNotSuccessful() throws InterruptedException {
        loginPage.Login("Admin", "noadmin123");
        Thread.sleep(2000);
        assertEquals("Invalid credentials", loginPage.loginNotSuccessful());

    }

    @Test
    public void loginWithoutCredencials() throws InterruptedException {
        loginPage.Login("", "");
        assertEquals("Required", loginPage.withoutCredentials());
    }

    @Test
    public void logout() throws InterruptedException {
        loginPage.Login("Admin", "admin123");
        loginPage.Logout();
        assertEquals(true, loginPage.logoutSuccessful());
    }

    @Test
    public void addEmployee() throws InterruptedException {
        employeePage = new EmployeePage(driver);
        loginPage.Login("Admin", "admin123");
        employeePage.addEmployee("Dahia", "Santiago");
        //String idNumber = employeePage.referenceNumber();
        // System.out.println(idNumber);
        // assertEquals(employeePage.referenceNumber(),employeePage.validateNumber());
    }

    @Title("Income Report ")
    @Test
    public void addReport() throws InterruptedException {
        employeePage = new EmployeePage(driver);
        reports = new Reports(driver);
        loginPage.IncomeReport("Admin", "admin123");
        int random = (int) Math.rint(Math.random());
        reports.addReport("report number seven" + random);

    }

    @Title("Deleye Report")
    @Test
    public void deleteReport() throws InterruptedException {
        employeePage = new EmployeePage(driver);
        reports = new Reports(driver);


    }
}
