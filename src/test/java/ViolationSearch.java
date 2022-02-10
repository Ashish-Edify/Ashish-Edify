package test.java;

import main.java.pageEvents.LoginPageEvents;
import main.java.pageEvents.ViolationSearchEvents;
import org.testng.annotations.Test;

public class ViolationSearch extends BaseTest {
    ViolationSearchEvents violation = new ViolationSearchEvents();
        @Test
        public void navigateToViolationPage() throws InterruptedException {

            violation.navigateToViolationSearchTab();
            violation.verifyViolationPageTitle();
        }
        @Test
        public void violationTypeSearch(){
            violation.selectViolationType();
            violation.clickOnViolaitionSearch();
        }
}
