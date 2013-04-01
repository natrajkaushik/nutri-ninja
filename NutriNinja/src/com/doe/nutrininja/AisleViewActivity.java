package com.doe.nutrininja;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AisleViewActivity extends Activity {

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
	}

}
