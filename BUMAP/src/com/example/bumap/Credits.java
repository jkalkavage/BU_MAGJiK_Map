package com.example.bumap;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

// Credits class displays our team name, name of members, and course name + year
public class Credits extends Activity implements OnClickListener{

	Button main_menu;
	
    @Override
    // onCreate describes the onCreate stage in the Android Application LifeCycle
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); // to remove the default title header on interface
        setContentView(R.layout.credits);
        
        main_menu = (Button)findViewById(R.id.main_menu);
		main_menu.setOnClickListener((android.view.View.OnClickListener) this);
    }
    
	public void onClick(View v){
    if ( v == main_menu ){
    	main_menu.setTextColor(Color.RED);
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
    }
}
}