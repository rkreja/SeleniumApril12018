package net.timeandtraining.framework;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestBase {
	
	public static WebDriver driver;
	
	
	private static ExtentReports extent;
    private static ThreadLocal parentTest = new ThreadLocal();
    private static ThreadLocal test = new ThreadLocal();
    
    public static ExtentTest reporter;
    
    
    
    private static Properties getConfigProperty() {
    	Properties properties = new Properties();
    	try {
			properties.load(new FileReader(new File("config.properties")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	
    	return properties;
    }
	

	
	@BeforeSuite
	public static void init() {
		
		
		String browser=(String) getConfigProperty().get("BROSWER");
		
		
		//#INTERNET_EXPLORER, FIREFOX, SAFARI, CHROME
		switch (browser) {
		
		
		
		case "INTERNET_EXPLORER":
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\lib\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
			
			
		case "FIREFOX":
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\lib\\IEDriverServer.exe");
			driver = new FirefoxDriver();
			break;
			
			
		case "CHROME":
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\lib\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
			

		default:
			reporter.fatal("Invalid browser name was given");
			System.exit(1);
			break;
		}
		
		
		
		
	

				
	
		
		String implicit_wait=(String) getConfigProperty().get("IMPLICIT_WAIT");
		String explicit_wait=(String) getConfigProperty().get("EXPLICIT_WAIT");
		
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(implicit_wait), TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(explicit_wait), TimeUnit.MINUTES);
		
		
		
		extent = ExtentManager.createInstance("extent.html");
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
		extent.attachReporter(htmlReporter);

	}

	 @BeforeClass
	    public synchronized void beforeClass() {
	        ExtentTest parent = extent.createTest(getClass().getName());
	        parentTest.set(parent);
	  }

	

	@AfterSuite
	public static void closeBrowser() {
		driver.close();
		driver.quit();
	}
	
	

   

    @BeforeMethod
    public synchronized void beforeMethod(Method method) {    	
    	ExtentTest child = ((ExtentTest) parentTest.get()).createNode(method.getName());    
    	
    	test.set(child);
        reporter=child;
    }

    @AfterMethod
    public synchronized void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE)
            ((ExtentTest) test.get()).fail(result.getThrowable());
        else if (result.getStatus() == ITestResult.SKIP)
            ((ExtentTest) test.get()).skip(result.getThrowable());
        else
            ((ExtentTest) test.get()).pass("Test passed");

        extent.flush();
    }
	
	



}
