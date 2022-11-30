package test;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.EmployeePage;
import pages.LoginPage;
import pages.ReportsPage;

import static test.BasePageTest.driver;


public class ReportsTest extends BasePageTest{


    @Test
    public void addReport() {
        ReportsPage reportsPage = new ReportsPage(driver);
        logInReport("Admin", "admin123");
        int random = (int) Math.rint(Math.random());
        reportsPage.addReport("report number " + random);
    }

    @Test
    public void deleteReport(){
        ReportsPage reportsPage = new ReportsPage(driver);
        logInReport("Admin", "admin123");
        reportsPage.deleteReport();
        Assert.assertEquals(true, reportsPage.validationMessage());

    }

    @Test
    public void notDeleteReport() {
        ReportsPage reportsPage = new ReportsPage(driver);
        logInReport("Admin", "admin123");
        reportsPage.notDeleteReport();
    }

    @Test
    public void modifyNameReport()  {
        ReportsPage reportsPage = new ReportsPage(driver);
        logInReport("Admin", "admin123");
        reportsPage.modifyReport("etc");
    }

    @Test
    public void searchNameReport(){
        ReportsPage reportsPage = new ReportsPage(driver);
        logInReport("Admin", "admin123");
        reportsPage.SearchReport("All");
        Assert.assertEquals(true, reportsPage.validationMessageReport());
    }

}
