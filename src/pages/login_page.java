package pages;

import main.java.pageEvents.LoginPageEvents;

public class login_page {


    public void login() throws InterruptedException {
        LoginPageEvents loginPageEvents= new LoginPageEvents();
        loginPageEvents.verifyLoginPageAvailable();
        loginPageEvents.enterUsernamePassword();
        loginPageEvents.clickOnSubmitButton();

    }

}
