package com.gui.taptobuy.activity;

import java.util.ArrayList;

import com.gui.taptobuy.Entities.Product;
import com.gui.taptobuy.Entities.ProductForAuction;
import com.gui.taptobuy.customadapter.BiddingsCustomListAdapter;

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

public class MyBiddingActivity extends Activity{

	private ListView biddingList ;
	private LayoutInflater layoutInflator;
	private ArrayList<ProductForAuction> biddingFromItem;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.emptylist);
		this.layoutInflator = LayoutInflater.from(this);
		this.biddingList = (ListView) findViewById(R.id.ViewList);
		biddingList.invalidateViews();
		biddingList.setAdapter(new BiddingsCustomListAdapter(this,this.layoutInflator, biddingFromItem));
	}
	
	public static class MyViewAuctionItem {
		public TextView productName, sellerUserName, priceAndShiping,bidsAmount,timeRemaining;
		public RatingBar sellerRating;		
		public ImageView itemPic;
		public Product item;		
		
	}
}
