package main.java.pageEvents;

import main.PageObjects.LoginPageElements;
import main.utils.ElementFetch;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.sql.Time;

public class LoginPageEvents {
WebDriverWait wait;
    public void verifyLoginPageAvailable(){
        ElementFetch elementFetch=new ElementFetch();
        Assert.assertTrue(elementFetch.getWebElements("XPATH",LoginPageElements.loginText).size()>0);
    }

    public void clickOnSubmitButton() throws InterruptedException {
        ElementFetch elementFetch=new ElementFetch();
        Thread.sleep(10000);
        elementFetch.getWebElement("XPATH", LoginPageElements.submitButton).click();
        //wait(10000);
    }

    public void enterUsernamePassword(){
        ElementFetch elementFetch=new ElementFetch();
        //elementFetch.waitFunction(LoginPageElements.userName,"xpath");
        elementFetch.getWebElement("XPATH",LoginPageElements.userName).sendKeys("msi@matteson.org");
        elementFetch.getWebElement("XPATH",LoginPageElements.password).sendKeys("MsiTesting1");
    }
}
