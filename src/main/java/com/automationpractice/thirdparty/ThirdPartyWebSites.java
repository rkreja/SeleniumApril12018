package com.automationpractice.thirdparty;

import java.util.concurrent.ThreadLocalRandom;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import net.timeandtraining.framework.TestBase;
import net.timeandtraining.framework.UI;

public class ThirdPartyWebSites extends TestBase{
	

	
@DataProvider(name="zip code data provider")	
public String[][] zipcode(){
	String[][] myData = {
			{"12058"},
			{"12059"}, 
			{"12060"},
			{"12061"}, 
			{"12062"}, 
			{"12063"}, 
			{"12064"}			
	};
	return myData;
}
	
	
	@Test(dataProvider="zip code data provider")
	public void lookupCityByZipcode(String zipcode) {		
		
			
		
//		    Goto: https://tools.usps.com/go/TrackConfirmAction_input
			UI.openURL("https://tools.usps.com/go/TrackConfirmAction_input");
////			Hover over 'Mail  & Ship' button from top menu
//			UI.mouseHover(UI.findelementById("mail-ship-width"));
////			Click look up a zipcode
//			UI.clearByXpath("(//a[contains(text(),'Look Up a ZIP Code')])[1]");
////			Click 'Find cities by zipcode' button
//			UI.clearByXpath("(//a[text()='Find Cities by ZIP'])[1]");
//			
//			
			

			
//			Pick random NY zipcode from given sheet in test data column
			
			
//			Once one zipcode has been picked enter it in ZipCode text field
			
			UI.enterTextById("", zipcode);
			
//			Click Find button
//			Verify city name is correct as per sheet for specified zipcode
//			repeat same step 2 to 5 for 9 more times by clicking 'Lookup another zipcode' button
	}
	
	
	static String data="12057	Eagle Bridge\r\n" + 
			"12058	Earlton\r\n" + 
			"12059	East Berne\r\n" + 
			"12060	East Chatham\r\n" + 
			"12061	East Greenbush\r\n" + 
			"12062	East Nassau\r\n" + 
			"12063	East Schodack\r\n" + 
			"12064	East Worcester\r\n" + 
			"12065	Clifton Park\r\n" + 
			"12066	Esperance\r\n" + 
			"12067	Feura Bush\r\n" + 
			"12068	Fonda\r\n" + 
			"12069	Fort Hunter\r\n" + 
			"12070	Fort Johnson\r\n" + 
			"12071	Fultonham\r\n" + 
			"12072	Fultonville\r\n" + 
			"12073	Gallupville\r\n" + 
			"12074	Galway\r\n" + 
			"12075	Ghent\r\n" + 
			"12076	Gilboa\r\n" + 
			"12077	Glenmont\r\n" + 
			"12078	Gloversville\r\n" + 
			"12082	Grafton\r\n" + 
			"12083	Greenville\r\n" + 
			"12084	Guilderland\r\n" + 
			"12085	Guilderland Center\r\n" + 
			"12086	Hagaman\r\n" + 
			"12087	Hannacroix\r\n" + 
			"12089	Hoosick\r\n" + 
			"12090	Hoosick Falls\r\n" + 
			"12092	Howes Cave\r\n" + 
			"12093	Jefferson\r\n" + 
			"12094	Johnsonville\r\n" + 
			"12095	Johnstown\r\n" + 
			"12106	Kinderhook\r\n" + 
			"12107	Knox\r\n" + 
			"12108	Lake Pleasant\r\n" + 
			"12110	Latham\r\n" + 
			"12115	Malden Bridge\r\n" + 
			"12116	Maryland\r\n" + 
			"12117	Mayfield\r\n" + 
			"12118	Mechanicville\r\n" + 
			"12120	Medusa\r\n" + 
			"12121	Melrose\r\n" + 
			"12122	Middleburgh\r\n" + 
			"12123	Nassau\r\n" + 
			"12124	New Baltimore\r\n" + 
			"12125	New Lebanon\r\n" + 
			"12128	Newtonville\r\n" + 
			"12130	Niverville\r\n" + 
			"12131	North Blenheim\r\n" + 
			"12132	North Chatham\r\n" + 
			"12133	North Hoosick\r\n" + 
			"12134	Northville";

}
