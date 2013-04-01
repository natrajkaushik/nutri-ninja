package com.doe.nutrininja;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AisleViewActivity extends Activity {
	public static final String TAG = "AISLE_VIEW_ACTIVITY";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.aisle_view);

		ListView listView = (ListView) findViewById(R.id.brand_list);

		String[] items = { "Turner Diary", "Publix", "American Diary",
				"Parmalat", "Shurfresh", "Prairie Farms" };

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, android.R.id.text1, items);

		// Assign adapter to ListView
		listView.setAdapter(adapter);
		
		View left_aisle = findViewById(R.id.left_aisle_rectangle);
		
		Log.d("TAG", left_aisle.getBackground().getBounds().flattenToString());
		
		
		View left_aisle_position_marker = findViewById(R.id.left_aisle_position_marker);
		
		//left_aisle_position_marker.setTop(100);
		left_aisle_position_marker.setVisibility(View.VISIBLE);
		left_aisle_position_marker.setBackgroundColor(Color.RED);
		//left_aisle_position_marker.set
		
		final Animation animation = new AlphaAnimation(1, 0); // Change alpha from fully visible to invisible
	    animation.setDuration(500); // duration - half a second
	    animation.setInterpolator(new LinearInterpolator()); // do not alter animation rate
	    animation.setRepeatCount(Animation.INFINITE); // Repeat animation infinitely
	    animation.setRepeatMode(Animation.REVERSE); // Reverse animation at the end so the button will fade back in
		
	    left_aisle_position_marker.setAnimation(animation);
	
	}

}
