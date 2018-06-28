package net.timeandtraining.product;

import org.testng.annotations.Test;

import net.timeandtraining.framework.TestBase;
import net.timeandtraining.framework.UI;

public class ProductTests extends TestBase{
	

	
	@Test
	public void review_on_product() {
		
		//Go to http://www.automationpractice.com
		UI.openURL("http://www.automationpractice.com");
		//Click Sign in button from top right corner of the page
		
		UI.clickByXpath("//a[@class='login']");		
		
		//Enter valid email address 'abc213@mailinator.com' in email address text field of right side
		UI.enterTextById("email", "abc213@mailinator.com");
		//Enter valid password 'abc1234' in password text field
		UI.enterTextById("passwd", "abc1234");
		//Click 'Sign in' button
		UI.clickById("SubmitLogin");
		//Go to http://automationpractice.com/index.php?id_product=7&controller=product
		UI.navigate("http://automationpractice.com/index.php?id_product=7&controller=product");
		//Click on Write a review
		UI.clickByClassName("open-comment-form");
		//Click Send button without typing anything
		UI.clickById("submitNewMessage");
				
		//Verify 'Title is incorrect' text displayed
		UI.verifyByXpath("//li[text()='Title is incorrect']");
		//Verify 'Comment is incorrect' text displayed
		UI.verifyByXpath("//li[text()='Comment is incorrect']");
		
		//Enter 'Awesome dress' in title
		UI.enterTextById("comment_title", "Awesome dress");	
		
		//Enter 'Best purchase ever!!!' in Comment
		UI.enterTextById("content", "Best purchase ever!!!");
		//Click Send button
		UI.clickById("submitNewMessage");
		
//		Verify 'Your comment has been added and will be available once approved by a moderator' text displayed in popup
		UI.verifyElementHasText(UI.findelementByXpath("(//p[preceding-sibling::h2[text()='New comment']])[1]"), "Your comment has been added and will be available once approved by a moderator");
		
//		Click OK
		UI.clickByXpath("//button[@type='submit' and child::span[text()='OK']]");
		
		
//		Verify 'write a review' button gets appeared after few seconds*/			
		
		
			
		boolean b=true;
		int counter=1;
			while (b) {
			
				try {
					
					UI.findelementByXpath("//a[contains(text(),'Write a review')]");	
					System.err.println("element found");
					reporter.pass("'write a review' button gets appeared after few seconds");
					b=false;
	
				} catch (Exception e2) {
					
					UI.refreshPage();
					System.err.println("Refreshed "+counter+" time");
					counter+=1;
					
				}
				
				
			}
		
		
		/*
		//EXPLICIT WAIT
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Write a review')]")));
		*/
		
		
		
	//Updated test for git by Sajib
		
		
	}
	
	
	

}
