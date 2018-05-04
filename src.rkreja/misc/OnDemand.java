package misc;

import org.testng.annotations.Test;

import net.timeandtraining.framework.TestBase;
import net.timeandtraining.framework.UI;

public class OnDemand extends TestBase{
	
	
	@Test
	public void inputTest() {
		
		UI.openURL("http://automationpractice.com");		
		String val_top="John";
		String val_bottom=UI.findelementById("firstname").getAttribute("value");
		
		
		
		
	}

}
