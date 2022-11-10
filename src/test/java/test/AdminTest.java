package test;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.LoginPage;

import static org.testng.AssertJUnit.assertEquals;


public class AdminTest {
    private WebDriver driver;
    LoginPage loginPage;
    AdminPage adminPage;


  /*  @Before
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
*/

   //@Title("Search system user with username")
    @Test
    public void searchUser() throws InterruptedException {
        adminPage = new AdminPage(driver);
        loginPage.Login("Admin", "admin123");
        loginPage.admin();
        adminPage.searchUserWithUserName();
        Assert.assertEquals("Alice.Duval",adminPage.validationNames());

    }

  //@Title("Search system user with role")
    @Test
    public void searchRole() throws InterruptedException {
        adminPage = new AdminPage(driver);
        loginPage.Login("Admin", "admin123");
        loginPage.admin();
        adminPage.searchUserWithRole();
        Assert.assertEquals("ESS", adminPage.roleValidation());
    }

    @Test
    public void editJob() throws InterruptedException {
        adminPage = new AdminPage(driver);
        loginPage.Login("Admin", "admin123");
        loginPage.admin();
        adminPage.editJob();
        Assert.assertEquals(true,adminPage.validationMessageAssert());
    }

    @Test
    public void addNewAdmin() throws InterruptedException {
        adminPage = new AdminPage(driver);
        loginPage.Login("Admin", "admin123");
        loginPage.admin();
        adminPage.addAdmin();
        Assert.assertEquals(true, adminPage.validationMessageAssert());
    }

    @Test
    public void deleteUser() throws InterruptedException {
        adminPage = new AdminPage(driver);
        loginPage.Login("Admin", "admin123");
        loginPage.admin();
        adminPage.deleteUser();
        Assert.assertEquals(true, adminPage.validationMessageAssert());
    }

    @Test
    public void deleteAdmin() throws InterruptedException {
        adminPage = new AdminPage(driver);
        loginPage.Login("Admin", "admin123");
        loginPage.admin();
        adminPage.deleteAdmin();
        Assert.assertEquals(true, adminPage.validationMessageAssert());
    }


}
