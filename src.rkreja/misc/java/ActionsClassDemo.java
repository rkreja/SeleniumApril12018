package misc.java;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import net.timeandtraining.framework.TestBase;

public class ActionsClassDemo extends TestBase{
	
	@Test
	private void mouseHover() {
		
		driver.get("http://automationpractice.com");
		
		WebElement dressImg = driver.findElement(By.xpath("(//img[@itemprop='image'])[1]"));		
		
		
		Actions actions = new Actions(driver);
		
		actions.moveToElement(dressImg).build().perform();		
		
	}
	
	@Test
	private void keyPress() {
		
		driver.get("http://automationpractice.com");		
		WebElement searchTextBox = driver.findElement(By.id("search_query_top"));
//		searchTextBox.sendKeys("Summer");					
		
		
		Actions actions = new Actions(driver);	
		actions.moveToElement(searchTextBox).sendKeys(Keys.TAB).sendKeys(Keys.TAB).build().perform();
		
	}
	@Test
	private void dargAndDrop() {
		
		driver.get("http://code.makery.ch/library/dart-drag-and-drop/");
		driver.switchTo().frame(1);
		
		WebElement img=driver.findElement(By.xpath("(//img[@class='document'])[1]"));
		WebElement drop=driver.findElement(By.xpath("//div[@class='trash']"));
		Actions actions = new Actions(driver);
		actions.dragAndDrop(img, drop).build().perform();		
		
	}

	
	
	

}
