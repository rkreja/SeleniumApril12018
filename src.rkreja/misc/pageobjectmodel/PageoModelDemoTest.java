package misc.pageobjectmodel;

import org.testng.annotations.Test;

import net.timeandtraining.framework.TestBase;
import net.timeandtraining.framework.UI;

public class PageoModelDemoTest extends TestBase{
	
	
	@Test(testName="login with invalid id")	
	public void TC001_login_with_invalid_id() {
		
		// Go to http://www.automationpractice.com
		AutomationPracticeApplication app = new AutomationPracticeApplication();
		
		// Click Sign in button from top right corner of the page
		HomePage homepage=app.launch(driver, "http://www.automationpractice.com");
		
		
		
		// Enter invalid email address 'myunknowxaad@mailinator.com' in email address text field of right side
		// Click Sign in button
		AuthenticationPage auth_page=homepage.clickSignInButton();
		auth_page.signIn("myunknowxaad@mailinator.com", "");
		
		boolean result=auth_page.isErrorTextDisplayed("There is 1 error");
		UI.report(true, result, "Verify error message displayed 'There is 1 error'");
		
		result=auth_page.isErrorTextDisplayed("Password is required.");
		UI.report(true, result, "Verify error message displayed 'Verify error message displayed 'Password is required.'");
	
		
		
		MyAccountPage accountPage = new MyAccountPage(driver);
		accountPage.clickOnMyCreditSlips();
		
		
	}
	


}
