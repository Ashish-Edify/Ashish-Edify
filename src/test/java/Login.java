package test.java;


import main.java.pageEvents.LoginPageEvents;
import org.testng.annotations.Test;

public class Login extends BaseTest{
    @Test
    public void loginPage() throws InterruptedException {
        LoginPageEvents loginPageEvents= new LoginPageEvents();
        loginPageEvents.verifyLoginPageAvailable();
        loginPageEvents.enterUsernamePassword();
        loginPageEvents.clickOnSubmitButton();

    }


}
