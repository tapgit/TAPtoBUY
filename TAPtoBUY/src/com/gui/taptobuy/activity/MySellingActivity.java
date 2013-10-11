package com.gui.taptobuy.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.gui.taptobuy.phase1.R;

public class MySellingActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.emptylist);
		
		
	}
	
	@Override
	public void onClick(View v) {
		switch(v.getId()){
		
		case R.id.mySell_BidList:///////////
			break;
		case R.id.mySell_AcceptBidB:
			break;
		case R.id.mySell_QuitB:
			Toast.makeText(this, "Your Item will be removed from sale", Toast.LENGTH_SHORT);
			break;
		}
		
	}
}
