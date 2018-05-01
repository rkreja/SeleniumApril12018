package misc;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import net.timeandtraining.framework.TestBase;
import net.timeandtraining.framework.UI;

public class FileUpload extends TestBase{
	
	@Test
	public void fileUploadDemo() {
		
		UI.openURL("http://www.automationpractice.com");
		
		UI.enterTextById("fileUpload", "F:\\Time And Training\\Live Trainings\\fileUploadDemo.txt");
		
		driver.findElement(By.id("fileUpload")).sendKeys("F:\\\\Time And Training\\\\Live Trainings\\\\fileUploadDemo.txt");
		
	}

	

}
