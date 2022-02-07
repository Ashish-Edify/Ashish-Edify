package test.java;

import main.java.pageEvents.LoginPageEvents;
import main.java.pageEvents.ViolationSearchEvents;
import org.testng.annotations.Test;

public class ViolationSearch extends BaseTest {

        @Test
        public void violationSearch() throws InterruptedException {
            LoginPageEvents login = new LoginPageEvents();
            login.enterUsernamePassword();
            login.clickOnSubmitButton();
            Thread.sleep(3000);
            ViolationSearchEvents violation = new ViolationSearchEvents();
            violation.navigateToViolationSearchTab();
            Thread.sleep(5000);
            violation.verifyViolationPageTitle();
        }
}
