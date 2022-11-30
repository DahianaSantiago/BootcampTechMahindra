package test;

import org.testng.annotations.Test;
import pages.ReportsPage;

import static org.testng.AssertJUnit.assertTrue;
import static utils.Constants.*;
import static utils.Methods.*;

public class ReportsTest extends BasePageTest{


    @Test
    public void addReport() {
        ReportsPage reportsPage = new ReportsPage(driver);
        logInReport(ADMIN, PASSWORD_LOGIN);
        reportsPage.addReport("report number " + randomNumbers());
    }

    @Test
    public void deleteReport(){
        ReportsPage reportsPage = new ReportsPage(driver);
        logInReport(ADMIN, PASSWORD_LOGIN);
        reportsPage.deleteReport();
        assertTrue(reportsPage.validationMessage());

    }

    @Test
    public void notDeleteReport() {
        ReportsPage reportsPage = new ReportsPage(driver);
        logInReport(ADMIN, PASSWORD_LOGIN);
        reportsPage.notDeleteReport();
    }

    @Test
    public void modifyNameReport()  {
        ReportsPage reportsPage = new ReportsPage(driver);
        logInReport(ADMIN, PASSWORD_LOGIN);
        reportsPage.modifyReport("etc");
    }

    @Test
    public void searchNameReport(){
        ReportsPage reportsPage = new ReportsPage(driver);
        logInReport(ADMIN, PASSWORD_LOGIN);
        reportsPage.SearchReport("All");
        assertTrue(reportsPage.validationMessageReport());
    }

}
