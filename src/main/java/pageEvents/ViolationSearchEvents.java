package main.java.pageEvents;
import main.utils.ElementFetch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import static main.PageObjects.ViolationPageElements.*;
import static main.utils.Constants.violationSearch;
import static test.java.BaseTest.driver;

public class ViolationSearchEvents
{
    WebDriverWait wait;
    ElementFetch element=new ElementFetch();

    public void navigateToViolationSearchTab() throws InterruptedException
    {
        Thread.sleep(5000);
        driver.get(violationSearch);
        Thread.sleep(3000);
    }

    public void verifyViolationPageTitle() throws InterruptedException
    {

        Thread.sleep(3000);
        String title=returnPageTitle(pageTitle,violationPageTitleAttribute);
        System.out.println("Page Title: "+title);
        Assert.assertTrue(title.equalsIgnoreCase("Search Violations"),"Page title is verified");
        System.out.println("Landed on page Violation search");
    }

    public void navigateTo(String module)
    {
        switch (module)
        {
            case "violationSearch":
                driver.get(violationSearch);
        }
    }

    public String returnPageTitle(String xpath,String attributeName)
    {
        wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        String title=driver.findElement(By.xpath(xpath)).getText();
        return title;
    }

    public void selectViolationType() throws InterruptedException
    {
        Thread.sleep(5000);
        element.getWebElement("xpath",violationTypecheckbox).click();
    }

    public void clickOnViolaitionSearch()
    {
        element.getWebElement("id",violationSearchButton).click();
    }

    public void click360Propertyview()
    {
        String propertyView = null;
        element.getWebElement("id", propertyView).click();
    }
}
