package com.gui.taptobuy.customadapter;

import java.util.ArrayList;

import com.gui.taptobuy.Entities.Product;
import com.gui.taptobuy.activity.MyHistoryActivity;
import com.gui.taptobuy.activity.SearchActivity;
import com.gui.taptobuy.activity.MyBiddingActivity.MyViewAuctionItem;
import com.gui.taptobuy.phase1.R;


import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;


public class MyHistoryBoughtListCustomAdapter extends BaseAdapter implements OnClickListener {
	private MyHistoryActivity activity;
	private LayoutInflater layoutInflater;
	private ArrayList<Product> items;	

	public MyHistoryBoughtListCustomAdapter (MyHistoryActivity a, LayoutInflater l, ArrayList<Product> items)
	{
		this.activity = a;		
		this.layoutInflater = l;
		this.items = items;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View itemRow, ViewGroup parent) {
		// TODO Auto-generated method stub	MyViewAuctionItem itemHolder;
		Product item = items.get(position);
		
		itemRow = layoutInflater.inflate(R.layout.bidproduct_row, parent, false); return null;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

}
