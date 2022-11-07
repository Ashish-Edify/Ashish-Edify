package test.java;

import main.java.pageEvents.LoginPageEvents;
import main.java.pageEvents.ViolationSearchEvents;
import org.testng.annotations.*;

public class ViolationSearch extends BaseTest {
    ViolationSearchEvents violation = new ViolationSearchEvents();
    LoginPageEvents login=new LoginPageEvents();

        /*@Test
        public void navigateToViolationPage() throws InterruptedException {
            login.enterUsernamePassword();
            Thread.sleep(3000);
            login.clickOnSubmitButton();
            violation.navigateToViolationSearchTab();
            violation.verifyViolationPageTitle("Search Violations");
        }*/
        @Test
        public void violation_Test_Search_DropDown() throws InterruptedException {
            login.enterUsernamePassword();
            Thread.sleep(3000);
            login.clickOnSubmitButton();
            violation.navigateToViolationSearchTab();
            violation.VerifyUiTextValue("360 Property View");
            violation.clickOnDropdown("");
        }
       /* @Test
        public void search_For_Violation_Tecket() throws InterruptedException {
            login.enterUsernamePassword();
            Thread.sleep(3000);
            login.clickOnSubmitButton();
            violation.navigateToViolationSearchTab();
            violation.selectViolationType();
            violation.clickOnViolaitionSearch();
        }*/

}
