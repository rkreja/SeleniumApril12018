package net.timeandtraining.framework;

import org.testng.annotations.Test;

public class UITest extends TestBase{
	

	
	@Test
	public void login() {
		
		
//		Go to http://www.automationpractice.com
		UI.openURL("http://www.automationpractice.com");		
		
		UI.verifyByXpath("(//*[text()='Dresses'])[3]");

		
		
	}
	

}
