package com.example.bumap;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

// this class shows the static map that Gau designed
public class Map extends Activity implements OnClickListener{
	
	Button back = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.map); // links the java file to its xml file
        
        // create back button and set onClickListener
        back = (Button)findViewById(R.id.back);
		back.setOnClickListener((android.view.View.OnClickListener) this);
    }

    public void onClick( View v ) {
    	// back button goes to MainActivity class and sets the color to RED when pressed
		if ( v == back ){
			back.setTextColor(Color.RED);
			Intent intent = new Intent(this, MainActivity.class);
			startActivity(intent);
		}
	}
}

