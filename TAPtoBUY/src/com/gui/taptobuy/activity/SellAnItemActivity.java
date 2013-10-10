package com.gui.taptobuy.activity;

import com.gui.taptobuy.phase1.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class SellAnItemActivity extends Activity implements OnClickListener
{	
	private static final int SELECT_PICTURE = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		setContentView(R.layout.account_sellanitem);	 

	        ((Button) findViewById(R.id.sell_uploadPicB)).setOnClickListener(this);  
	        ((Button) findViewById(R.id.sell_sellItemB)).setOnClickListener(this); 
	         
	}

	@Override
	public void onClick(View v) {		
      		// in onCreate or any event where your want the user to
              // select a file
      		if (v.getId() == R.id.sell_uploadPicB)
      		{
      			 Intent getPic = new Intent();
      		        getPic.setType("image/*");
      		        getPic.setAction(Intent.ACTION_GET_CONTENT);
      		        startActivityForResult(Intent.createChooser(getPic,"Select Picture"), SELECT_PICTURE);
      		}
      		      		
    		if(v.getId( )== R.id.sell_sellItemB){
    			Toast.makeText(this, "Your product has been put on sale", Toast.LENGTH_SHORT);
    		}
		  }
	}