package com.automationpractice.registration;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import net.timeandtraining.framework.TestBase;
import net.timeandtraining.framework.UI;

public class Register_New_Account_Test extends TestBase{
	
		
	
	@Test
	public void TC001_Registration() {
		
			Random randomGenerator = new Random();  
			int randomInt = randomGenerator.nextInt(1000);
			
//			Go to http://www.automationpractice.com
			UI.openURL("http://www.automationpractice.com");
//			Click Sign in button from top right corner of the page
			UI.clickByXpath("//a[@class='login' and @title='Log in to your customer account']");
//			Enter email address 'abc@mailinator.com' in email address text field of left side
			UI.enterTextByXpath("//input[@id='email_create']", "abc@mailinator.com");
//			Click create an account button
			UI.clickByXpath("//button[@id='SubmitCreate']");
//			Verify error message displayed 'An account using this email address has already been registered. Please enter a valid password or request a new one.'
			UI.verifyByXpath("//li[contains(text(), 'An account using this email address')]");
			UI.verifyElementHasText(driver.findElement(By.xpath("//li[contains(text(), 'An account using this email address')]")), "An account using this email address has already been registered. Please enter a valid password or request a new one. ");
//			Enter a valid email address in email address text field. (You can use xxxxxxx@mailinator.com)
			UI.clearByXpath("//input[@id='email_create']");
			UI.enterTextByXpath("//input[@id='email_create']", "abcd"+ randomInt +"@gmail.com");
//			Click create an account button
			UI.clickByXpath("//button[@id='SubmitCreate']");
//			Click 'Register' button
			UI.clickByXpath("//button[@id='submitAccount']");
//			Verify error message displayed 'You must register at least one phone number.'
			UI.verifyByXpath("//li[text()='You must register at least one phone number.']");			
//			Verify error message displayed 'lastname is required.'
			UI.verifyByXpath("(//li[contains(text(),'is required')])[1]");
//			Verify error message displayed 'firstname is required.'
			UI.verifyByXpath("(//li[contains(text(),'is required')])[2]");
//			Verify error message displayed 'passwd is required.'
			UI.verifyByXpath("(//li[contains(text(),'is required')])[3]");
//			Verify error message displayed 'address1 is required.'
			UI.verifyByXpath("(//li[contains(text(),'is required')])[4]");
//			Verify error message displayed 'city is required.'
			UI.verifyByXpath("(//li[contains(text(),'is required')])[5]");
//			Verify error message displayed 'The Zip/Postal code you've entered is invalid. It must follow this format: 00000'
			UI.verifyByXpath("//li[contains(text(), 'An account using this email address')]");
//			Verify error message displayed 'This country requires you to choose a State.
			UI.verifyByXpath("//li[text()='This country requires you to choose a State.']");
//			Select 'Mr' radio button
			UI.clickByXpath("//input[@id='id_gender1']");
//			Enter First name as 'John'
			UI.enterTextByXpath("//input[@id='customer_firstname']", "John");
//			Enter Last name as 'Smith'
			UI.enterTextByXpath("//input[@id='customer_lastname']", "Smith");
//			Verify Email text box has email address defined as used in step 6
			UI.verifyByXpath("//input[@id='email']");			
//			Enter password as 'MyStrong_Password'
			UI.enterTextByXpath("//input[@id='passwd']", "123456");
//			Select day 15 from day dropdown
			UI.DropDown_SelectItemByValue(driver.findElement(By.id("months")), "15");
//			Select dropDown_day = new Select(driver.findElement(By.id("months")));
//			dropDown_day.selectByValue("15");
			
//			Select month September from month dropdown
			Select dropDown_month = new Select(driver.findElement(By.id("months")));
			dropDown_month.selectByValue("9");
			
//			Select year 1984 from year dropdown
			Select dropDown_year = new Select(driver.findElement(By.id("years")));
			dropDown_year.selectByValue("1984");
//			Verify First name text field below has first name defined as used in step 18
//			String firstname= driver.findElement(By.id("firstname")).getText();
//			Assert.assertEquals(firstname, "John");		
////		Verify First name text field below has last name defined as used in step 19
//			String lastname= driver.findElement(By.id("lastname")).getText();
//			Assert.assertEquals(lastname, "Smith");	
//			Enter Company as 'Time and Training' in Company text field
			driver.findElement(By.xpath("//input[@id='company']")).sendKeys("Time and Training");
//			Enter address as '123 abc street' in address text field
			driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("123 Street");
//			Enter city New York in city text field
			driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Brooklyn");
//			Select state New York from state drop down
			Select dropDown_state = new Select(driver.findElement(By.id("id_state")));
			dropDown_state.selectByValue("32");
//			Enter '10001' in Zip/Postal Code text field
			driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("10001");
//			Select country United States from country dropdown
			Select dropDown_country = new Select(driver.findElement(By.id("id_country")));
			dropDown_country.selectByValue("21");
//			Enter text 'Registering ac account with all fields' in Additional information text area
			driver.findElement(By.xpath("//textarea[@id='other']")).sendKeys("Registering ac account with all fields");
//			Enter '7031234567' in Home Phone text field
			driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("7031234567");
//			Enter Enter '7039876543214' in Mobile phone text field
			driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys("7039876543214");
//			Replace text 'My Address' to 'Home' in Assign an address alias for future reference text field
			driver.findElement(By.xpath("//input[@id='alias']")).sendKeys("My Address");
//			Click 'Register' button
			driver.findElement(By.xpath("//button[@id='submitAccount']")).click();
//			Verify 'MY ACCOUNT' text displayed
			String myAccount = driver.findElement(By.xpath("//h1[text()='My account']")).getText();
			Assert.assertEquals(myAccount, "MY ACCOUNT");
//			Verify 'Welcome to your account. Here you can manage all of your personal information and orders.' text displayed
			String WelcomeAccount = driver.findElement(By.xpath("//p[contains(text(),'Welcome to your account.')]")).getText();
			Assert.assertEquals(WelcomeAccount, "Welcome to your account. Here you can manage all of your personal information and orders.");
//			Verify 'My personal information' text displayed
			String MyPersonal = driver.findElement(By.xpath("//span[contains(text(),'My personal information')]")).getText();
			Assert.assertEquals(MyPersonal, "MY PERSONAL INFORMATION");
//			Click 'Sign out' button from top right corner
			driver.findElement(By.xpath("//a[text()='Sign out']")).click();
					
			
//			Select 'Mr' radio button
//			Enter First name as 'John'
//			Enter Last name as 'Smith'
//			Verify Email text box has email address defined as used in step 6
//			Enter password as 'MyStrong_Password'
//			Select day 15 from day dropdown
//			Select year 1984 from year dropdown
//			Select month September from month dropdown
//			Verify First name text field below has first name defined as used in step 18
//			Verify First name text field below has last name defined as used in step 19
//			Enter Company as 'Time and Training' in Company text field
//			Enter address as '123 abc street' in address text field
//			Enter city New York in city text field
//			Select state New York from state drop down
//			Enter '10001' in Zip/Postal Code text field
//			Select country United States from country dropdown
//			Enter text 'Registering ac account with all fields' in Additional information text area
//			Enter '7031234567' in Home Phone text field
//			Enter Enter '7039876543214' in Mobile phone text field
//			Replace text 'My Address' to 'Home' in Assign an address alias for future reference text field
//			Click 'Register' button
//			Verify 'MY ACCOUNT' text displayed
//			Verify 'Welcome to your account. Here you can manage all of your personal information and orders.' text displayed
//			Verify 'My personal information' text displayed
//			Click 'Sign out' button from top right corner
	}

}
