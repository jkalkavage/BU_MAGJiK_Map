package com.example.bumap;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener
{
	// declare buttons for the main interface
	Button map, search, game, credits;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);  // to not show title bar; MUST BE BEFORE setContentView in order to avoid error
		setContentView(R.layout.activity_main); // links java file to its xml file
		
		// access the buttons on the display 
		map = (Button)findViewById(R.id.map); // in the xml file, the map button's id is named map
		search = (Button)findViewById(R.id.search);
		game = (Button)findViewById(R.id.game);
		credits = (Button)findViewById(R.id.credits);
		
		// set the onClickListener to all buttons
		map.setOnClickListener(this);
		search.setOnClickListener(this);
		game.setOnClickListener(this);
		credits.setOnClickListener(this);
	}	

	@Override
	public void onClick( View v ) // using the onClick feature
	{
		// start Map activity when "Map" button is pressed
		if ( v == map ){
			map.setTextColor( Color.RED );
			Intent myIntent = new Intent(v.getContext(), Map.class ); 
			startActivityForResult( myIntent, 0 );
		}
		
		// start Search activity when "Search" button is pressed
		if ( v == search ){
			search.setTextColor( Color.RED );
			Intent myIntent = new Intent(v.getContext(), Search.class ); 
			startActivityForResult( myIntent, 0 );
		}
		
		// start Game activity when "Game" button is pressed
		if ( v == game ){
			game.setTextColor(Color.RED);
			Intent myIntent = new Intent(v.getContext(), Game.class ); 
			startActivityForResult( myIntent, 0 );
		}
		
		// start Credits activity when "Credits" button is pressed
		if ( v == credits ){
			credits.setTextColor( Color.RED );
			Intent myIntent = new Intent(v.getContext(), Credits.class);
			startActivityForResult( myIntent, 0 );
		}
}
}
	
