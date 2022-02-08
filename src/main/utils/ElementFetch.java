package main.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.java.BaseTest;

import java.util.List;

import static main.utils.Constants.violationSearch;
import static test.java.BaseTest.driver;
import static test.java.BaseTest.waiting;

public class ElementFetch {



    public WebElement getWebElement(String identifierType, String identifierValue){
        switch (identifierType){
            case "ID":
                return driver.findElement(By.id(identifierValue));
            case "CSS":
                return driver.findElement(By.cssSelector(identifierValue));
            case "TAGNAME":
                return driver.findElement(By.tagName(identifierValue));
            case "XPATH":
                return driver.findElement(By.xpath(identifierValue));
            case "CLASSNAME":
                return driver.findElement(By.className(identifierValue));
            case "LINKTEXT":
                return driver.findElement(By.linkText(identifierValue));
            default:
                return null;
        }

    }

    public List<WebElement> getWebElements(String identifierType, String identifierValue){
        switch (identifierType){
            case "ID":
                return driver.findElements(By.id(identifierValue));
            case "CSS":
                return driver.findElements(By.cssSelector(identifierValue));
            case "TAGNAME":
                return driver.findElements(By.tagName(identifierValue));
            case "XPATH":
                return driver.findElements(By.xpath(identifierValue));
            case "CLASSNAME":
                return driver.findElements(By.className(identifierValue));
            case "LINKTEXT":
                return driver.findElements(By.linkText(identifierValue));
            default:
                return null;
        }

    }

    public WebElement waitFunction(String identifierValue, String identifierType){

        waiting=new WebDriverWait(driver, 30);
        switch (identifierType) {
            case "xpath":
                return waiting.until(ExpectedConditions.elementToBeClickable(By.xpath("identifierValue")));
            case "id":
                return waiting.until(ExpectedConditions.elementToBeClickable(By.id(identifierValue)));
            case "className":
                return waiting.until(ExpectedConditions.elementToBeClickable(By.className(identifierValue)));
        }
        return null;
    }

    public void mouseOver(String identifierType,String identifier,String find){
        switch (identifierType) {
            case "xpath":
                switch (find){
                    case "element":
                        WebElement ele = driver.findElement(By.xpath(identifier));
                        Actions action = new Actions(driver);
                        action.moveToElement(ele).perform();
                    case "elements":
                        WebElement ele2 = driver.findElements(By.xpath(identifier)).get(0);
                        Actions action2 = new Actions(driver);
                        action2.moveToElement(ele2).perform();
                     }

                WebElement ele = driver.findElement(By.xpath(identifier));
                Actions action = new Actions(driver);
                action.moveToElement(ele).perform();
            case "id":
                WebElement ele1 = driver.findElement(By.id(identifier));
                Actions action1 = new Actions(driver);
                action1.moveToElement(ele1).perform();

        }

    }



}
