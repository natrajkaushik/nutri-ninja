package com.doe.nutrininja;

import java.util.Arrays;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ListView;

public class AisleViewActivity extends Activity {
	public static final String TAG = "AISLE_VIEW_ACTIVITY";
	
	private static final Animation BLINK_ANIMATION = new AlphaAnimation(1, 0);
	static {
		BLINK_ANIMATION.setDuration(500); 							// duration - half a second
	    BLINK_ANIMATION.setInterpolator(new LinearInterpolator());	// do not alter BLINK_ANIMATION rate
	    BLINK_ANIMATION.setRepeatCount(Animation.INFINITE);			// Repeat BLINK_ANIMATION infinitely
	    BLINK_ANIMATION.setRepeatMode(Animation.REVERSE);			// Reverse BLINK_ANIMATION at the end
	}
	
	private int leftAisleHeight = 0;
	private int rightAisleHeight = 0;
	private double densityFactor = 1f;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		densityFactor = getResources().getDisplayMetrics().density;
		
		setContentView(R.layout.aisle_view);

		String[] items = { "Prairie Farms", "Shurfresh", "Parmalat", "American Diary", "Publix", "Turner Diary"};
		CategoryListAdapter categoryListAdapter = new CategoryListAdapter(this, Arrays.asList(items));
		/* ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, android.R.id.text1, items); */
		ListView listView = (ListView) findViewById(R.id.brand_list);
		listView.setAdapter(categoryListAdapter);
		
		final FrameLayout left_aisle_frame = (FrameLayout) findViewById(R.id.left_aisle);
		left_aisle_frame.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
			public void onGlobalLayout() {
				Log.d(TAG, "Left height: " + left_aisle_frame.getHeight());
				leftAisleHeight = (int) (left_aisle_frame.getHeight() / densityFactor);
			}
		});
		
		final FrameLayout right_aisle_frame = (FrameLayout) findViewById(R.id.right_aisle);
		right_aisle_frame.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
			public void onGlobalLayout() {
				Log.d(TAG, "Right height: " + right_aisle_frame.getHeight());
				rightAisleHeight = (int) (right_aisle_frame.getHeight() / densityFactor);
			}
		});
		
		View left_aisle_position_marker = findViewById(R.id.left_aisle_position_marker);
		left_aisle_position_marker.setVisibility(View.VISIBLE);
	    left_aisle_position_marker.setAnimation(BLINK_ANIMATION);
		
		View right_aisle_position_marker = findViewById(R.id.right_aisle_position_marker);
		right_aisle_position_marker.setVisibility(View.VISIBLE);
	    right_aisle_position_marker.setAnimation(BLINK_ANIMATION);
	}
	
	protected void onResume() {
		super.onResume();
		
		View topLevelView = findViewById(R.id.top_level_view);
		topLevelView.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
			public void onGlobalLayout() {
				Log.d(TAG, "Redrawing markers...");
				View left_aisle_position_marker = findViewById(R.id.left_aisle_position_marker);
				View right_aisle_position_marker = findViewById(R.id.right_aisle_position_marker);
			    redrawMarker(left_aisle_position_marker, leftAisleHeight, 0.30, 0.25);
			    redrawMarker(right_aisle_position_marker, rightAisleHeight, 0.60, 0.30);
			}
		});
	}

	private void redrawMarker(View marker, int height, double posFraction, double lenFraction) {
		FrameLayout.LayoutParams params = ((FrameLayout.LayoutParams) marker.getLayoutParams());
		params.height = (int) ((height * lenFraction) * densityFactor);
		params.topMargin = (int) ((height * posFraction) * densityFactor);
	}
}