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
import android.widget.ListView;

public class AisleViewActivity extends Activity {
	public static final String TAG = "AISLE_VIEW_ACTIVITY";
	/*
	private static final int EVENT_PERIOD = 25;

	private View left_aisle_position_marker;
	private View right_aisle_position_marker;

	private float[] gravity = new float[3];
	private float[] geomag = new float[3];
	private float[] orientation = new float[3];
	private float[] sI = new float[16];
	private float[] sR = new float[16];
	private int eventCount = 0;
	private boolean facingNorth = true;
	*/
	private static final Animation BLINK_ANIMATION = new AlphaAnimation(1, 0);
	static {
		BLINK_ANIMATION.setDuration(500); 							// duration - half a second
	    BLINK_ANIMATION.setInterpolator(new LinearInterpolator());	// do not alter BLINK_ANIMATION rate
	    BLINK_ANIMATION.setRepeatCount(Animation.INFINITE);			// Repeat BLINK_ANIMATION infinitely
	    BLINK_ANIMATION.setRepeatMode(Animation.REVERSE);			// Reverse BLINK_ANIMATION at the end
	}
	
	// private int leftAisleHeight = 0;
	// private int rightAisleHeight = 0;
	private double densityFactor = 1f;
	public static int brandListHeight = 0;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		densityFactor = getResources().getDisplayMetrics().density;
		
		setContentView(R.layout.aisle_view);
		
		final ListView listView = (ListView) findViewById(R.id.brand_list);
		listView.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
			public void onGlobalLayout() {
				Log.d(TAG, "Brand List Height : " + listView.getHeight());
				brandListHeight = (int) (listView.getHeight() / densityFactor);
			}
		});
		
		String[] items = { "Prairie Farms", "Shurfresh", "Parmalat", "American Diary", "Publix", "Turner Diary"};
		CategoryListAdapter categoryListAdapter = new CategoryListAdapter(this, Arrays.asList(items));
		listView.setAdapter(categoryListAdapter);
		/*
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
		
		left_aisle_position_marker = findViewById(R.id.left_aisle_position_marker);
		right_aisle_position_marker = findViewById(R.id.right_aisle_position_marker);
		*/
	}
	
	protected void onResume() {
		super.onResume();
		
		View topLevelView = findViewById(R.id.top_level_view);
		topLevelView.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
			public void onGlobalLayout() {
			    // redrawMarker(left_aisle_position_marker, leftAisleHeight, 0.15, 0.25);
			    // redrawMarker(right_aisle_position_marker, rightAisleHeight, 0.60, 0.25);
			    // monitorCompassChanges();
			}
		});
	}

	/*
	private void redrawMarker(View marker, int height, double posFraction, double lenFraction) {
		FrameLayout.LayoutParams params = ((FrameLayout.LayoutParams) marker.getLayoutParams());
		params.height = (int) ((height * lenFraction) * densityFactor);
		params.topMargin = (int) ((height * posFraction) * densityFactor);
	}
	
	private void monitorCompassChanges() {
		SensorManager sMan = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		Sensor magnetField = sMan.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
		SensorEventListener magnetListener = new SensorEventListener() {
			public void onSensorChanged(SensorEvent event) {
				geomag = event.values.clone();
				processSensorData();
			}
			public void onAccuracyChanged(Sensor sensor, int accuracy) {}
		};
		Sensor accelerometer = sMan.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		SensorEventListener accListener = new SensorEventListener() {
			public void onSensorChanged(SensorEvent event) {
				gravity = event.values.clone();
				processSensorData();
			}
			public void onAccuracyChanged(Sensor sensor, int accuracy) {}
		};
		sMan.registerListener(magnetListener, magnetField, SensorManager.SENSOR_DELAY_NORMAL);
		sMan.registerListener(accListener, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
	}
	
	private void processSensorData() {
		SensorManager.getRotationMatrix(sR, sI, gravity, geomag);
		SensorManager.getOrientation(sR, orientation);
		// toggleAisleMarker();
	}
	
	private void toggleAisleMarker() {
		eventCount++;
		if (eventCount >= EVENT_PERIOD) {
			eventCount = 0;
			float azimuthInRadians = Math.abs(orientation[0]);
			if ((azimuthInRadians < 1.57) ^ facingNorth) {
				facingNorth = !facingNorth;
				if (facingNorth) {
					right_aisle_position_marker.setAnimation(null);
					right_aisle_position_marker.setVisibility(View.INVISIBLE);
					left_aisle_position_marker.setAnimation(BLINK_ANIMATION);
					left_aisle_position_marker.setVisibility(View.VISIBLE);
				}
				else {
					left_aisle_position_marker.setAnimation(null);
					left_aisle_position_marker.setVisibility(View.INVISIBLE);
					right_aisle_position_marker.setAnimation(BLINK_ANIMATION);
					right_aisle_position_marker.setVisibility(View.VISIBLE);
				}
			}
		}
	}
	*/
}