package com.automationpractice.search;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import net.timeandtraining.framework.TestBase;
import net.timeandtraining.framework.UI;

public class SearchTest extends TestBase{
	
	public void TC001_Price_Range_Search() {
		
	}
	
	@Test(enabled=false)
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

	@Test(enabled=false)
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
	@Test(enabled=false)
	public void TC004_Simple_negative_search() {
		// Go to http://www.automationpractice.com
		UI.openURL("http://www.automationpractice.com");
		// Enter 'invalid' in search text box on top
		UI.enterTextById("search_query_top", "invalid");
		// Now, press Enter using keyboard
		WebElement search_input = driver.findElement(By.xpath("//input[@id='search_query_top']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(search_input).sendKeys(Keys.ENTER).build().perform();
		// Verify text: 'No results were found for your search "invalid"' displayed on the page
		UI.verifyByXpath("//p[contains(text(), 'No results were')]");
		
	}
	@Test(enabled=false)
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
	@Test(enabled=false)
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
	@Test(enabled=true)
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
	@Test(enabled=false)
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
