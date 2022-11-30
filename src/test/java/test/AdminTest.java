package test;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPage;


public class AdminTest extends BasePageTest {


    @Test
    public void searchUser() {
        AdminPage adminPage = new AdminPage(driver);
        logInAdmin("Admin", "admin123");
        adminPage.searchUserWithUserName();
        Assert.assertEquals("Alice.Duval",adminPage.validationNames());
    }

    @Test
    public void searchRole() {
        AdminPage adminPage = new AdminPage(driver);
        logInAdmin("Admin", "admin123");
        adminPage.searchUserWithRole();
        Assert.assertEquals("ESS", adminPage.roleValidation());
    }

    @Test
    public void editJob() {
        AdminPage adminPage = new AdminPage(driver);
        logInAdmin("Admin", "admin123");
        adminPage.editJob();
        Assert.assertEquals(true,adminPage.validationMessageAssert());
    }

    @Test
    public void addNewAdmin(){
        AdminPage adminPage = new AdminPage(driver);
        logInAdmin("Admin", "admin123");
        adminPage.addAdmin();
        Assert.assertEquals(true, adminPage.validationMessageAssert());
    }

    @Test
    public void deleteUser() throws InterruptedException {
        AdminPage adminPage = new AdminPage(driver);
        logInAdmin("Admin", "admin123");
        adminPage.deleteUser();
        Assert.assertEquals(true, adminPage.validationMessageAssert());
    }

    @Test
    public void deleteAdmin(){
        AdminPage adminPage = new AdminPage(driver);
        logInAdmin("Admin", "admin123");
        adminPage.deleteAdmin();
        Assert.assertEquals(true, adminPage.validationMessageAssert());
    }


}
