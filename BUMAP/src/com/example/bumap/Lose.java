package com.example.bumap;
//This activity displays the result fot the loosing case
//This activity contains a EditText object with the results 
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Lose extends Activity implements OnClickListener{
	//Creating the back button which returns to the game main menu
	Button buttonLoseBack; 	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); // to remove the default title header on interface
		setContentView(R.layout.activity_lose);
		
		buttonLoseBack = (Button) findViewById(R.id.buttonLoseBack);
		buttonLoseBack.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lose, menu);
		return true;
	}
	
	public void onClick(View v){
		buttonLoseBack.setTextColor(Color.RED);
		Intent intent = new Intent(this, DisplayGameMap.class);
		startActivity(intent);
	}

}
