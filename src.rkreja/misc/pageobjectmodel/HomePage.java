package misc.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.timeandtraining.framework.UI;

public class HomePage {
	
	
	private WebDriver driver;
	
	
	private @FindBy(xpath="//a[@class='login' and @title='Log in to your customer account']") WebElement button_signin;
	
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	
	
	public AuthenticationPage clickSignInButton() {
		UI.clickByWebElement(button_signin);
		return new AuthenticationPage(driver);
	}
	
	
	
	
	
}
