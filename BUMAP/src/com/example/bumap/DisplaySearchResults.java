package com.example.bumap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class DisplaySearchResults extends Activity {

	// Declare Button for going to map with marker
	private Button searchMap;
	
	// Declare textView of search results
	private TextView searchResults;
	
    // Declare coordinates for marker on map when map activity is called
	public int xcoord;
	public int ycoord;
	
	public final static String XCOORD = "com.example.bumap.XCOORD";
	public final static String YCOORD = "com.example.bumap.YCOORD";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
			// Set up activity
			super.onCreate(savedInstanceState);
			this.setContentView(R.layout.activity_display_search_results);

			// Get search string
			Intent intent = getIntent();
			String searchString = intent.getStringExtra(Search.EXTRA_MESSAGE);
	   
	    // Part 1 ************** Create the buildings 
		
			// Buildings are in a HashMap with an integer Key and a List Value
			Map<Integer, List<String>> bListMap = new HashMap<Integer, List<String>>(); 
			
			// Two lists to hold the x and y coordinates of the buildings on the bitmap
			List<Integer> xList = new LinkedList<Integer>();
			List<Integer> yList = new LinkedList<Integer>();
		
			// Keep track of the number of buildings in the HashMap.
	    	int numBuildings = 0; 

		    // Create a Linked list of Strings
			List<String> list = new LinkedList<String>();
			list.add(0,"AAS");						// Building Code
			list.add(1, "African-American Studies");// Building Name
			list.add(2,"138 Mountfort Street");		// Building Address
			xList.add(numBuildings, 0);				// X coordinate on map. This building is not on out map
			yList.add(numBuildings, 0);				// Y coordinate on map. This building is not on our map
			
			// Add List to Map with Key integer numBuildings
			bListMap.put(numBuildings,list);
			
			// Iterate number of buildings
			numBuildings++;

			// Repeat
			list = new LinkedList<String>();
			list.add(0,"ASC");
			list.add(1, "African Studies Center");
			list.add(2,"232 Bay State Road");
			xList.add(numBuildings, 1309);
			yList.add(numBuildings, 149);
			bListMap.put(numBuildings,list);
			numBuildings++;
			
			list = new LinkedList<String>();
			list.add(0,"BRB");
			list.add(1, "Biology Research Building");
			list.add(2,"5 Cummington Street");
			xList.add(numBuildings, 1548);				
			yList.add(numBuildings, 344);
			bListMap.put(numBuildings,list);
			numBuildings++;
			
			list = new LinkedList<String>();
			list.add(0,"BSC");
			list.add(1, "Biological Science Center");
			list.add(2,"2 Cummington Street");
			xList.add(numBuildings, 1542);				
			yList.add(numBuildings, 379);
			bListMap.put(numBuildings,list);
			numBuildings++;
			
			list = new LinkedList<String>();
			list.add(0,"BUT");
			list.add(1, "BU Huntington Theatre");
			list.add(2,"264 Huntington Avenue");
			xList.add(numBuildings, 0);				
			yList.add(numBuildings, 0);
			bListMap.put(numBuildings,list);
			numBuildings++;
			
			// 5th Building
			list = new LinkedList<String>();
			list.add(0,"CAD");
			list.add(1, "Center for Anxiety and Related Disorders ");
			list.add(2,"648 Beacon Street");
			xList.add(numBuildings, 0);				
			yList.add(numBuildings, 0);
			bListMap.put(numBuildings,list);
			numBuildings++;
			
			list = new LinkedList<String>();
			list.add(0,"CAS");
			list.add(1, "College of Arts and Sciences");
			list.add(2,"725 Commonwealth Avenue ");
			xList.add(numBuildings, 1296);				
			yList.add(numBuildings, 231);
			bListMap.put(numBuildings,list);
			numBuildings++;
			
			list = new LinkedList<String>();
			list.add(0,"CFA");
			list.add(1, "College of Fine Arts");
			list.add(2,"855 Commonwealth Avenue");
			xList.add(numBuildings, 576);				
			yList.add(numBuildings, 224);
			bListMap.put(numBuildings,list);
			numBuildings++;
			
			list = new LinkedList<String>();
			list.add(0,"CGS");
			list.add(1, "College of General Studies");
			list.add(2,"871 Commonwealth Avenue");
			xList.add(numBuildings, 510);				
			yList.add(numBuildings, 221);
			bListMap.put(numBuildings,list);
			numBuildings++;

			list = new LinkedList<String>();
			list.add(0,"CNS");
			list.add(1, "Cognitive and Neural Systems");
			list.add(2,"677 Beacon Street");
			xList.add(numBuildings, 1763);				
			yList.add(numBuildings, 358);
			bListMap.put(numBuildings,list);
			numBuildings++;
			
			//10th Building
			list = new LinkedList<String>();
			list.add(0,"COM");
			list.add(1, "College of Communication");
			list.add(2,"640 Commonwealth Avenue");
			xList.add(numBuildings, 1445);				
			yList.add(numBuildings, 334);
			bListMap.put(numBuildings,list);
			numBuildings++;

			list = new LinkedList<String>();
			list.add(0,"CRW");
			list.add(1, "Crew Boathouse");
			list.add(2,"619 Memorial Drive");
			xList.add(numBuildings, 0);				
			yList.add(numBuildings, 0);
			bListMap.put(numBuildings,list);
			numBuildings++;

			list = new LinkedList<String>();
			list.add(0,"CSE");
			list.add(1, "Case Physical Education Center");
			list.add(2,"285 Babcock Street");
			xList.add(numBuildings, 20);				
			yList.add(numBuildings, 48);
			bListMap.put(numBuildings,list);
			
			numBuildings++;
			list = new LinkedList<String>();
			list.add(0,"CSS");
			list.add(1, "Center for Student Services");
			list.add(2,"100 Bay State Road");
			xList.add(numBuildings, 1765);				
			yList.add(numBuildings, 180);
			bListMap.put(numBuildings,list);
			numBuildings++;

			list = new LinkedList<String>();
			list.add(0,"EGL");
			list.add(1, "English Faculty Offices");
			list.add(2,"236 Bay State Road");
			xList.add(numBuildings, 1313);				
			yList.add(numBuildings, 150);
			bListMap.put(numBuildings,list);
			numBuildings++;

			// 15th Building
			list = new LinkedList<String>();
			list.add(0,"EIB");
			list.add(1, "Editorial Institute Building");
			list.add(2,"143 Bay State Road");
			xList.add(numBuildings, 1635);				
			yList.add(numBuildings, 129);
			bListMap.put(numBuildings,list);
			numBuildings++;

			list = new LinkedList<String>();
			list.add(0,"EIL");
			list.add(1, "Eilberg Lounge (Case Center)");
			list.add(2,"285 Babcock Street");
			xList.add(numBuildings, 14);				
			yList.add(numBuildings, 72);
			bListMap.put(numBuildings,list);
			numBuildings++;

			list = new LinkedList<String>();
			list.add(0,"EMA");
			list.add(1, "Engineering Manufacturing Annex");
			list.add(2,"730 Commonwealth Avenue");
			xList.add(numBuildings, 1084);				
			yList.add(numBuildings, 303);
			bListMap.put(numBuildings,list);
			numBuildings++;

			list = new LinkedList<String>();
			list.add(0,"EMB");
			list.add(1, "Engineering Manufacturing Building");
			list.add(2,"15 St. Mary's Street");
			xList.add(numBuildings, 1090);				
			yList.add(numBuildings, 331);
			bListMap.put(numBuildings,list);
			numBuildings++;

			list = new LinkedList<String>();
			list.add(0,"ENG");
			list.add(1, "College of Engineering");
			list.add(2,"110 Cummington Street");
			xList.add(numBuildings, 1203);				
			yList.add(numBuildings, 341);
			bListMap.put(numBuildings,list);
			numBuildings++;

			// 20th Building
			list = new LinkedList<String>();
			list.add(0,"EOP");
			list.add(1, "Center for English Language");
			list.add(2,"890 Commonwealth Avenue");
			xList.add(numBuildings, 470);				
			yList.add(numBuildings, 303);
			bListMap.put(numBuildings,list);
			numBuildings++;

			list = new LinkedList<String>();
			list.add(0,"ERA");
			list.add(1, "Engineering Research Annex");
			list.add(2,"48 Cummington Street");
			xList.add(numBuildings, 1428);				
			yList.add(numBuildings, 371);
			bListMap.put(numBuildings,list);
			numBuildings++;

			list = new LinkedList<String>();
			list.add(0,"ERB");
			list.add(1, "Engineering Research Building");
			list.add(2,"44 Cummington Street");
			xList.add(numBuildings, 1439);				
			yList.add(numBuildings, 334);
			bListMap.put(numBuildings,list);
			numBuildings++;

			list = new LinkedList<String>();
			list.add(0,"FLR");
			list.add(1, "Fuller Building");
			list.add(2,"808 Commonwealth Avenue");
			xList.add(numBuildings, 708);				
			yList.add(numBuildings, 306);
			bListMap.put(numBuildings,list);
			numBuildings++;

			list = new LinkedList<String>();
			list.add(0,"FOB");
			list.add(1, "Faculty Office Building (Alden Hall)");
			list.add(2,"704 Commonwealth Avenue");
			xList.add(numBuildings, 1234);				
			yList.add(numBuildings, 309);
			bListMap.put(numBuildings,list);
			numBuildings++;

			//25th Building
			list = new LinkedList<String>();
			list.add(0,"FRC");
			list.add(1, "Fitness and Recreation Center (FitRec)");
			list.add(2,"915 Commonwealth Avenue");
			xList.add(numBuildings, 310);				
			yList.add(numBuildings, 211);
			bListMap.put(numBuildings,list);
			numBuildings++;

			list = new LinkedList<String>();
			list.add(0,"GCB");
			list.add(1, "General Classroom Building");
			list.add(2,"750 Commonwealth Avenue");
			xList.add(numBuildings, 1054);				
			yList.add(numBuildings, 302);
			bListMap.put(numBuildings,list);
			numBuildings++;

			list = new LinkedList<String>();
			list.add(0,"GMS");
			list.add(1, "Graduate Medical Sciences");
			list.add(2,"715 Albany Street");
			xList.add(numBuildings, 0);				
			yList.add(numBuildings, 0);
			bListMap.put(numBuildings,list);
			numBuildings++;

			list = new LinkedList<String>();
			list.add(0,"GRS");
			list.add(1, "Graduate School of Arts and Sciences");
			list.add(2,"705 Commonwealth Avenue");
			xList.add(numBuildings, 2000);				
			yList.add(numBuildings, 400);
			bListMap.put(numBuildings,list);
			numBuildings++;

			list = new LinkedList<String>();
			list.add(0,"GSU");
			list.add(1, "George Sherman Union");
			list.add(2,"775 Commonwealth Avenue");
			xList.add(numBuildings, 1019);				
			yList.add(numBuildings, 229);
			bListMap.put(numBuildings,list);
			numBuildings++;

			// 30th Building
			list = new LinkedList<String>();
			list.add(0,"HIS");
			list.add(1, "History and American Studies Departments");
			list.add(2,"226 Bay State Road");
			xList.add(numBuildings, 1360);				
			yList.add(numBuildings, 182);
			bListMap.put(numBuildings,list);
			numBuildings++;

			list = new LinkedList<String>();
			list.add(0,"IEC");
			list.add(1, "International Education Center");
			list.add(2,"888 Commonwealth Avenue");
			xList.add(numBuildings, 481);				
			yList.add(numBuildings, 299);
			bListMap.put(numBuildings,list);
			numBuildings++;

			list = new LinkedList<String>();
			list.add(0,"IRB");
			list.add(1, "International Relations Building");
			list.add(2,"154 Bay State Road");
			xList.add(numBuildings, 1554);				
			yList.add(numBuildings, 184);
			bListMap.put(numBuildings,list);
			numBuildings++;
		
			list = new LinkedList<String>();
			list.add(0,"IRC");
			list.add(1, "International Relations Center");
			list.add(2,"152 Bay State Road");
			xList.add(numBuildings, 1569);				
			yList.add(numBuildings, 185);
			bListMap.put(numBuildings,list);
			numBuildings++;

			list = new LinkedList<String>();
			list.add(0,"JSC");
			list.add(1, "CAS Judaic Studies Center");
			list.add(2,"147 Bay State Road");
			xList.add(numBuildings, 1617);				
			yList.add(numBuildings, 132);
			bListMap.put(numBuildings,list);
			numBuildings++;

			// 35th Building
			list = new LinkedList<String>();
			list.add(0,"KCB");
			list.add(1, "Kenmore Classroom Building");
			list.add(2,"565 Commonweatlh Avenue");
			xList.add(numBuildings, 1760);				
			yList.add(numBuildings, 219);
			bListMap.put(numBuildings,list);
			numBuildings++;

			list = new LinkedList<String>();
			list.add(0,"LAW");
			list.add(1, "Law School");
			list.add(2,"765 Commonwealth Avenue");
			xList.add(numBuildings, 1073);				
			yList.add(numBuildings, 188);
			bListMap.put(numBuildings,list);
			numBuildings++;

			list = new LinkedList<String>();
			list.add(0,"LNG");
			list.add(1, "Modern Foreign Languages");
			list.add(2,"718 Commonwealth Avenue");
			xList.add(numBuildings, 1199);				
			yList.add(numBuildings, 298);
			bListMap.put(numBuildings,list);
			numBuildings++;

			list = new LinkedList<String>();
			list.add(0,"LSE");
			list.add(1, "Life Science and Engineering Building");
			list.add(2,"24 Cummington Street ");
			xList.add(numBuildings, 1508);				
			yList.add(numBuildings, 375);
			bListMap.put(numBuildings,list);
			numBuildings++;

			list = new LinkedList<String>();
			list.add(0,"MAR");
			list.add(1, "Marsh Chapel");
			list.add(2,"735 Commonwealth Avenue");
			xList.add(numBuildings, 1137);				
			yList.add(numBuildings, 206);
			bListMap.put(numBuildings,list);
			numBuildings++;

			// 40th Building
			list = new LinkedList<String>();
			list.add(0,"MCS");
			list.add(1, "Math and Computer Science");
			list.add(2,"111 Cummington Street ");
			xList.add(numBuildings, 1312);				
			yList.add(numBuildings, 325);
			bListMap.put(numBuildings,list);
			numBuildings++;

			list = new LinkedList<String>();
			list.add(0,"MED");
			list.add(1, "School of Medicine");
			list.add(2,"715 Albany Street");
			xList.add(numBuildings, 0);				
			yList.add(numBuildings, 0);
			bListMap.put(numBuildings,list);
			numBuildings++;

			list = new LinkedList<String>();
			list.add(0,"MET");
			list.add(1, "Metropolitan College");
			list.add(2,"755 Commonwealth Avenue");
			xList.add(numBuildings, 1069);				
			yList.add(numBuildings, 234);
			bListMap.put(numBuildings,list);
			numBuildings++;

			list = new LinkedList<String>();
			list.add(0,"MOR");
			list.add(1, "Morse Auditorium");
			list.add(2,"602 Commonwealth Avenue");
			xList.add(numBuildings, 1555);				
			yList.add(numBuildings, 307);
			bListMap.put(numBuildings,list);
			numBuildings++;

			list = new LinkedList<String>();
			list.add(0,"MUG");
			list.add(1, "Mugar Memorial Library");
			list.add(2,"771 Commonwealth Avenue");
			xList.add(numBuildings, 1048);				
			yList.add(numBuildings, 201);
			bListMap.put(numBuildings,list);
			numBuildings++;

			// 45th Building
			list = new LinkedList<String>();
			list.add(0,"PDP");
			list.add(1, "Physical Development Program");
			list.add(2,"915 Commonwealth Avenue");
			xList.add(numBuildings, 312);				
			yList.add(numBuildings, 203);
			bListMap.put(numBuildings,list);
			numBuildings++;

			list = new LinkedList<String>();
			list.add(0,"PHO");
			list.add(1, "Photonics Building");
			list.add(2,"8 St. Mary's Street");
			xList.add(numBuildings, 1164);				
			yList.add(numBuildings, 321);
			bListMap.put(numBuildings,list);
			numBuildings++;

			list = new LinkedList<String>();
			list.add(0,"PLS");
			list.add(1, "Anthropology, Philosophy, Political Science");
			list.add(2,"232 Bay State Road");
			xList.add(numBuildings, 1340);				
			yList.add(numBuildings, 174);
			bListMap.put(numBuildings,list);
			numBuildings++;

			list = new LinkedList<String>();
			list.add(0,"PRB");
			list.add(1, "Physics Research Building");
			list.add(2,"3 Cummington Street");
			xList.add(numBuildings, 1557);				
			yList.add(numBuildings, 339);
			bListMap.put(numBuildings,list);
			numBuildings++;

			list = new LinkedList<String>();
			list.add(0,"PSY");
			list.add(1, "Psychology");
			list.add(2,"64 Cummington Street");
			xList.add(numBuildings, 1297);				
			yList.add(numBuildings, 324);
			bListMap.put(numBuildings,list);
			numBuildings++;

			//50th Building
			list = new LinkedList<String>();
			list.add(0,"PTH");
			list.add(1, "Playwrights' Theatre");
			list.add(2,"949 Commonwealth Avenue");
			xList.add(numBuildings, 154);				
			yList.add(numBuildings, 217);
			bListMap.put(numBuildings,list);
			numBuildings++;

			list = new LinkedList<String>();
			list.add(0,"REL");
			list.add(1, "CAS Religion");
			list.add(2,"145 Bay State Road");
			xList.add(numBuildings, 1623);				
			yList.add(numBuildings, 129);
			bListMap.put(numBuildings,list);
			numBuildings++;

			list = new LinkedList<String>();
			list.add(0,"SAC");
			list.add(1, "Sargent Activities Center");
			list.add(2,"1 University Road");
			xList.add(numBuildings, 943);				
			yList.add(numBuildings, 179);
			bListMap.put(numBuildings,list);
			numBuildings++;

			list = new LinkedList<String>();
			list.add(0,"SAL");
			list.add(1, "Sailing Docks");
			list.add(2,"Charles River Behind BU Bridge");
			xList.add(numBuildings, 844);				
			yList.add(numBuildings, 106);
			bListMap.put(numBuildings,list);
			numBuildings++;

			list = new LinkedList<String>();
			list.add(0,"SAR");
			list.add(1, "Sargent College");
			list.add(2,"635 Commonwealth Avenue");
			xList.add(numBuildings, 1467);				
			yList.add(numBuildings, 236);
			bListMap.put(numBuildings,list);
			numBuildings++;

			// 55th Building
			list = new LinkedList<String>();
			list.add(0,"SCI");
			list.add(1, "Science Center");
			list.add(2,"590-596 Commonwealth Avenue");
			xList.add(numBuildings, 1446);				
			yList.add(numBuildings, 332);
			bListMap.put(numBuildings,list);
			numBuildings++;

			list = new LinkedList<String>();
			list.add(0,"SDM");
			list.add(1, "Henry M. Goldman School of Dental Medicine");
			list.add(2,"100 East Newton Street");
			xList.add(numBuildings, 0);				
			yList.add(numBuildings, 0);
			bListMap.put(numBuildings,list);
			numBuildings++;

			list = new LinkedList<String>();
			list.add(0,"SEA");
			list.add(1, "School of Education Annex");
			list.add(2,"621 Commonwealth Avenue");
			xList.add(numBuildings, 1568);				
			yList.add(numBuildings, 228);
			bListMap.put(numBuildings,list);
			numBuildings++;

			list = new LinkedList<String>();
			list.add(0,"SED");
			list.add(1, "School of Education");
			list.add(2,"2 Sherborn Street");
			xList.add(numBuildings, 1567);				
			yList.add(numBuildings, 212);
			bListMap.put(numBuildings,list);
			numBuildings++;

			list = new LinkedList<String>();
			list.add(0,"SHA");
			list.add(1, "School of Hospitality Administration");
			list.add(2,"928 Commonwealth Avenue");
			xList.add(numBuildings, 253);				
			yList.add(numBuildings, 309);
			bListMap.put(numBuildings,list);
			numBuildings++;

			// 60th Building
			list = new LinkedList<String>();
			list.add(0,"SLB");
			list.add(1, "Science Library Building");
			list.add(2,"38 Cummington Street");
			xList.add(numBuildings, 1490);				
			yList.add(numBuildings, 376);
			bListMap.put(numBuildings,list);
			numBuildings++;

			list = new LinkedList<String>();
			list.add(0,"SMG");
			list.add(1, "School of Management");
			list.add(2,"595 Commonwealth Avenue");
			xList.add(numBuildings, 1661);				
			yList.add(numBuildings, 228);
			bListMap.put(numBuildings,list);
			numBuildings++;

			list = new LinkedList<String>();
			list.add(0,"SOC");
			list.add(1, "Sociology");
			list.add(2,"96-100 Cummington Street");
			xList.add(numBuildings, 1284);				
			yList.add(numBuildings, 362);
			bListMap.put(numBuildings,list);
			numBuildings++;
		
			list = new LinkedList<String>();
			list.add(0,"SPH");
			list.add(1, "School of Public Health");
			list.add(2,"715 Albany Street");
			xList.add(numBuildings, 0);				
			yList.add(numBuildings, 0);
			bListMap.put(numBuildings,list);
			numBuildings++;
					
			list = new LinkedList<String>();
			list.add(0,"SSW");
			list.add(1, "School of Social Work");
			list.add(2,"264 Bay State Road");
			xList.add(numBuildings, 1245);				
			yList.add(numBuildings, 171);
			bListMap.put(numBuildings,list);
			numBuildings++;
					
			// 65th Building
			list = new LinkedList<String>();
			list.add(0,"STH");
			list.add(1, "School of Theology");
			list.add(2,"745 Commonwealth Avenue");
			xList.add(numBuildings, 1067);				
			yList.add(numBuildings, 229);
			bListMap.put(numBuildings,list);
			numBuildings++;
					
			list = new LinkedList<String>();
			list.add(0,"STO");
			list.add(1, "Stone Science Building");
			list.add(2,"675 Commonwealth Avenue");
			xList.add(numBuildings, 1359);				
			yList.add(numBuildings, 223);
			bListMap.put(numBuildings,list);
			numBuildings++;
					
			list = new LinkedList<String>();
			list.add(0,"TTC");
			list.add(1, "Track and Tennis Center");
			list.add(2,"100 Ashford Street");
			xList.add(numBuildings, 0);				
			yList.add(numBuildings, 0);
			bListMap.put(numBuildings,list);
			numBuildings++;
					
			list = new LinkedList<String>();
			list.add(0,"UHC");
			list.add(1, "University Honors College");
			list.add(2,"147 Bay State Road");
			xList.add(numBuildings, 1617);				
			yList.add(numBuildings, 131);
			bListMap.put(numBuildings,list);
			numBuildings++;// 68
			
			
		// Part 2 ************* See if searchString matches a building.
			
			// String answer will be displayed at the end of the search 
		    String answer = "No"; // Default value. This should never be seen
		    
		    // mySearch controls which for loops will be entered
			boolean mySearch = false;
			
			// Count loop counts the number of buildings added in the Incomplete Match Case
			int countLoop;
					
			// Complete Match, Case Insensitive
			// This will go through a linear search of the buildings until searchString matches
			// either a code, building name, or address perfectly, with case insensitivity. It stops once 
			// the match is found. If nothing matches perfectly, it continues on to the next linear search.
			for (int i = 0; i < numBuildings; i++){
				if (    searchString.equalsIgnoreCase(bListMap.get(i).get(0))
					||  searchString.equalsIgnoreCase(bListMap.get(i).get(1))
					||  searchString.equalsIgnoreCase(bListMap.get(i).get(2)) ){
					 // If the building exists, get all building info.
					answer = "Code: ".concat( bListMap.get(i).get(0).concat("\n"));// Concatenate Code to result
					answer = answer.concat("Name: ".concat( bListMap.get(i).get(1).concat("\n")));// Concatenate Name to result
					answer = answer.concat("Address: ".concat( bListMap.get(i).get(2).concat("\n")));// Concatenate Address to result	
					answer = answer.concat("\nClick 'Go To Map' to see marker over location.");
					xcoord = xList.get(i);// set x coordinate of building
					ycoord = yList.get(i);// set y coordinate of building
					
					// If the building is off the map
					if (xcoord == 0 || ycoord == 0){
						answer = answer.concat("\nBuilding is outside of map bounds.\nMap will not display marker over location.");
					};
					
					// Escape search loop and go to create the text view
					mySearch = true;
				}
			};

			// Incomplete Match 
			// This search goes through and finds whenever searchString is a substring of a 
			// building code, name or address. All buildings are searched through and all results
			// are displayed. If nothing is found, it continues on to the no match case.
			if (mySearch == false){
				// Will not display a marker, since multiple matches are found.
				// These will stay at minus one if No Match case is reached.
				xcoord = -1;
				ycoord = -1;
				countLoop = 0;
				answer = "Exact match not found. Possible buildings are:\n";
				for (int i = 0; i < numBuildings; i++){
					 if (   bListMap.get(i).get(0).toLowerCase(Locale.US).contains(searchString.toLowerCase(Locale.US))
						||  bListMap.get(i).get(1).toLowerCase(Locale.US).contains(searchString.toLowerCase(Locale.US))
						||  bListMap.get(i).get(2).toLowerCase(Locale.US).contains(searchString.toLowerCase(Locale.US)) ){
						// If the building might match, get building info.
						answer = answer.concat("Code: ".concat( bListMap.get(i).get(0).concat("\n")));// Concatenate Code to result
						answer = answer.concat("Name: ".concat( bListMap.get(i).get(1).concat("\n")));// Concatenate Name to result
						answer = answer.concat("Address: ".concat( bListMap.get(i).get(2).concat("\n")));// Concatenate Address to result 
						 	countLoop++;}}
				// Skip No Match case
				if (countLoop != 0){ mySearch = true;}
			}
					
			// No Match 
			// If searchString is not a match for or a substring of any building name, code or address,
			// this result is displayed.
			if (mySearch == false){
				answer = "Not Found. Try spelling out words like \"Road\" instead of \"Rd\"  or widen search " +
						 "like \"Commonwealth\" instead of \"580 Commonwealth Ave\".";
			}
		
	    // Part 3 ********** Display search results

			// answer is the result of the search and will be displayed
			searchResults = (TextView) findViewById(R.id.searchResults);
	    	searchResults.setText(answer); 
		    
			// Place Button searchMap
			searchMap = (Button) findViewById(R.id.searchMap);
			
			// Create function for button
			searchMap.setOnClickListener(new OnClickListener() {
			    @Override
			    public void onClick(View v) {
			    	
			    	// Create intent
			    	searchMap.setTextColor(Color.RED);
			    	Intent intent = new Intent(v.getContext(), Bitmap.class);
			    	
			    	// Pass the x and y coordinate to the Bitmap class
			    	intent.putExtra(XCOORD, xcoord);
			    	intent.putExtra(YCOORD, ycoord);
			    	
			    	// Start Bitmap activity
			    	startActivity(intent);
			    }
			});
			
	    	// Do not display button if there are multiple or no search results.
	    	if (xcoord == -1 || ycoord == -1){
	    		View b = findViewById(R.id.searchMap);
	    		b.setVisibility(View.GONE);

	    	}

			// Show the Up button in the action bar.
			setupActionBar();
	}

	
	//Set up the {@link android.app.ActionBar}, if the API is available.
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	

}