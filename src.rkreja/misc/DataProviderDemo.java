package misc;

import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rkreja.Excel;

import net.timeandtraining.framework.TestBase;
import net.timeandtraining.framework.UI;

public class DataProviderDemo extends TestBase{
	
	
	
	
	
	@DataProvider(name="testdata")
	public String[][] getTestData(){
		return new String[][]{
				{"10911","Bear Mountain"},
				{"10912","Bellvale"}
		};
		
	}
	
	@Test
	public void verifyCityNameByZipCode() {		
		
		Excel xl = new Excel("C:\\Users\\rkreja\\Documents\\ny_zipcodes.xlsx", "Sheet1");
		
		List<String> zipcodes=xl.getAllRowValuesByColumn(1);
		List<String> cities=xl.getAllRowValuesByColumn(2);		
		
		
		UI.openURL("http://www.vmoving.org/movers-zipcode.php");
		for(int i=0; i<zipcodes.size();i++) {
			UI.enterTextByName("zip", zipcodes.get(i));
			UI.clickByXpath("//a[text()='search']");
			String text=UI.findelementByTagName("h1").getText();
			UI.report(true, text.contains(zipcodes.get(i)) && text.contains(cities.get(i)), "Veryify City name is "+cities.get(i)+" for Zipcode: "+zipcodes.get(i));
			UI.openURL("http://www.vmoving.org/movers-zipcode.php");
		}
	
	
	}
	
	
	@Test(description="using data provider", dataProvider="testdata")
	public void verifyCityNameByZipCode2(String zipcode,String city) {			
	
		
		UI.openURL("http://www.vmoving.org/movers-zipcode.php");
		UI.enterTextByName("zip", zipcode);
		UI.clickByXpath("//a[text()='search']");
		String text=UI.findelementByTagName("h1").getText();
		UI.report(true, text.contains(zipcode) && text.contains(city), "Veryify City name is "+city+" for Zipcode: "+zipcode);
	
	
	}
	
	

}
