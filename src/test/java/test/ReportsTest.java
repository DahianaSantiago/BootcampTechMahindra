package test;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ReportsPage;

import static test.BasePageTest.driver;


public class ReportsTest {

    LoginPage loginPage;
    ReportsPage reports;



    @Test
    public void addReport() throws InterruptedException {
      //  loginPage = new LoginPage(driver);
        reports = new ReportsPage(driver);
        loginPage.Login("Admin", "admin123");
        loginPage.incomeReport();
        int random = (int) Math.rint(Math.random());
        reports.addReport("report number " + random);
    }

    @Test
    public void deleteReport() throws InterruptedException {
        loginPage = new LoginPage(driver);
        reports = new ReportsPage(driver);
        loginPage.Login("Admin", "admin123");
        loginPage.incomeReport();
        reports.deleteReport();
        Assert.assertEquals(true, reports.validationMessage());

    }


    @Test
    public void notDeleteReport() throws InterruptedException {
        reports = new ReportsPage(driver);
        loginPage.Login("Admin", "admin123");
        loginPage.incomeReport();
        reports.notDeleteReport();
    }

    @Test
    public void modifyNameReport() throws InterruptedException {
        reports = new ReportsPage(driver);
        loginPage.Login("Admin", "admin123");
        loginPage.incomeReport();
        reports.modifyReport("etc");
    }

    @Test
    public void searchNameReport() throws InterruptedException {
        loginPage = new LoginPage(driver);
        reports = new ReportsPage(driver);
        loginPage.Login("Admin", "admin123");
        loginPage.incomeReport();
        reports.SearchReport("All");
        Assert.assertEquals(true, reports.validationMessageReport());
    }

}
