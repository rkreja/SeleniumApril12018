package com.automationpractice.com.pages;

import org.openqa.selenium.By;

import net.timeandtraining.framework.UI;

public class HomePage extends MainTabs {
	



	private By button_signin = By.xpath("//a[@class='login']");
	
	
	private By element_dynamic_id_holder=By.xpath("//a[@href='#blockbestsellers']");
		
	
	public void clickSignInButton() {
		UI.clickByBy(button_signin);
	}
	

	
	public String getDynamicId() {
		return UI.getTextBy(element_dynamic_id_holder);
	}
	
	
	
	

		
	

}
