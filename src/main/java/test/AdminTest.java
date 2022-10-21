package test;

import net.thucydides.core.annotations.Title;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.AdminPage;
import pages.LoginPage;

import static org.junit.Assert.assertEquals;


public class AdminTest {
    private WebDriver driver;
    LoginPage loginPage;
    AdminPage adminPage;


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

    @Title("Search system user with username")
    @Test
    public void searchUser() throws InterruptedException {
        adminPage = new AdminPage(driver);
        loginPage.Login("Admin", "admin123");
        loginPage.admin();
        adminPage.searchUserWithUserName();
        assertEquals("Alice.Duval", adminPage.validationName());
    }

    @Title("Search system user with role")
    @Test
    public void searchRole() throws InterruptedException {
        adminPage = new AdminPage(driver);
        loginPage.Login("Admin", "admin123");
        loginPage.admin();
        adminPage.searchUserWithRole();
        assertEquals("ESS", adminPage.roleValidation());
    }

    @Title("Edit job in admin")
    @Test
    public void editJob() throws InterruptedException {
        adminPage = new AdminPage(driver);
        loginPage.Login("Admin", "admin123");
        loginPage.admin();
        adminPage.editJob();
        assertEquals(true, adminPage.validationMessage());
    }

    @Title("Add new admin")
    @Test
    public void addNewAdmin() throws InterruptedException {
        adminPage = new AdminPage(driver);
        loginPage.Login("Admin", "admin123");
        loginPage.admin();
        adminPage.addAdmin();
        assertEquals(true, adminPage.validationMessage());
    }

    @Title("Delete user")
    @Test
    public void deleteUser() throws InterruptedException {
        adminPage = new AdminPage(driver);
        loginPage.Login("Admin", "admin123");
        loginPage.admin();
        adminPage.deleteUser();
        assertEquals(true, adminPage.validationMessage());
    }

    @Title("Delete admin")
    @Test
    public void deleteAdmin() throws InterruptedException {
        adminPage = new AdminPage(driver);
        loginPage.Login("Admin", "admin123");
        loginPage.admin();
        adminPage.deleteAdmin();
        assertEquals(true, adminPage.validationMessage());
    }


}
