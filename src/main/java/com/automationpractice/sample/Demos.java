package com.automationpractice.sample;

import org.sikuli.script.Screen;
import org.testng.annotations.Test;

import net.timeandtraining.framework.TestBase;
import net.timeandtraining.framework.UI;

public class Demos extends TestBase{
	
	
	
	
	@Test(description="Verify image using Sikuli in selenium test")
	public void imgTest() {
		
		UI.openURL("http://automationpractice.com/index.php");
		Screen screen = new Screen();
		// CHECK OBJECT EXISTS
		if(screen.exists("sikuli/img.PNG")==null) {
			reporter.fail("Image not exist");
			}else {
			UI.report(true, (screen.exists("sikuli/img.PNG")==null), "Verify image exist");
		}
		
		
	}

}
