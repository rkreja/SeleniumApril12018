package misc;
import org.testng.Assert;

import org.testng.annotations.Test;



public class AssertDemo {

	
	
	@Test
	public void verifyString() {		
		//verify Bangladesh's capital is 'Dhaka'		
		String capital="Dhaka";
		Assert.assertEquals(capital, "Dhaka");
		  
	}
	@Test
	public void verifyInt() {		
		//verify Sony and Tina are same age		
		int sonisAge=25;
		int tinasAge=26;		
		Assert.assertEquals(sonisAge, tinasAge);
		
	}
	@Test
	public void verifyBoolean() {		
		//verify Sony is younger than Tina		
		int sonisAge=25;
		int tinasAge=26;		
		Assert.assertEquals(sonisAge<tinasAge, true);
		
	}

}
