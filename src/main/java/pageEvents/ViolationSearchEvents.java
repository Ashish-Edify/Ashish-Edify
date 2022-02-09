package main.java.pageEvents;

import main.utils.ElementFetch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static main.PageObjects.ViolationPageElements.*;
import static main.utils.Constants.violationSearch;
import static test.java.BaseTest.driver;

public class ViolationSearchEvents {

    public void navigateToViolationSearchTab() throws InterruptedException {
        driver.get(violationSearch);
        Thread.sleep(3000);
    }

    public void verifyViolationPageTitle(){
        String title=returnPageTitle(pageTitle,violationPageTitleAttribute);
        System.out.println("Page Title: "+title);
        Assert.assertTrue(title.equalsIgnoreCase("SEARCH-VIOLATION.HEADING-Search-Violation"),"Page title is verified");
        System.out.println("Landed on page Violation search");
    }

    public void navigateTo(String module){
        switch (module) {
            case "violationSearch":
                driver.get(violationSearch);
        }
    }

    public String returnPageTitle(String xpath,String attributeName){
        String title=driver.findElement(By.xpath(xpath)).getAttribute(attributeName);
        return title;
    }
}
