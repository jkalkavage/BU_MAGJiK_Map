package com.example.bumap;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

// this class starts the Search algorithm of our application
// the Search class, DisplaySearchResults class, and Bitmap class are all related
public class Search extends Activity implements OnClickListener
{
	ImageButton search = null;
	Button back = null;
	public final static String EXTRA_MESSAGE = "com.example.bumap.MESSAGE";
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); 
		setContentView(R.layout.search);
		// create search button and implement OnClickListener
		search =(ImageButton)findViewById(R.id.search);
		search.setOnClickListener(this);
		// create back button and implement OnClickListener
		back = (Button)findViewById(R.id.back);
		back.setOnClickListener((android.view.View.OnClickListener) this);
	}
	
	// Called when user clicks send button.
	@Override
	//public void searchBuildings(View view){
	public void onClick(View v){
		//Search Buildings for query
		if ( v == search ){
		
		Intent intent = new Intent(this, DisplaySearchResults.class);
		EditText editText = (EditText) findViewById(R.id.editText1);
		String message = editText.getText().toString();
		intent.putExtra(EXTRA_MESSAGE, message);
		startActivity(intent);}
		
		if ( v == back ){
			back.setTextColor(Color.RED);
			Intent intent = new Intent(this, MainActivity.class);
			startActivity(intent);
			//this.finish();
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