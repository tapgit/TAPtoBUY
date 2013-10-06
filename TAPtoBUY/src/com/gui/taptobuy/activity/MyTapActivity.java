package com.gui.taptobuy.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.gui.taptobuy.phase1.R;

public class MyTapActivity extends Activity implements View.OnClickListener {
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);			
		setContentView(R.layout.mytap);
	}

	@Override
	public void onClick(View button) {
		
		switch (button.getId()){
		
		case R.id.myTap_sellAnItem:
			startActivity(new Intent(this, SellAnItemActivity.class));
			break;
		
		
		case R.id.myTap_MySellings:
			startActivity(new Intent(this, MySellingActivity.class));
			break;
		
		
		case R.id.myTap_BiddingItems:
			startActivity(new Intent(this, MyBiddingActivity.class));
			break;
		
		
		case R.id.myTap_MyHistory:
			startActivity(new Intent(this, MyHistoryActivity.class));
			break;
		}
		
	}
}
