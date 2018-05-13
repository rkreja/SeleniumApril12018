package com.automationpractice.com.pages;

import org.openqa.selenium.By;

import net.timeandtraining.framework.UI;

public class Authentication extends MainTabs{
	
	private By textfield_userid=By.xpath("//input[@id='email']");
	private By textfield_password=By.id("passwd");
	private By button_login=By.xpath("//button[@id='SubmitLogin']");			
	private By element_error_msg_1=By.xpath("//li[parent::ol]");
	
	
	public void login(String userid, String password) {		
		UI.enterTextBy(textfield_userid, userid);
		UI.enterTextBy(textfield_password, password);
		UI.clickByBy(button_login);		
	}
		
	public String getErrorMsg() {
	return UI.getTextBy(element_error_msg_1);	
	}


}
