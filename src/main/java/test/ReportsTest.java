package test;

import net.thucydides.core.annotations.Title;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.Reports;
import static org.junit.Assert.assertEquals;

public class ReportsTest {
    private WebDriver driver;
    LoginPage loginPage;
    Reports reports;

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
        loginPage.Login("Admin","admin123");
        loginPage.IncomeReport();
        int random = (int) Math.rint(Math.random());
        reports.addReport("report number " + random);
    }

    @Title("Delete Report")
    @Test
    public void deleteReport() throws InterruptedException {
        reports = new Reports(driver);
        loginPage.Login("Admin","admin123");
        loginPage.IncomeReport();
        reports.deleteReport();
        assertEquals(true,reports.validationMessage());

    }
}
