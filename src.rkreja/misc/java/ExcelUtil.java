package misc.java;

import com.rkreja.Util;

public class ExcelUtil{
	
	
	
	
	public static void main(String[]args) {		
		
		
//		Excel xl = new Excel("C:\\Users\\rkreja\\Documents\\ny_zipcodes.xlsx","Sheet1");
//		System.out.println(xl.checkValueContainsInCell(2, xl.getColumnIndex("Country"), "6390"));
//		
//		Gmail mygmail = new Gmail("xzxz@gmail.com", "sasas");
//		mygmail.ComposeEmail("someone@gmail.com", "Hi", "dsdsds sdsd s");
//		mygmail.get_link_from_email("dsender@gfg.cxpom");
//		
		
		for(int i=0;i<50;i++) {
			
			System.out.println(Util.generate_random_alphanumeric_string(6)+"\t"+
			Util.generate_random_alphanumeric_string(6)+"\t"+
			Util.generate_random_alphanumeric_string(6)+"@mailinator.com"+"\t"+
			Util.generate_random_numeric_string(9));			
			;
			
			
			
		}
		
		
	}
	
	
	
	
	

}
