package misc;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import net.timeandtraining.framework.TestBase;
import net.timeandtraining.framework.UI;

public class JavaScriptExecution extends TestBase{
	
	
	
	
	@Test
	public void clickByJavaScript() {
		
		UI.openURL("https://www.delta.com");
		
		//UI.clickByXpath("//a[@id='book-hotel-content-trigger']");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeAsyncScript("document.getElementById('searchTextHeader').style.backgroundColor=\"green\";");
		
		UI.getJavaScriptExecutor().executeAsyncScript("document.getElementById('book-hotel-content-trigger').click();");
		
		
	}
	

}
