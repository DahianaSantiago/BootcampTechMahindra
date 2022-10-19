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

    @Title("Search System User With Username")
    @Test
    public void searchUser() throws InterruptedException {
        adminPage = new AdminPage(driver);
        loginPage.Login("Admin", "admin123");
        loginPage.admin();
        adminPage.searchUserWithUserName();
        assertEquals("Alice.Duval",adminPage.validationName());
    }
    @Title("Search System User With Role")
    @Test
    public void searchRole() throws InterruptedException {
        adminPage = new AdminPage(driver);
        loginPage.Login("Admin", "admin123");
        loginPage.admin();
        adminPage.searchUserWithRole();
        assertEquals("ESS",adminPage.roleValidation());
    }


}
