package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.EmployeePage;
import pages.LoginPage;
import static org.junit.Assert.*;

public class LoginPageTest {

   private WebDriver driver;
   LoginPage loginPage;
   EmployeePage employeePage;

       @Before
       public void setUp() throws Exception{
        loginPage = new LoginPage(driver);
        driver = loginPage.chromeDriverConnection();
        loginPage.visit("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
       }

       @After
       public void tearDown() throws Exception{
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

           //String idNumber = employeePage.referenceNumber();
           // System.out.println(idNumber);
          // assertEquals(employeePage.referenceNumber(),employeePage.validateNumber());
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

 }
