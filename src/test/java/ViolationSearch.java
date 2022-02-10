package test.java;

import main.java.pageEvents.LoginPageEvents;
import main.java.pageEvents.ViolationSearchEvents;
import org.testng.annotations.Test;

public class ViolationSearch extends BaseTest {
    ViolationSearchEvents violation = new ViolationSearchEvents();
        @Test
        public void navigateToViolationPage() throws InterruptedException {
            LoginPageEvents login=new LoginPageEvents();
            login.enterUsernamePassword();
            Thread.sleep(3000);
            login.clickOnSubmitButton();

            violation.navigateToViolationSearchTab();
            violation.verifyViolationPageTitle("Search Violations");
        }
        @Test
        public void violationSearchDropDown() throws InterruptedException {
            ViolationSearch search= new ViolationSearch();
            search.navigateToViolationPage();
            violation.getDropdownValue();

        }

}
