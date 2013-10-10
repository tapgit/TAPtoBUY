package com.gui.taptobuy.activity;

import com.gui.taptobuy.Entities.ProductForSale;
import com.gui.taptobuy.phase1.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class BuyItProductInfoActivity extends Activity implements OnClickListener
{	

	public static ProductForSale SaleProduct;
	private Button buyNow;
	private Button addtoCart;
	private ImageView prodPic;
	private TextView prodTitle, prodId, prodTime, prodBrand, prodDimen, prodDescrip, prodSellerUserN, prodPriceAndShip;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);		
		setContentView(R.layout.productinfo_buynow);
		
		prodPic = (ImageView) findViewById(R.id.BuyInfoProdPic);
		prodTitle = (TextView) findViewById(R.id.BuyInfoProdTitle);
		prodId = (TextView) findViewById(R.id.BuyInfoProdID);
		prodTime = (TextView) findViewById(R.id.buyInfotimeleft);
		prodBrand = (TextView) findViewById(R.id.BuyInfoProdBrand);
		prodDimen = (TextView) findViewById(R.id.BuyInfoDimensions);
		prodDescrip = (TextView) findViewById(R.id.BuyInfoDescription);
		prodSellerUserN = (TextView) findViewById(R.id.BuyInfoSellerUserName);
		prodPriceAndShip = (TextView) findViewById(R.id.BuyInfoPrice);
		
		
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
