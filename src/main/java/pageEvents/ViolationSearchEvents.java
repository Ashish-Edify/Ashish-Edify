package main.java.pageEvents;

import main.utils.ElementFetch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static main.PageObjects.ViolationPageElements.*;
import static main.utils.Constants.violationSearch;
import static test.java.BaseTest.driver;

public class ViolationSearchEvents {
    WebDriverWait wait;
    ElementFetch element=new ElementFetch();

    public void navigateToViolationSearchTab() throws InterruptedException {
        Thread.sleep(5000);
        driver.get(violationSearch);
        Thread.sleep(5000);
    }

    public void verifyViolationPageTitle(String Pagetitle) throws InterruptedException {
        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String title=returnPageTitle(ViolationpageTitleXpath,violationPageTitleAttribute);
        System.out.println("Page Title: "+title);
        Assert.assertTrue(title.equalsIgnoreCase(Pagetitle),"Page title is not verified");
        System.out.println("Landed on page Violation search");
    }

    public void navigateTo(String module){
        switch (module) {
            case "violationSearch":
                driver.get(violationSearch);
        }
    }

    public String returnPageTitle(String xpath,String attributeName){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        String title=driver.findElement(By.xpath(xpath)).getText();
        return title;
    }

    public void selectViolationType(){
        element.getWebElement("xpath",violationTypecheckbox).click();
    }

    public void clickOnViolaitionSearch(){
        element.getWebElement("id",violationSearchButton).click();
    }

    public void getDropdownValue() throws InterruptedException {
        Thread.sleep(5000);
        Select s = new Select(driver.findElement(By.xpath("//select[@name=’selType’]")));
        List<WebElement> op = s.getOptions();
        int size = op.size();
        for(int i =0; i<size ; i++){
            String options = op.get(i).getText();
            System.out.println(options);
        }
    }

}
