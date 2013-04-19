package com.doe.nutrininja;

import java.util.List;

import android.content.Context;
import android.view.Gravity;
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
	
	protected static double densityFactor = 1f;
	protected static int totalBrands = 0;

	public CategoryListAdapter(Context context, List<String> brands) {
		this.context = context;
		this.brands = brands;
		densityFactor = context.getResources().getDisplayMetrics().density;
		totalBrands = brands.size();
	}

	public int getCount() {
		return brands.size();
	}

	public Object getItem(int position) {
		return brands.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		String entry = brands.get(position);
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.brand_view, null);
		}

		TextView brand_name = (TextView) convertView.findViewById(R.id.brand_item);
		brand_name.setText(entry);
		brand_name.getViewTreeObserver().addOnGlobalLayoutListener(new MyGlobalLayoutListener(brand_name, position));
		
		return convertView;
	}

	class MyGlobalLayoutListener implements OnGlobalLayoutListener {
		private View view;
		private int position;

		public MyGlobalLayoutListener(View view, int position) {
			this.view = view;
			this.position = position;
		}

		public void onGlobalLayout() {
			double heightPercent = AisleViewActivity.brandListHeight * CategoryListAdapter.densityFactor;
			float baseTextSize = (float) (heightPercent * 0.025f);
			int fromBottom = CategoryListAdapter.totalBrands - position - 1;
			switch (fromBottom) {
			case 0:
				view.setBackgroundColor(0xFF2EB82E);
				view.getLayoutParams().height = (int )(0.25 * heightPercent);
				((TextView) view).setGravity(Gravity.CENTER_VERTICAL);
				((TextView) view).setTextSize(baseTextSize*2);
				break;
			case 1:
				view.setBackgroundColor(0xFFFFD633);
				view.getLayoutParams().height = (int )(0.25 * heightPercent);
				((TextView) view).setGravity(Gravity.CENTER_VERTICAL);
				((TextView) view).setTextSize(baseTextSize*2);
				break;
			case 2:
				view.setBackgroundColor(0xFF94FF70);
				view.getLayoutParams().height = (int )(0.15 * heightPercent);
				((TextView) view).setTextSize(baseTextSize*1.3f);
				break;
			case 3:
				view.setBackgroundColor(0xFFBFFFA9);
				view.getLayoutParams().height = (int )(0.13 * heightPercent);
				((TextView) view).setTextSize(baseTextSize*1.3f);
				break;
			case 4:
				view.setBackgroundColor(0xFFEAFFE2);
				view.getLayoutParams().height = (int )(0.12 * heightPercent);
				((TextView) view).setTextSize(baseTextSize);
				break;
			default:
				view.setBackgroundColor(0xFFF4FFF1);
				view.getLayoutParams().height = (int )(0.1 * heightPercent);
				((TextView) view).setTextSize(baseTextSize);
				break;
			}
		}
	}
}