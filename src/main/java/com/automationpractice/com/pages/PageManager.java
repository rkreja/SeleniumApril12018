package com.automationpractice.com.pages;

public class PageManager {
	
	
	public static HomePage getHomePage() {		
		return new HomePage();		
	}
	
	public static Authentication getAuthenticationPage() {
		return new Authentication();
	}
	
	

}
