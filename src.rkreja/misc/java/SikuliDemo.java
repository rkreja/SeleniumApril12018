package misc.java;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

public class SikuliDemo {

	public static void main(String[] args) throws FindFailed {
		
	
		
			Screen screen = new Screen();
			
		
			

			//CLICK
			screen.click("sikuli/clickme.PNG");
			
			screen.click("sikuli/stp.PNG");
			screen.doubleClick("sikuli/abc.PNG");

			

			//TYPE
			screen.type("sikuli/tb.PNG","hello");
			
			
			
			// CHECK OBJECT EXISTS
			if(screen.exists("sikuli/img.PNG")==null) {
				System.out.println("NOT FOUND");
			}else {
				System.out.println("FOUND");
			}
			
			//SWIPE
			screen.exists("sikuli/example.PNG").aSwipeRight();


	}

}
