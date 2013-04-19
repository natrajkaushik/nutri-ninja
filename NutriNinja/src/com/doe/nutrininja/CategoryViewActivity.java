package com.doe.nutrininja;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class CategoryViewActivity extends Activity {
	public static final String TAG = "CATEGORY_VIEW_ACTIVITY";
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.list_view);

        ListView list = (ListView) findViewById(R.id.items_list);

        List<ItemLocation> itemLocations = new ArrayList<ItemLocation>();
        for (int i = 0; i < ItemData.ITEMS.length; i++) {
        	itemLocations.add(new ItemLocation(ItemData.ITEMS[i], ItemData.AISLES[i]));
        }

        ItemListAdapter adapter = new ItemListAdapter(this, itemLocations);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> arg0, View view, int position, long index) {
				Log.d(TAG, "Clicked: " + index);
				Intent intent = new Intent(CategoryViewActivity.this, AisleViewActivity.class);
				intent.putExtra("index", (int)index);
				startActivity(intent);
			}
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}