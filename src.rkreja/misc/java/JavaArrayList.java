package misc.java;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import net.timeandtraining.framework.TestBase;

public class JavaArrayList extends TestBase{
	
	
	
	
	@Test
	public void test() {		
		
		String[] name= {"john, smith","steve"};
			
	
		
		List<String> name1 = new ArrayList<>();
		
		name1.add("John");
		name1.add("Smith");
		name1.add("Mary");
		name1.add("Michale");
		name1.add("Shan");
		name1.add("Lorence");
		
		
		for (int i = 0; i < name1.size() ; i++) {
			System.out.println(name1.get(i));
		
		}
		
		
		for(String s:name1) {
			System.out.println(s);
		}
		
		

		
	/*	
		System.out.println(name1.size());//?3
		
		name1.add("mike");	
		
		System.out.println(name1.size());//?4
		
		
		
		name1.size();
		
		
		
		System.out.println(name1.size());// ??? 3 
		System.out.println(name1.get(2));// ??? mike 
		*/
		
		
		
		
		
		
		
	}
	

}
