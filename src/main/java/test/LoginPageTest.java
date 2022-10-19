package test;

import net.thucydides.core.annotations.Title;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.EmployeePage;
import pages.LoginPage;
import pages.Reports;

import static org.junit.Assert.assertEquals;

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
        loginPage.Login("Admin","admin123");
        assertEquals(true,loginPage.loginSuccessful());
       }
       @Test
        public void loginNotSuccessful() throws InterruptedException {
           loginPage.Login("Admin", "noadmin123");
           Thread.sleep(2000);
           assertEquals("Invalid credentials",loginPage.loginNotSuccessful());
       }
       @Test
        public void loginWithoutCredencials() throws InterruptedException {
           loginPage.Login("","");
           assertEquals("Required",loginPage.withoutCredentials());
       }
       @Test
        public void logout() throws InterruptedException {
           loginPage.Login("Admin", "admin123");
           loginPage.Logout();
           assertEquals(true,loginPage.logoutSuccessful());
       }
       @Test
        public void addEmployee() throws InterruptedException {
           employeePage = new EmployeePage(driver);
           loginPage.Login("Admin","admin123");
           employeePage.addEmployee("Dahia","Santiago");
        }
        @Test
        public void searchEmployee() throws InterruptedException {
            employeePage = new EmployeePage(driver);
            loginPage.Login("Admin","admin123");
            employeePage.serchEmployee("0046");
            assertEquals("0046",employeePage.validateId());
        }
        @Test
         public void searchNoEmployee() throws InterruptedException {
            employeePage = new EmployeePage(driver);
            loginPage.Login("Admin","admin123");
            employeePage.serchEmployee("000000");
            assertEquals("No Records Found",employeePage.validateNoFound());
        }
        @Test
        public void deleteEmployee() throws InterruptedException {
            employeePage = new EmployeePage(driver);
            loginPage.Login("Admin","admin123");
            employeePage.deleteEmployee();
            assertEquals(true,employeePage.deleteEmployeeValidation());
        }
        @Test
        public void searchEmployeeWithName() throws InterruptedException {
            employeePage = new EmployeePage(driver);
            loginPage.Login("Admin","admin123");
            employeePage.searchEmployeeWithNames();

        }
        @Title("Income Report ")
        @Test
         public void addReport() throws InterruptedException {
            loginPage.Login("Admin","admin123");
            loginPage.IncomeReport();
            int random = (int) Math.rint(Math.random());
            reports.addReport("report number seven" + random);
         }
        @Title("Delete Report")
        @Test
        public void deleteReport() throws InterruptedException {
            reports = new Reports(driver);
            loginPage.Login("Admin","admin123");
            loginPage.IncomeReport();
            reports.deleteReport();
        }
}
