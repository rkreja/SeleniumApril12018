package com.automationpractice.com.pages;

import org.openqa.selenium.By;

import net.timeandtraining.framework.TestBase;
import net.timeandtraining.framework.UI;

public class MainTabs extends TestBase{
	
	private By button_tshirt=By.xpath("(//a[@title='T-shirts'])[2]");
	private By button_dresses=By.xpath("(//a[@title='Dresses'])[2]");
	private By button_searchicon = By.name("submit_search");
	private By textfield_search = By.id("search_query_top");
	
	
	

	public void clickTshirtTab() {
		UI.clickByBy(button_tshirt);
	}
	
	public void clickDressesTab() {
		UI.clickByBy(button_dresses);
	}

	
	public void search(String searchText) {
		UI.enterTextBy(textfield_search, searchText);
		UI.clickByBy(button_searchicon);
	}
}
