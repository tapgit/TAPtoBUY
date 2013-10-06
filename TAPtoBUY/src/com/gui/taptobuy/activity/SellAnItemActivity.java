package com.gui.taptobuy.activity;

import com.gui.taptobuy.phase1.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;

public class SellAnItemActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		setContentView(R.layout.account_sellanitem);
	}

}
