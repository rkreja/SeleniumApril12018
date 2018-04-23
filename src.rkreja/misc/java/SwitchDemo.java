package misc.java;

import java.awt.Color;

public class SwitchDemo {

	public static void main(String[] args) {
		
		
		String color="g";
		
		switch (color) {	
		
		
		case "m":
			System.out.println("MAGENTA");
			break;
			
			
			

		case "r":
			System.out.println("RED");
			break;
			
			
			
		case "b":
			System.out.println("BLUE");
			break;
			
			
		case "g":
			System.out.println("GREEN");
			//
			//
			//
			break;		
			
			
		default:
			System.out.println("sorry ivalid entry");
			break;
		}
		
		
/*		String color="m";
		
		
		
		if (color.startsWith("r")) {
			System.out.println("RED");
		}else if (color.startsWith("g")) {
			System.out.println("GREEN");
		}else if (color.startsWith("m")) {
			System.out.println("MAGENTA");
		}else if (color.startsWith("b")) {
			System.out.println("BLUE");
		}
		
			*/	
		
		

	}

}
