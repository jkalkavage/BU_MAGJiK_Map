package com.example.bumap;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Game extends Activity implements OnClickListener{

	Button buttonPlay, main_menu;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); // to remove the default title header on interface
		setContentView(R.layout.activity_game);
		
		buttonPlay = (Button) findViewById(R.id.buttonPlay);
		buttonPlay.setOnClickListener(this);
		
		main_menu = (Button) findViewById(R.id.main_menu);
		main_menu.setOnClickListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
		return true;
	}
	
	// start the game when the button is pressed 
	@Override
	public void onClick(View v){
		if ( v== buttonPlay ){
		buttonPlay.setTextColor(Color.RED);	
		Intent intent = new Intent(this, DisplayGameMap.class);
		startActivity(intent);
		}
		
		if ( v == main_menu ){
		main_menu.setTextColor(Color.RED);
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
		}
	}
}


