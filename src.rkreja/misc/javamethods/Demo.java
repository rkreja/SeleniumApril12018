package misc.javamethods;

import org.testng.annotations.Test;

public class Demo {

	@Test
	public void abc() {
		
		Singer bdsinger = new Singer();
			
		
		bdsinger.sing("Ami banglkay gaan gain");
		int s=bdsinger.calculate(50, 50);
		System.out.println(s);

		
		
		
		
	}


}
