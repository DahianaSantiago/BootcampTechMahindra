package test;

import net.thucydides.core.annotations.Title;
import org.junit.After;
import org.junit.Assert;
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
        Assert.assertEquals("Alice.Duval",adminPage.validationNames());

    }

    @Title("Search system user with role")
    @Test
    public void searchRole() throws InterruptedException {
        adminPage = new AdminPage(driver);
        loginPage.Login("Admin", "admin123");
        loginPage.admin();
        adminPage.searchUserWithRole();
        Assert.assertEquals("ESS", adminPage.roleValidation());
    }

    @Title("Edit job in admin")
    @Test
    public void editJob() throws InterruptedException {
        adminPage = new AdminPage(driver);
        loginPage.Login("Admin", "admin123");
        loginPage.admin();
        adminPage.editJob();
        Assert.assertEquals(true,adminPage.validationMessageAssert());
    }

    @Title("Add new admin")
    @Test
    public void addNewAdmin() throws InterruptedException {
        adminPage = new AdminPage(driver);
        loginPage.Login("Admin", "admin123");
        loginPage.admin();
        adminPage.addAdmin();
        Assert.assertEquals(true, adminPage.validationMessageAssert());
    }

    @Title("Delete user")
    @Test
    public void deleteUser() throws InterruptedException {
        adminPage = new AdminPage(driver);
        loginPage.Login("Admin", "admin123");
        loginPage.admin();
        adminPage.deleteUser();
        assertEquals(true, adminPage.validationMessageAssert());
    }

    @Title("Delete admin")
    @Test
    public void deleteAdmin() throws InterruptedException {
        adminPage = new AdminPage(driver);
        loginPage.Login("Admin", "admin123");
        loginPage.admin();
        adminPage.deleteAdmin();
        assertEquals(true, adminPage.validationMessageAssert());
    }


}
