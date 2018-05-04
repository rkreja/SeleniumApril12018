package misc.pageobjectmodel;

import org.openqa.selenium.WebDriver;

import net.timeandtraining.framework.UI;

public class AutomationPracticeApplication {
	
	@SuppressWarnings("unused")
	private WebDriver driver;

	public HomePage launch(WebDriver driver, String url) {
		this.driver=driver;
		UI.openURL(url);
		return new HomePage(driver);
	}
	
	
	
}
