package com.gui.taptobuy.activity;

import com.gui.taptobuy.phase1.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class BuyItProductInfoActivity extends Activity implements OnClickListener
{	
	private Button buyNow;
	private Button addtoCart;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);		
		setContentView(R.layout.productinfo_buynow);
		
		buyNow = (Button) findViewById(R.id.BuyInfoBuyNowb);
		buyNow.setOnClickListener(this);
		addtoCart = (Button) findViewById(R.id.BuyInfoAddToCartb);
		addtoCart.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		
		if(v.getId() == R.id.BuyInfoBuyNowb){
			startActivity(new Intent(this, OrderCheckoutActivity.class));
		}
		else if(v.getId()== R.id.BuyInfoAddToCartb){
			//envia el producto para el servidor con Id del carrito producto y usuario
			Toast.makeText(this, "This product has been added to your Cart", Toast.LENGTH_LONG).show();
		}		
	}

}
