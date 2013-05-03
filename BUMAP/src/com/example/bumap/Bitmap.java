package com.example.bumap;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

/*
The Bitmap class describes the activity that "pins" the location of a specified building in the Search activity
Gau's customized map was converted into a bitmap in order to access the bitmap's methods, specifically to be able
to "pin" locations of buildings using a red dot.
We were having trouble getting the red dot appearing on the emulator even though it displayed on an Anroid phone
( Samsung Galaxy Nexus ) correctly. The solution was to convert a PNG image into a bitmap and then use the 
canvas.drawBit method in order to pin the pixel location of the specified building. This method was tested on the
emulator and was not displaying the red marker correctly. Both methods proved successful when implemented
on our Android device.
*/

// Bitmap class uses the OnClickListener for its back and main_menu buttons
public class Bitmap extends Activity implements OnClickListener{
	Button back = null, main_menu = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); // to not show title bar; MUST BE BEFORE setContentView in order to avoid error
        setContentView(R.layout.bitmap);
        
        // create the back button and set the OnClickListener to it
        back = (Button)findViewById(R.id.back);
		back.setOnClickListener((android.view.View.OnClickListener) this);
		
		// create the main menu button and set the OnClickListener to it
		main_menu = (Button)findViewById(R.id.main_menu);
		main_menu.setOnClickListener((android.view.View.OnClickListener) this);
		
        // Get x and y coordinates from DisplaySearchResults
        Intent intent = getIntent();
        int xcoord = intent.getIntExtra(DisplaySearchResults.XCOORD, 200);
        int ycoord = intent.getIntExtra(DisplaySearchResults.YCOORD, 200);

        // convert an imageView into a bitmap to access bitmap class' methods
        ImageView image = (ImageView) findViewById(R.id.imageView1);
        android.graphics.Bitmap bMap = BitmapFactory.decodeResource(getResources(), R.drawable.map_final);
        android.graphics.Bitmap myBitmap = bMap.copy(Config.ARGB_8888, true);
        image.setImageBitmap(myBitmap);
        
        //convert a square PNG file into a bitmap to use as the marker for the map ( an attempt to solve
        //the non-displaying red circle on the emulator
        //android.graphics.Bitmap square = BitmapFactory.decodeResource(getResources(), R.drawable.square);
        //android.graphics.Bitmap mysquare = square.copy(Config.ARGB_8888, true);
        
        // Only displays marker if building is not out of bounds
        if ( xcoord != 0 && ycoord != 0){
        Paint paint = new Paint(); // used to change colors for canvas methods
        paint.setColor(Color.RED); // making the dot red
        Canvas canvas = new Canvas(myBitmap); // creating a new canvas with the bitmap
        canvas.drawCircle(xcoord, ycoord, 10, paint); // drawing a red circle with x, y, radius
        //canvas.drawBitmap(mysquare, xcoord, ycoord, paint);
        };
    }
    
    // assigns instructions for the main menu and back buttons
    public void onClick( View v ) {
 			if( v == main_menu ){
 				main_menu.setTextColor(Color.RED);
 				Intent myIntent = new Intent(v.getContext(), MainActivity.class ); 
 				startActivityForResult( myIntent, 0 );
 		}
 			if ( v == back ){
 				back.setTextColor(Color.RED);
 				this.finish();
 		}
}
}


/*package com.example.bumap;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
 
public class Bitmap extends Activity implements OnClickListener{
	Button back = null, main_menu = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); // to not show title bar; MUST BE BEFORE setContentView in order to avoid error
        setContentView(R.layout.bitmap);
        
        back = (Button)findViewById(R.id.back);
		back.setOnClickListener((android.view.View.OnClickListener) this);
		
		main_menu = (Button)findViewById(R.id.main_menu);
		main_menu.setOnClickListener((android.view.View.OnClickListener) this);
		
        // Get x and y coordinates from DisplaySearchResults
        Intent intent = getIntent();
        int xcoord = intent.getIntExtra(DisplaySearchResults.XCOORD, 200);
        int ycoord = intent.getIntExtra(DisplaySearchResults.YCOORD, 200);

        // convert an imageView into a bitmap to access bitmap class' methods
        ImageView image = (ImageView) findViewById(R.id.imageView1);
        android.graphics.Bitmap bMap = BitmapFactory.decodeResource(getResources(), R.drawable.map_final);
        android.graphics.Bitmap myBitmap = bMap.copy(Config.ARGB_8888, true);
        image.setImageBitmap(myBitmap);
        
        android.graphics.Bitmap square = BitmapFactory.decodeResource(getResources(), R.drawable.square);
        android.graphics.Bitmap mySquare = square.copy(Config.ARGB_8888, true);
        
        // Adjusts a problem with the emulator screen not registering the pixels properly 
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		float logicalDensity = metrics.density;
		float Xdp =  ((xcoord +120) / logicalDensity);
		float Ydp =  ((ycoord +20) / logicalDensity);
		
        // Only displays marker if building is not out of bounds
        if ( xcoord != 0 && ycoord != 0){
	        Paint paint = new Paint(); // used to change colors for canvas methods
	        paint.setColor(Color.RED); // making the dot red
	        Canvas canvas = new Canvas(myBitmap); // creating a new canvas with the bitmap
	        canvas.drawBitmap(mySquare, Xdp, Ydp, paint);
        };
    }

    public void onClick( View v ) {
 			if( v == main_menu ){
 				Intent myIntent = new Intent(v.getContext(), MainActivity.class ); 
 				startActivityForResult( myIntent, 0 );
 		}
 			if ( v == back ){
 				this.finish();
 			}
}
}
*/

        