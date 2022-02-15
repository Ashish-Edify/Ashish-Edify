package test.java;
import main.java.pageEvents.LoginPageEvents;
import main.java.pageEvents.ViolationSearchEvents;
import org.testng.annotations.Test;

public class ViolationSearch extends BaseTest
{
    ViolationSearchEvents violation = new ViolationSearchEvents();
    LoginPageEvents login = new LoginPageEvents();
        @Test
        public void navigateToViolationPage() throws InterruptedException
        {

            login.enterUsernamePassword();
            login.clickOnSubmitButton();
            violation.navigateToViolationSearchTab();
            violation.verifyViolationPageTitle();
        }
        @Test
        public void violationTypeSearch() throws InterruptedException
        {
            login.enterUsernamePassword();
            login.clickOnSubmitButton();
            Thread.sleep(5000);
            violation.navigateToViolationSearchTab();
            violation.selectViolationType();
            violation.clickOnViolaitionSearch();
        }
        @Test
        public void setViolation() throws InterruptedException
        {
            login.enterUsernamePassword();
            login.clickOnSubmitButton();
            Thread.sleep(5000);
            violation.navigateToViolationSearchTab();
            violation.selectViolationType();
            violation.clickOnViolaitionSearch();
            violation.click360Propertyview();
        }
}
