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
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.list_view);

        ListView list = (ListView) findViewById(R.id.items_list);

        List<ItemLocation> itemLocations = new ArrayList<ItemLocation>();
        itemLocations.add(new ItemLocation("Milk", "3"));
        itemLocations.add(new ItemLocation("Yogurt", "3"));
        itemLocations.add(new ItemLocation("Almond Milk", "4"));
        itemLocations.add(new ItemLocation("Cashew Nuts", "5"));
        itemLocations.add(new ItemLocation("Salmon", "6"));
        itemLocations.add(new ItemLocation("Olive Oil", "8"));
        itemLocations.add(new ItemLocation("Bread", "9"));

        ItemListAdapter adapter = new ItemListAdapter(this, itemLocations);

        list.setAdapter(adapter);
        
        list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int position,
					long index) {
				Log.d("ON_CLICK_ITEM", "click");
				Intent intent = new Intent(CategoryViewActivity.this, AisleViewActivity.class);
				startActivity(intent);
			}
        
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
