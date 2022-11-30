package test;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPage;
import static utils.Constants.*;
;


public class AdminTest extends BasePageTest {


    @Test
    public void searchUser() {
        AdminPage adminPage = new AdminPage(driver);
        logInAdmin(ADMIN, PASSWORD_LOGIN);
        adminPage.searchUserWithUserName();
        Assert.assertEquals("Alice.Duval",adminPage.validationNames());
    }

    @Test
    public void searchRole() {
        AdminPage adminPage = new AdminPage(driver);
        logInAdmin(ADMIN, PASSWORD_LOGIN);
        adminPage.searchUserWithRole();
        Assert.assertEquals("ESS", adminPage.roleValidation());
    }

    @Test
    public void editJob() {
        AdminPage adminPage = new AdminPage(driver);
        logInAdmin(ADMIN, PASSWORD_LOGIN);
        adminPage.editJob();
        Assert.assertEquals(true,adminPage.validationMessageAssert());
    }

    @Test
    public void addNewAdmin(){
        AdminPage adminPage = new AdminPage(driver);
        logInAdmin(ADMIN, PASSWORD_LOGIN);
        adminPage.addAdmin();
        Assert.assertEquals(true, adminPage.validationMessageAssert());
    }

    @Test
    public void deleteUser() {
        AdminPage adminPage = new AdminPage(driver);
        logInAdmin(ADMIN, PASSWORD_LOGIN);
        adminPage.deleteUser();
        Assert.assertEquals(true, adminPage.validationMessageAssert());
    }

    @Test
    public void deleteAdmin(){
        AdminPage adminPage = new AdminPage(driver);
        logInAdmin(ADMIN, PASSWORD_LOGIN);
        adminPage.deleteAdmin();
        Assert.assertEquals(true, adminPage.validationMessageAssert());
    }
}
