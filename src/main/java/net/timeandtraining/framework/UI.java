package net.timeandtraining.framework;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

public class UI extends TestBase {

	public static void openURL(String url) {					
		
		driver.get(url);
		reporter.log(Status.INFO, "Navigated to: " + url);
	}
	
	
	

	public static void navigate(String url) {
		driver.navigate().to(url);		
		reporter.log(Status.INFO, "Navigated to: " + url);
	}
	
	
	public static void refreshPage() {
		
		driver.navigate().refresh();
		reporter.log(Status.INFO, "Page refreshed.");
	}
	

	// FINDING ELEMENTS
	public static WebElement findelementById(String id) {
		WebElement e=null;
		try {
			e=driver.findElement(By.id(id));
		} catch (Exception e2) {
			reportFailWithScreenShot("Unable to identify element by id: "+ id);
		}
		return e;
	}

	public static WebElement findelementByName(String name) {
		WebElement e=null;
		try {
			e=driver.findElement(By.name(name));
		} catch (Exception e2) {
			reportFailWithScreenShot("Unable to identify element by name: "+ name);
		}
		return e;
	}

	public static WebElement findelementByXpath(String xpath) {
		WebElement e=null;
		try {
			e=driver.findElement(By.xpath(xpath));
		} catch (Exception e2) {
			reportFailWithScreenShot("Unable to identify element by xpath: "+ xpath);
		}
		return e;
	}

	public static WebElement findelementByClassName(String className) {
		WebElement e=null;
		try {
			e=driver.findElement(By.className(className));
		} catch (Exception e2) {
			reportFailWithScreenShot("Unable to identify element by class: "+ className);
		}
		return e;
	}

	// ALL THE METHODS HERE FOR CLICKS

	public static void clickByWebElement(WebElement e) {	
		String elementText="[BLANK]";
		if(e.getText().length()>1 && (!e.getText().contains("<"))) {
			elementText=e.getText();
		}
		e.click();
		reporter.log(Status.PASS, "Clicked on elemenet : " + elementText);
	}
	
	public static void clickById(String id) {

		findelementById(id).click();
		reporter.log(Status.PASS, "Clicked on elemenet by id: " + id);
	}

	public static void clickByClassName(String className) {
		findelementByClassName(className).click();
		reporter.log(Status.PASS, "Clicked on elemenet by class: " + className);
	}

	public static void clickByName(String name) {
		findelementByClassName(name).click();
		reporter.log(Status.PASS, "Clicked on elemenet by name: " + name);
	}

	public static void clickByXpath(String xpath) {
		findelementByXpath(xpath).click();
		reporter.log(Status.PASS, "able to click on elemenet by xpath: " + xpath);
	}

	// ALL THE METHODS HERE FOR SEND CLEAR
	public static void clearByWebElement(WebElement e) {
		e.clear();

	}
	public static void clearById(String id) {
		findelementById(id).clear();
	}

	public static void clearByXpath(String xpath) {
		findelementByXpath(xpath).clear();
	}

	// ALL THE METHODS HERE FOR SEND KEYS
	
	public static boolean isElementVisible(WebElement e) {
		boolean result=false;
		String waitTime=(String) TestBase.getConfigProperty().get("EXPLICIT_WAIT");
		WebDriverWait driverWait = new WebDriverWait(driver, Long.parseLong(waitTime));
		
		try {
			driverWait.until(ExpectedConditions.visibilityOf(e));
			result=true;
		} catch (Exception e2) {
			UI.reportFailWithScreenShot("Time out. Element: ["+ e + "] not gets visible");
		}
		return result;
	}
	
	public static void enterTextByWebElement(WebElement e, String text) {
		e.clear();
		e.sendKeys(text);
		reporter.log(Status.PASS, "Successfully entered text: " + text);
	}
	
	
	public static void enterTextById(String id, String text) {
		findelementById(id).sendKeys(text);
		reporter.log(Status.PASS, "Successfully entered text: " + text);
	}

	public static void enterTextByName(String Name, String text) {
		findelementByName(Name).sendKeys(text);
		reporter.log(Status.PASS, "Successfully entered text: " + text);
	}

	public static void enterTextByClassName(String ClassName, String text) {
		findelementByClassName(ClassName).sendKeys(text);
		reporter.log(Status.PASS, "Successfully entered text: " + text);
	}

	public static void enterTextByXpath(String xpath, String text) {
		findelementByXpath(xpath).sendKeys(text);
		reporter.log(Status.PASS, "Successfully entered text: " + text);
	}

	// ALL THE METHODS HERE FOR SELECT DROP DOWN

	public static void DropDown_SelectItemByVisibleText(WebElement dropDownElement, String item) {
		Select dropdown = new Select(dropDownElement);
		dropdown.selectByVisibleText(item);
		reporter.log(Status.INFO, item + " selected in dropdown");

	}

	public static void DropDown_SelectItemByValue(WebElement dropDownElement, String value) {
		Select dropdown = new Select(dropDownElement);
		dropdown.selectByValue(value);
		reporter.log(Status.INFO, value + " selected in dropdown");
	}

	// ALL THE METHODS HERE FOR ACTIONS

	public static void mouseHover(WebElement e) {
		Actions actions = new Actions(driver);
		actions.moveToElement(e).build().perform();
		reporter.log(Status.INFO, "Mouse hovered on element by: " + e.getText());
	}

	// ALL THE METHODS HERE FOR VERIFICATION

	public static void verifyByXpath(String xpath) {
		boolean result = false;
		result = findelementByXpath(xpath).isDisplayed() || findelementByXpath(xpath).isEnabled();

		if (result) {
			reporter.pass("Element is displayed. Found by xpath: " + xpath);
		} else {
			reportFailWithScreenShot("Element not displayed. Tried to find by xpath: " + xpath);
		}

	}


	public static void verifyById(String id) {
		boolean result = false;
		result = findelementById(id).isDisplayed() || findelementById(id).isEnabled();

		if (result) {
			reporter.pass("Element is displayed. Found by id: " + id);
		} else {
			reportFailWithScreenShot("Element not displayed. Tried to find by id: " + id);
		}

	}

	public static void verifyElementHasText(WebElement e, String text) {
		boolean result = false;
		result = e.getText().contains(text);
		if (result) {
			reporter.pass("Text [" + text + "] found in element");
		} else {
			reportFailWithScreenShot("Text [" + text + "] found in element");
			
			
		}
	}
	

	
	private static void reportFailWithScreenShot(String desc) {
		
		reporter.fail(desc);		
		TakesScreenshot sc =(TakesScreenshot) driver;
			try {
				File file=sc.getScreenshotAs(OutputType.FILE);
				String path=System.getProperty("user.dir") + "\\screenshot\\"+ System.currentTimeMillis()+".png";
				FileUtils.copyFile(file, new File(path));
				reporter.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static <T> void  report(T expectedResult, T actualResult, String desscription) {
		if(expectedResult.equals(actualResult)) {
			reporter.pass(desscription);
		}else {
			reportFailWithScreenShot(desscription);
		}
	}

}
