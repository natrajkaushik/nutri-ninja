package com.doe.nutrininja;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Adapter that extends BaseAdapter and maintains a list of custom objects and
 * returns the view for each object
 */
public class ItemListAdapter extends BaseAdapter {

	private Context context;
	private List<ItemLocation> itemLocations;

	public ItemListAdapter(Context context, List<ItemLocation> itemLocations) {
		super();
		this.context = context;
		this.itemLocations = itemLocations;
	}

	@Override
	public int getCount() {
		return itemLocations.size();
	}

	@Override
	public Object getItem(int position) {
		return itemLocations.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup viewGroup) {
		ItemLocation entry = itemLocations.get(position);
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.item_view, null);
		}

		TextView item_name = (TextView) convertView
				.findViewById(R.id.item_name);
		item_name.setText(entry.getItem());

		TextView aisle = (TextView) convertView.findViewById(R.id.aisle);
		aisle.setText(entry.getAisle());
		
		return convertView;
	}

}
