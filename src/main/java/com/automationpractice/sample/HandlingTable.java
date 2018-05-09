package com.automationpractice.sample;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import net.timeandtraining.framework.TestBase;
import net.timeandtraining.framework.UI;

public class HandlingTable extends TestBase{
		
	@Test
	
	public void compareValuesInTableColumns() {
		// Go to http://www.automationpractice.com
		UI.openURL("http://www.automationpractice.com");
		// Click Sign in button from top right corner of the page
		UI.clickByXpath("//a[@class='login' and @title='Log in to your customer account']");
		// Enter valid email address 'abc213@mailinator.com' in email address text field of right side
		UI.enterTextByXpath("//input[@id='email']", "abc213@mailinator.com");
		// Enter invalid password 'myinvalidpwd' in password text field
		UI.enterTextById("passwd", "abc1234");
		// Click 'Sign in' button
		UI.clickByXpath("//button[@id='SubmitLogin']");
		
		
		//http://automationpractice.com/index.php?fc=module&module=blockwishlist&controller=mywishlist
		
		
		
		WebElement row=driver.findElement(By.xpath("(//tr[contains(@id,'wishlist')])[2]"));
		
		List<WebElement> columns=row.findElements(By.tagName("td"));
		
		//Util.getTodaysDate();
		
		
		
		UI.report(true, columns.get(0).getText().equals("My Winter Shopping"), "Verify new wish list created with name = 'My Winter Shopping'");
		
		System.out.println(columns.get(0).getText());
		System.out.println(columns.get(1).getText());
		System.out.println(columns.get(2).getText());
		System.out.println(columns.get(3).getText());
		System.out.println(columns.get(4).getText());
		
		//delete
		columns.get(5).findElement(By.tagName("a")).click();

}
	
	
	@Test
	
	public void compareValuesInTableColumns2() {
		// Go to http://www.automationpractice.com
		UI.openURL("http://www.automationpractice.com");
		// Click Sign in button from top right corner of the page
		UI.clickByXpath("//a[@class='login' and @title='Log in to your customer account']");
		// Enter valid email address 'abc213@mailinator.com' in email address text field of right side
		UI.enterTextByXpath("//input[@id='email']", "abc213@mailinator.com");
		// Enter invalid password 'myinvalidpwd' in password text field
		UI.enterTextById("passwd", "abc1234");
		// Click 'Sign in' button
		UI.clickByXpath("//button[@id='SubmitLogin']");
		
		
		
		//
		
		WebElement left_div=driver.findElement(By.xpath("//ul[@class='address first_item item box']"));
		WebElement right_div=driver.findElement(By.xpath("//ul[@class='address last_item alternate_item box']"));
		
		List<WebElement> all_left_li_tags=left_div.findElements(By.tagName("li"));
		List<WebElement> all_right_li_tags=right_div.findElements(By.tagName("li"));
		
		for(int i=1; i<all_left_li_tags.size();i++) {	
			
			System.out.println(all_left_li_tags.get(i).getText());
			System.out.println(all_right_li_tags.get(i).getText());
			
			String temp=all_left_li_tags.get(i).getText();			
			UI.report(true,all_right_li_tags.get(i).getText().equals(temp), "Verifying address for line number: "+ i + " " +  temp );
			
		}
			
		

}
	
}
