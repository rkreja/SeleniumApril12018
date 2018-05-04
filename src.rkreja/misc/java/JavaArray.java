package misc.java;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import net.timeandtraining.framework.TestBase;
import net.timeandtraining.framework.UI;

public class JavaArray extends TestBase{
	
	
	//String[] websites= {"http://www.google.com","http://www.ebay.com","http://www.bbc.com"};
	
	@Test(testName="navigating various websites",dataProvider="getURLS")
	public void navigate(String websites) {
		
		UI.openURL(websites);
	}

	
	@DataProvider(name="getURLS")
	public String[][] getData() {
		String[][] data = {
				
				{"http://www.google.com"},
				{"http://www.ebay.com"},
				{"http://www.bbc.com"}
				
		};
		
		return data;
	}
	
	
	@Test
	public void test() {
		
		String[] names= {"John","Smith","xyz"};	
		String[] cities= {"New York","Houston","Baltimore"};
		String[] countryCode= {"US"};		
	
		
		String[][] data = {names,cities,countryCode};
		
		
		for (int i = 0; i < data[1].length; i++) {
			System.out.println(data[1][i]);
		}
		
		
		
		
	}
	
	
	

}
