package com.example.bumap;
//This activity displays the result fot the winning case
//This activity contains a EditText object with the results 
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Win extends Activity implements OnClickListener{
	//Creating the back button which returns to the game main menu
	
	Button buttonWinBack; 	
	@Override
	protected void onCreate(Bundle savedInstanceState)  {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); // to remove the default title header on interface
		setContentView(R.layout.activity_win);
		
		buttonWinBack = (Button) findViewById(R.id.buttonWinBack);
		buttonWinBack.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.win, menu);
		return true;
	}
	
	public void onClick(View v){
		buttonWinBack.setTextColor(Color.RED);
		Intent intent = new Intent(this, DisplayGameMap.class);
		startActivity(intent);
	}
}
