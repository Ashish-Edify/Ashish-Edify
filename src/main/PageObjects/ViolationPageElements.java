package main.PageObjects;

public interface ViolationPageElements {
    String pageTitle="//span[@translate='SEARCH-VIOLATION.HEADING-Search-Violation']";
    String violationPageTitleAttribute="translate";
    String violation="violation";
    String search="//li[@id='liViolation']//ul//li";
    String violationSearchOption="//li[@id='liViolation']//ul//li//ul//li";
    String violationTypecheckbox="//input[@type='checkbox' and @name='chkViolationDetailsFreeze']";
    String violationSearchButton="btnSearchViolation";
}
