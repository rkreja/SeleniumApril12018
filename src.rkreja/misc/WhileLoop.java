package misc;

public class WhileLoop {
	
	
	
	
	
	public static void main(String[] args) {
		
		
		
		long past=System.currentTimeMillis();
		
		
		boolean goahead=true;
		
		while (goahead) {			
			
			
			System.err.println("Run......");			
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			long differenceBetweenNowAndPast=(System.currentTimeMillis()-past);
			long second=differenceBetweenNowAndPast/1000;
			
			goahead=(second<10);
			
		}
		
		
		//1524190556847
		//1524190573907
		
		
		
		/*
		boolean procceed=true;
		long i=1;
		
		while (procceed) {			
			System.err.println("hello "+ i);
			i+=1;
			
			if(i>999999) {
				procceed=false;
			}	
			
		}
		*/
		
		
		
		
		
		
		
		
		
		
	}
	
	
	

}
