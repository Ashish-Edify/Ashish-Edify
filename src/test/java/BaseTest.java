package test.java;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import main.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import static main.utils.Constants.password;
import static main.utils.Constants.username;

public class BaseTest {

    public static WebDriver driver;
    public ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest logger;
    public static WebDriverWait waiting;
    public static ExtentReports extents;





    @BeforeTest
    public void beforeTestMethod(){
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/reports/STMExtentReport.html");
        extent = new ExtentReports ();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", "SoftwareTestingMaterial");
        extent.setSystemInfo("Environment", "Automation Testing");
        extent.setSystemInfo("User Name", "Rajkumar SM");
        htmlReporter.config().setDocumentTitle("Title of the Report Comes here");
        htmlReporter.config().setReportName("Name of the Report Comes here");
       // htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
        extent=new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Automation Tester", "Edify Technology");

        /*htmlReporter=new ExtentHtmlReporter("E:\\reports");
        htmlReporter.config().setEncoding("uft-8");
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Automation Test Report");
        htmlReporter.config().setTheme(Theme.DARK);*/

    }




    @BeforeMethod
    @Parameters(value = {"browserName"})   //Browser value will be picking from testNG file and pass it here
    public void beforeMethod(String browserName, Method testMethod){
        logger=extent.createTest(testMethod.getName());
        setupDriver(browserName);
        driver.manage().window().maximize();
        driver.get(Constants.url);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //wait.until(ExpectedConditions.elementToBeClickable(By.name("username")));

    }



    @AfterMethod
    public void afterMethod(ITestResult result){
        if(result.getStatus()==ITestResult.SUCCESS){
            String methodName=result.getMethod().getMethodName();
            String logText= "Test Case" + methodName + "Passed";
            Markup m= MarkupHelper.createLabel(logText, ExtentColor.GREEN);
            logger.log(Status.PASS,m);
        }
        else if(result.getStatus()==ITestResult.FAILURE){
            String methodName=result.getMethod().getMethodName();
            String logText= "Test Case" + methodName + "Failed";
            Markup m= MarkupHelper.createLabel(logText, ExtentColor.RED);
            logger.log(Status.FAIL,m);
        }
        else {
            String methodName = result.getMethod().getMethodName();
            String logText = "Test Case" + methodName + "Skipped";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.ORANGE);
            logger.log(Status.SKIP, m);
        }
        driver.quit();
    }

    @AfterTest
    public void afterTestMethod(){
        extent.flush();

    }



    public WebDriver setupDriver(String browserName){
        if(browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ File.separator + "drivers" + File.separator + "chromedriver.exe");
            driver= new ChromeDriver();
        }
        else if (browserName.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+ File.separator + "drivers" + File.separator + "geckodriver.exe");
            driver= new FirefoxDriver();
        }
        else{
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ File.separator + "drivers" + File.separator + "chromedriver.exe");
            driver= new ChromeDriver();
        }
        return driver;

    }


}
