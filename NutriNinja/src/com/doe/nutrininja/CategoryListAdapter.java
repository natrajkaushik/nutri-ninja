package com.doe.nutrininja;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CategoryListAdapter extends BaseAdapter {
	public static final String TAG = "CATEGORY_LIST_VIEW";

	private Context context;
	private List<String> brands;

	public CategoryListAdapter(Context context, List<String> brands) {
		// TODO Auto-generated constructor stub

		this.context = context;
		this.brands = brands;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return brands.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return brands.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		String entry = brands.get(position);
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.brand_view, null);
		}

		TextView brand_name = (TextView) convertView
				.findViewById(R.id.brand_item);
		brand_name.setText(entry);

		convertView.getViewTreeObserver().addOnGlobalLayoutListener(new MyGlobalLayoutListener(convertView, position));

		return convertView;
	}
	
	class MyGlobalLayoutListener implements OnGlobalLayoutListener{
		
		private View view;
		private int position;
		
		public MyGlobalLayoutListener(View view, int position) {
			// TODO Auto-generated constructor stub
			this.view = view;
			this.position = position;
		}
		
		@Override
		public void onGlobalLayout() {
			// TODO Auto-generated method stub
			switch (position) {
			case 0:
				view.setBackgroundColor(0xFFF4FFF1);
				view.getLayoutParams().height = 30;
				break;
			case 1:
				view.setBackgroundColor(0xFFEAFFE2);
				view.getLayoutParams().height = 33;
				break;
			case 2:
				view.setBackgroundColor(0xFFBFFFA9);
				view.getLayoutParams().height = 48;
				break;
			case 3:
				view.setBackgroundColor(0xFF94FF70);
				view.getLayoutParams().height = 40;
				break;
			case 4:
				view.setBackgroundColor(0xFFFFD633);
				view.getLayoutParams().height = 100;
				break;
			case 5:
				view.setBackgroundColor(0xFF2EB82E);
				view.getLayoutParams().height = 90;
				break;
			}
		}
		
	}

}
