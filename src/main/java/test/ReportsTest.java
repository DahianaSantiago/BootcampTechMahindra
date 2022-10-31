package test;

import net.thucydides.core.annotations.Title;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ReportsPage;

import static org.junit.Assert.assertEquals;

public class ReportsTest {
    private WebDriver driver;
    LoginPage loginPage;
    ReportsPage reports;


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

    @Title("Income Report ")
    @Test
    public void addReport() throws InterruptedException {
        loginPage = new LoginPage(driver);
        reports = new ReportsPage(driver);
        loginPage.Login("Admin", "admin123");
        loginPage.IncomeReport();
        int random = (int) Math.rint(Math.random());
        reports.addReport("report number " + random);
    }

    @Title("Delete Report")
    @Test
    public void deleteReport() throws InterruptedException {
        loginPage = new LoginPage(driver);
        reports = new ReportsPage(driver);
        loginPage.Login("Admin", "admin123");
        loginPage.IncomeReport();
        reports.deleteReport();
        Assert.assertEquals(true, reports.validationMessage());

    }

    @Title("Not Delete Report")
    @Test
    public void notDeleteReport() throws InterruptedException {
        reports = new ReportsPage(driver);
        loginPage.Login("Admin", "admin123");
        loginPage.IncomeReport();
        reports.notDeleteReport();
    }

    @Title("modify Name Report")
    @Test
    public void modifyNameReport() throws InterruptedException {
        reports = new ReportsPage(driver);
        loginPage.Login("Admin", "admin123");
        loginPage.IncomeReport();
        reports.modifyReport("etc");
    }

    @Title("Search Report")
    @Test
    public void searchNameReport() throws InterruptedException {
        loginPage = new LoginPage(driver);
        reports = new ReportsPage(driver);
        loginPage.Login("Admin", "admin123");
        loginPage.IncomeReport();
        reports.SearchReport("All");
        Assert.assertEquals(true, reports.validationMessageReport());
    }

}
