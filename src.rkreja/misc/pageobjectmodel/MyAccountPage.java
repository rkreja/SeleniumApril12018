package misc.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.timeandtraining.framework.UI;

public class MyAccountPage {
	
	
	private WebDriver driver;
	
	public @FindBy(xpath="//a[descendant::span[text()='Order history and details' and ancestor-or-self::ul[@class='myaccount-link-list']]]") WebElement button_order_history;
	public @FindBy(xpath="//a[descendant::span[text()='My credit slips' and ancestor-or-self::ul[@class='myaccount-link-list']]]") WebElement button_my_credit_slips;
	public @FindBy(xpath="//a[descendant::span[text()='My addresses' and ancestor-or-self::ul[@class='myaccount-link-list']]]") WebElement button_my_addresses;
	public @FindBy(xpath="//a[descendant::span[text()='My personal information' and ancestor-or-self::ul[@class='myaccount-link-list']]]") WebElement button_personal_information;
	
	public MyAccountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean elementDisplayed(WebElement e) {
		return UI.isElementVisible(e);
	}
	
	public void clickOnMyCreditSlips() {}
	public void clickOnMyOrderHistry() {}
	public void clickOnMyAddress() {}
	public void clickOnMyPersonalInformation() {}
	public void clickOnMyWishLists() {}
	public void signOut() {}
	public void clickOnMyName() {}
	
}
