package com.gui.taptobuy.activity;

import java.util.ArrayList;

import com.gui.taptobuy.Entities.Product;
import com.gui.taptobuy.customadapter.BiddingsCustomListAdapter;
import com.gui.taptobuy.customadapter.MyHistoryBoughtListCustomAdapter;
import com.gui.taptobuy.phase1.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

public class MyHistoryActivity extends Activity{
	public  ArrayList<Product> historyBoughtItems;
	public  ArrayList<Product> historySoldItems;
	private ListView itemsList;
	private LayoutInflater layoutInflator;

	@Override
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.account_myhistory);
		this.layoutInflator = LayoutInflater.from(this);
		this.itemsList = (ListView) findViewById(R.id.myHistory_boughtItems);
		itemsList.invalidateViews();		
		itemsList.setAdapter(new MyHistoryBoughtListCustomAdapter(this,this.layoutInflator, historyBoughtItems));
		this.itemsList = (ListView) findViewById(R.id.myHistory_SoldItems);
		itemsList.invalidateViews();		
		itemsList.setAdapter(new MyHistoryBoughtListCustomAdapter(this,this.layoutInflator, historySoldItems));
		
	}
	
	public static class MyViewHistory {
		public TextView productName, sellerUserName, priceAndShiping,bidsAmount,wonOr,buyerUserN;
		public RatingBar sellerRating;		
		public ImageView itemPic;
		public Product item;		

		}
}
