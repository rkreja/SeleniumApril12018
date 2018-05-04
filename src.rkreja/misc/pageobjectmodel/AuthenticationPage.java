package misc.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.timeandtraining.framework.UI;

public class AuthenticationPage{
	
	private WebDriver driver;
	private @FindBy(xpath="//a[@class='login' and @title='Log in to your customer account']") WebElement textfield_registerEmail;
	
	private @FindBy(xpath="//input[@id='emailx']") WebElement textfield_loginEmail;
	private @FindBy(id="passwd") WebElement textfield_password;
	
	private @FindBy(xpath="//button[@id='SubmitCreate']") WebElement button_createAccount;
	private @FindBy(xpath="//button[@id='SubmitLogin']") WebElement button_signIn;
	
	
	private @FindBy(xpath="(//a[@title='Women'])[1]") WebElement button_women;
	private @FindBy(xpath="(//a[@title='Dresses'])[2]") WebElement button_dresses;
	private @FindBy(xpath="(//a[@title='T-shirts'])[2]") WebElement button_tshirt;
	
	
	public AuthenticationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void signIn(String emailAddress, String password) {
		UI.enterTextByWebElement(textfield_loginEmail, emailAddress);
		UI.enterTextByWebElement(textfield_password, password);
		UI.clickByWebElement(button_signIn);
	}
	
	
	public boolean isErrorTextDisplayed(String expectedText) {
		WebElement e=UI.findelementByXpath("//div[contains(@class,'alert alert-danger')]");
		return e.getText().contains(expectedText);
	}
	
	
	
	

}
