package com.gui.taptobuy.activity;
import com.gui.taptobuy.Entities.ProductForAuction;
import com.gui.taptobuy.phase1.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class BidProductInfoActivity extends Activity implements OnClickListener{

	private Button placeBid;
	private EditText bidInput;
	public static ProductForAuction BidProduct;	
	private ImageView prodPic;
	private TextView prodTitle, prodId, prodTime, prodBrand, prodDimen, prodDescrip, prodSellerUserN, prodPrice, prodShipPrice;
	@Override
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);		
		setContentView(R.layout.productinfo_bid);
		
		prodPic = (ImageView) findViewById(R.id.BidInfoProdPic);
		prodTitle = (TextView) findViewById(R.id.BidInfoProdTitle);
		prodId = (TextView) findViewById(R.id.BidInfoProdID);
		prodTime = (TextView) findViewById(R.id.BidInfoTimeLeft);
		prodBrand = (TextView) findViewById(R.id.BidInfoProdBrand);
		prodDimen = (TextView) findViewById(R.id.BidInfoDimensions);
		prodDescrip = (TextView) findViewById(R.id.BidInfoDescription);
		prodSellerUserN = (TextView) findViewById(R.id.BidInfoUserName);
		prodPrice = (TextView) findViewById(R.id.BidInfoPlaceBidInput);
		prodShipPrice = (TextView) findViewById(R.id.BidInfoShippingPrice);
		
		
		placeBid = (Button) findViewById(R.id.BidInfoPlaceBidb);
		bidInput = (EditText) findViewById(R.id.BidInfoPlaceBidInput);
		placeBid.setOnClickListener(this);
		bidInput.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		if(v.getId() == R.id.BidInfoPlaceBidb){
			//chakiar si la cantidad entrada en bid input es valida
			if(!bidInput.getText().equals("")){				
			Toast.makeText(this, "Bid "+bidInput.getText().toString()+" has been placed", Toast.LENGTH_SHORT).show();
			//anadir producto a Mybidding y aumentar el num de bids y current bid del producto
			}
			else{
				Toast.makeText(this, "Error: you must provide a bidding quantity", Toast.LENGTH_LONG).show();
			}
		}		
	}
}
