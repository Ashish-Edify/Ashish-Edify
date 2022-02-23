package main.java.pageEvents;

import main.utils.ElementFetch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static main.PageObjects.ViolationPageElements.*;
import static main.utils.Constants.violationSearch;
import static test.java.BaseTest.driver;

public class ViolationSearchEvents {
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

    public void clickOnDropdown() throws InterruptedException {
        Thread.sleep(10000);
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(violationTypeBox)));
        element.getWebElement("XPATH",violationTypeBox).click();
        List<WebElement> currencies = element.getWebElements("XPATH","//*[@options='ViolationDropDown']//ul//li");
        for (WebElement option : currencies) {
          System.out.println("Text :" + option.getText());
            if(currencies.contains("Building Code")){
                System.out.println("Found: " );
            }
        }
    }

}