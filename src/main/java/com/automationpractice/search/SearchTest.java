package com.automationpractice.search;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.automationpractice.com.pages.HomePage;
import com.automationpractice.com.pages.PageManager;
import com.rkreja.Util;

import net.timeandtraining.framework.TestBase;
import net.timeandtraining.framework.UI;

public class SearchTest extends TestBase{
	
	
	@Test
	public void TC001_Price_Range_Search() {
		
//		Go to http://www.automationpractice.com
		UI.openURL("http://www.automationpractice.com");
//		Click on DRESSES button
		HomePage homepage = new HomePage();
		homepage.clickDressesTab();
		
//		slide the price range between $20.00 to $40.00
		WebElement left_slide_button=UI.findelementByXpath("(//a[parent::div[@id='layered_price_slider']])[1]");				
		Actions actions = new Actions(driver);
		actions.dragAndDropBy(left_slide_button, 30, 0).build().perform();		
		WebElement right_slide_button=UI.findelementByXpath("(//a[parent::div[@id='layered_price_slider']])[2]");		
		actions.dragAndDropBy(right_slide_button, -70, 0).build().perform();
		
//		Verify product listed on right side with price ranges are between $20 to $40 only
		
		Util.sleep(2000);
		
		
		List<WebElement> price_holder_elements=driver.findElements(By.xpath("//span[@class='price product-price']"));
		
		for(WebElement e:price_holder_elements) {
			
			if(e.getText().equals("")) {
				
			}else {
				String price=e.getText().replace("$", "");
				Double d=Double.parseDouble(price);
				System.out.println(d);
				System.out.println(d>20);
				System.out.println(d<40);
				
				UI.report(d>20 && d<40 , true, "Verify price ranges are between 20 to 40. Found: "+ d);
				
				
			}
			
			
		}
		
		
		
		
	}
	

	
	@Test
	public void TC002_Prdouct_quick_view() {
		
		
		// Go to http://www.automationpractice.com
		UI.openURL("http://www.automationpractice.com");
		// Click on the 'EYE' icon of the product that has text has 'Printed Dress' and price is $26.00
		UI.clickByXpath("(//img[@title='Printed Dress'])[1]");
		// Verify popup opened
		// Verify text displayed 'Printed Dress' on top
		UI.verifyByXpath("//h1[contains(text(),'Printed Dress')]");
		// Verify price is $26.00
		UI.verifyByXpath("//span[@id='our_price_display']");
		// Verify social media button appears for 'Twitter', 'Facebook', 'Google+' and "Pinterest'
		UI.verifyByXpath("//button[@class='btn btn-default btn-twitter']");
		UI.verifyByXpath("//button[@class='btn btn-default btn-facebook']");
		UI.verifyByXpath("//button[@class='btn btn-default btn-google-plus']");
		UI.verifyByXpath("//button[@class='btn btn-default btn-pinterest']");
		// mouse hover over both thumbnail and verify image changes on top after hovering
		UI.mouseHover(UI.findelementByXpath("//img[@id='thumb_8']"));
		UI.mouseHover(UI.findelementByXpath("//img[@id='thumb_9']"));
		// close the popup
		
	}
	
	
	@Test(description="built by reja to show how to use arraylist and for loop")
	public void TC003_Product_img_view2() {
//		Go to http://automationpractice.com/index.php?id_product=7&controller=product
		UI.openURL("http://automationpractice.com/index.php?id_product=7&controller=product");
//		Verify there are 4 thumbnail on the page
//		click on the first thumbnail
//		verify popup displayed to slideshow
//		close the popup
//		Click next button and verify image changes, do the same for four images
		
				
		List<WebElement> thubmnails=driver.findElements(By.xpath("//img[contains(@id,'thumb')]"));		
		
//		thubmnails.get(0).click();
//		thubmnails.get(1).click();
//		thubmnails.get(2).click();
//		thubmnails.get(3).click();
		
//		for(WebElement element:thubmnails) {
//			element.click();	
//			
//			UI.clickByXpath("//a[@title='Close']");
//		}
		
		
		for (int i = 0; i < thubmnails.size(); i++) {
			
			thubmnails.get(i).click();
			
			switch (i) {
			case 0:
				//verify big image with 20 				
				UI.report(true, UI.isElementVisible(UI.findelementByXpath("//img[contains(@src,'/20')]")), "Verifying image number: 20");	
				
				break;
			case 1:
				//verify big image with 21 
				UI.report(true, UI.isElementVisible(UI.findelementByXpath("//img[contains(@src,'/21')]")), "Verifying image number: 21");
				break;
			case 2:
				//verify big image with 22 
				UI.report(true, UI.isElementVisible(UI.findelementByXpath("//img[contains(@src,'/22')]")), "Verifying image number: 22");
				break;
			case 3:
				//verify big image with 23 
				UI.report(true, UI.isElementVisible(UI.findelementByXpath("//img[contains(@src,'/23')]")), "Verifying image number: 23");
				break;


			}
			
			UI.clickByXpath("//a[@title='Close']");
		}
		
		
		
		
	}
	
	@Test
	public void TC003_Product_img_view() {
		// Go to http://automationpractice.com/index.php?id_product=7&controller=product
		UI.openURL("http://automationpractice.com/index.php?id_product=7&controller=product");
		// Verify there are 4 thumbnail on the page
		UI.verifyByXpath("//button[@class='btn btn-default btn-twitter']");
		UI.verifyByXpath("//button[@class='btn btn-default btn-facebook']");
		UI.verifyByXpath("//button[@class='btn btn-default btn-google-plus']");
		UI.verifyByXpath("//button[@class='btn btn-default btn-pinterest']");
		// click on the first thumbnail
		UI.clickByXpath("//button[@class='btn btn-default btn-twitter']");
		// verify popup displayed to slideshow
		UI.verifyByXpath("//p[contains(text(), 'Get instant updates from')]");
		UI.verifyByXpath("//h2[contains(text(), 'What’s happening?')]");
		// Click next button and verify image changes, do the same for four images
		UI.mouseHover(UI.findelementByXpath("//img[@id='thumb_20']"));
		UI.mouseHover(UI.findelementByXpath("//img[@id='thumb_21']"));
		UI.mouseHover(UI.findelementByXpath("//img[@id='thumb_22']"));
		UI.mouseHover(UI.findelementByXpath("//img[@id='thumb_23']"));
		
		
		// close the popup
	}
	@Test
	public void TC004_Simple_negative_search() {
		// Go to http://ww.w.automationpractice.com
		UI.openURL("http://www.automationpractice.com");
		// Enter 'invalid' in search text box on top
		UI.enterTextById("search_query_top", "invalid");
		// Now, press Enter using keyboard
		WebElement search_input = driver.findElement(By.xpath("//input[@id='search_query_top']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(search_input).sendKeys(Keys.ENTER).build().perform();
		// Verify text: 'No results were found for your search "invalid"' displayed on the page
		UI.verifyByXpath("//p[contains(text(), 'No results weres')]");
		
	}
	@Test
	public void TC005_view_grid_and_list() {
		// Go to http://www.automationpractice.com
		UI.openURL("http://www.automationpractice.com");
		// Enter 'Summer' in search text box on top Now, press Enter using keyboard
		UI.enterTextById("search_query_top", "Summer");
		WebElement search_input = driver.findElement(By.xpath("//input[@id='search_query_top']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(search_input).sendKeys(Keys.ENTER).build().perform();
		// Verify text: '4 results have been found.' on top right of the content
		UI.verifyByXpath("//span[contains(text(), '4 results have been found')]");
		// Verify text: 'Showing 1 - 4 of 4 items' displayed
		UI.verifyByXpath("(//div[contains(text(), '4 item')])[1]");
		// Click on 'Grid' icon from top right of panel
		UI.clickByXpath("//i[@class='icon-th-large']");
		// Verify images are displaying as Grid
		
		// Click on 'List' icon now
		UI.clickByXpath("//i[@class='icon-th-list']");
		// Verify images are displaying as list now
		}
	@Test
	public void TC006_valid_grid_and_list() {
		// Go to http://www.automationpractice.com
		UI.openURL("http://www.automationpractice.com");
		// Enter 'Dress' in search text box on top
		UI.enterTextById("search_query_top", "Dress");
		// Click on search button icon
		UI.clickByXpath("//button[@name='submit_search']");
		// Select Price: Lowest first option from Sort By Dropdown
		UI.DropDown_SelectItemByVisibleText(UI.findelementById("selectProductSort"), "Price: Lowest first");
		// Verify the first product price is: $16.51
		UI.verifyByXpath("(//span[contains(text(), '16.51')])[3]");
		// Select Price: Highest first option from Sort By Dropdown
		UI.DropDown_SelectItemByVisibleText(UI.findelementById("selectProductSort"), "Price: Highest first");
		// Verify the first product price is: $50.99
		UI.verifyByXpath("(//span[contains(text(), '50.99')])[3]");
		// Select Product name: A to Z option from Sort By Dropdown
		UI.DropDown_SelectItemByVisibleText(UI.findelementById("selectProductSort"), "Product Name: A to Z");
		// Verify the first product name is: Blouse
		UI.verifyByXpath("(//a[@title='Blouse'])[2]");
		// Select Product name: Z to A option from Sort By Dropdown
		UI.DropDown_SelectItemByVisibleText(UI.findelementById("selectProductSort"), "Product Name: Z to A");
		// Verify the first product name is: Printed Summer Dress
		UI.verifyByXpath("(//a[contains(text(), 'Printed Summer Dress')])[3]");
		// Select 'In Stock' option now from Sort By Dropdown
		UI.DropDown_SelectItemByVisibleText(UI.findelementById("selectProductSort"), "In stock");
		// Verify 'In Stock' green button appears for all displayed product
		}
	@Test
	public void TC007_search_auto_suggestion() {
		// Go to http://www.automationpractice.com
		UI.openURL("http://www.automationpractice.com");
		// Enter 'Chif' in search text box on top
		UI.enterTextByXpath("//input[@id='search_query_top']", "Chif");
//		WebElement search_text = driver.findElement(By.xpath("//input[@id='search_query_top']"));
//		Actions actions = new Actions(driver);
//		actions.moveToElement(search_text).sendKeys(Keys.SPACE).build().perform();
		// Verify 'Summer Dresses > Printed Chifton Dress' option get suggested in search textbox with 'Chif' in bold
		UI.verifyByXpath("//strong[contains(text(), 'Chif')]");
	}
	@Test
	public void TC008_search_with_filter() {
		// Go to http://www.automationpractice.com
		UI.openURL("http://www.automationpractice.com");
		// Mouse hover over 'Women' menu
		UI.mouseHover(UI.findelementByXpath("//a[@title='Women']"));
		// Click on 'Summer Dresses' Under Dresses section
		UI.clickByXpath("(//a[@title='Summer Dresses'])[1]");
		// Click on 'White' option from left panel under color
		UI.clickByXpath("//input[@name='layered_id_attribute_group_8']");
		// Verify text: There is 1 product displayed on right side
		UI.verifyByXpath("//div[contains(text(), 'Showing 1 - 1 of 1 items')]");
		// verify enabled filters option also displayed on left side with 'X' button
		UI.verifyByXpath("//span[contains(text(), 'Enabled filters')]");
		// Click on 'X' button from enabled filters
		UI.clickByXpath("//i[@class='icon-remove']");
		// Verify text: There is 3 product displayed on right side
		UI.verifyByXpath("//span[contains(text(), 'There are 3 products.')]");
	}
}
