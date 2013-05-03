package com.example.bumap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

public class DisplayGameMap extends Activity implements OnClickListener{
//Creating global variables
	// Lists that contain the x and y coordinates
	List<Integer> xList;
	List<Integer> yList;
	
	//Array List that contains the sequentially ordered integers. Max integer is the total number of buildings
	List<Integer> intList;
	
	// Index of winning condition
	int correctIndex;
	
	//Button to generate next question
	Button buttonNext;
	
	//Button for answer options
	Button button1;
	Button button2;
	Button button3;
	
	//Button to return to the main menu
	Button buttonMain;

	//hashmap that contains the data ab buildings' names and (x,y) coordinates of the building
	java.util.Map <Integer, List<String>> bListMap; 

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); // to remove the default title header on interface
		setContentView(R.layout.activity_display_game_map);
		
		
		//Setting the return to the main menu button
		buttonMain = (Button)findViewById(R.id.buttonMain);
		buttonMain.setOnClickListener(this);
		
		// set the next question button
		buttonNext = (Button)findViewById(R.id.buttonNext);
		buttonNext.setOnClickListener(this);
				
		// Create buildings, without ones not on BU map
				bListMap = new HashMap<Integer, List<String>>(); 
	 			// Two lists to hold the x and y coordinates of the buildings on the bitmap
	 			xList = new LinkedList<Integer>();
	 			yList = new LinkedList<Integer>();
	 		
	 			// Keep track of the number of buildings in the HashMap.
	 	    	int numBuildings = 0; 

	 		    // Create a Linked list of Strings
	 	    	List<String> list = new LinkedList<String>();
	 			list.add(0,"ASC");					// Building Code
	 			list.add(1, "African Studies Center");// Building Name
	 			list.add(2,"232 Bay State Road");// Building Address
	 			xList.add(numBuildings, 1309);// X coordinate on map. This building is not on out map
	 			yList.add(numBuildings, 149);// Y coordinate on map. This building is not on our map
	 			// Add List to Map with Key integer numBuildings
	 			bListMap.put(numBuildings,list);
	 			// Iterate number of buildings
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
	 			list.add(0,"UHC");
	 			list.add(1, "University Honors College");
	 			list.add(2,"147 Bay State Road");
	 			xList.add(numBuildings, 1617);				
	 			yList.add(numBuildings, 131);
	 			bListMap.put(numBuildings,list);
	 			numBuildings++;// 68
	 			
	 			//intList is an array of integers. It is sequentially ordered integer arrays
	 			intList = new ArrayList<Integer>();
	 			
	 			for (int i = 0; i < xList.size(); i++){
	 				intList.add(new Integer(i));
	 			}
	 			//keyInteger stores the necessary hashmap key
	 			int keyInteger = (int)Math.floor(Math.random()*intList.size());
	 			
	 			//This keeps it from pointing to a non-existing building
	 			if (keyInteger == numBuildings || keyInteger == numBuildings -1){
	 				keyInteger = 30;
	 			}
	 			
	 			customDraw(keyInteger);
	}
	
	//customDraw method takes the randomly generated integer, which plays the role of the hashmapkey
	//Hashmap key is then used to get the (x,y) pixel coordinates that corresponds to the building that corresponds
	//to that hashmap key
	private void customDraw(int keyInteger) {
		ImageView image = (ImageView) findViewById(R.id.imageView1);
		android.graphics.Bitmap bMap = BitmapFactory.decodeResource(getResources(), R.drawable.map_final);
		android.graphics.Bitmap myBitmap = bMap.copy(Config.ARGB_8888, true);
		image.setImageBitmap(myBitmap);
			
		Paint paint = new Paint(); // used to change colors for canvas methods
		paint.setColor(Color.RED); // making the dot red
		Canvas canvas = new Canvas(myBitmap); // creating a new canvas with the bitmap
		canvas.drawCircle(xList.get(keyInteger), yList.get(keyInteger), 8, paint); // drawing a red circle with ( x, y, radius ) 
	
		// choose which button should contain correct answer on random
		correctIndex = (int)(Math.random()*3.);
		List<Integer> wrongAnswers = new ArrayList<Integer>();
		for(int i=0; i<xList.size(); i++){
		if(i!=keyInteger){
		wrongAnswers.add(Integer.valueOf(i));
		}
		}
		// select two random choices from all wrong answers
		int[] multipleChoices = new int[2];
		multipleChoices[0] = wrongAnswers.remove((int)(Math.random()*wrongAnswers.size())).intValue();
		multipleChoices[1] = wrongAnswers.remove((int)(Math.random()*wrongAnswers.size())).intValue();
		int currentWrongIndex = 0;
		button1 = (Button)findViewById(R.id.button1);
		button1.setOnClickListener(this);
		button1.setText(bListMap.get(correctIndex==0?keyInteger: multipleChoices[currentWrongIndex++]).get(0));
		button2 = (Button)findViewById(R.id.button2);
		button2.setOnClickListener(this);
		button2.setText(bListMap.get(correctIndex==1?keyInteger: multipleChoices[currentWrongIndex++]).get(0));
		button3 = (Button)findViewById(R.id.button3);
		button3.setOnClickListener(this);
		button3.setText(bListMap.get(correctIndex==2?keyInteger: multipleChoices[currentWrongIndex++]).get(0));

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_game_map, menu);
		return true;
	}
	
	
	//Actions that are performed when next question button is presssed
	@Override
	public void onClick(View v) {
		if (v==buttonNext){
			buttonNext.setTextColor(Color.RED);
			//assign a random integer to current variable that was not used before
			//also deleting the used integer from intList 
			int current = intList.remove((int)Math.floor(Math.random()*intList.size()));
			//Draw a new bitmap with thered dotgenerated at the different place
			customDraw(current);
		}
		
		if (v==button2){
			makeDecision(v, 1);
		}
		
		if (v==button1){
			makeDecision(v,0);
		}
			
		if (v==button3){
			makeDecision(v, 2);
		}

		
		if (v==buttonMain){
			buttonMain.setTextColor(Color.RED);
			Intent myIntent = new Intent(v.getContext(), MainActivity.class ); 
			startActivityForResult( myIntent, 0 );
			
		}}

	// Start result activity, either Win or Lose
	private void makeDecision(View v, int buttonIndex){
		Intent myIntent = new Intent(v.getContext(), buttonIndex==correctIndex? Win.class: Lose.class );
		startActivityForResult( myIntent, 0 );
	}
}
