package com.gui.taptobuy.activity;

import com.gui.taptobuy.Entities.Product;
import com.gui.taptobuy.Entities.ProductForAuctionInfo;
import com.gui.taptobuy.Entities.ProductForSaleInfo;
import com.gui.taptobuy.phase1.R;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SellAnItemActivity extends Activity implements OnClickListener
{	
	private static final int SELECT_PICTURE = 1;
	private EditText picPathInput;
	private EditText prodTitle;
	private int prodID = -1;
	private double sellerRate = -1;
	private String sellerUsername = null;
	private EditText prodModel;
	private EditText prodBrand;
	private EditText prodDimen;
	private TextView prodDescrip;
	private EditText prodProduct;
	private EditText prodBuyPriceIn;
	private EditText prodStartingPrice;
	private EditText shippingPrice;
	private EditText prodTime;
	private EditText prodQty;
	private CheckBox forBidCheck;
	private Product newProd;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		
		super.onCreate(savedInstanceState);
		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		setContentView(R.layout.account_sellanitem);	 

	        ((Button) findViewById(R.id.sell_uploadPicB)).setOnClickListener(this);  
	        ((Button) findViewById(R.id.sell_sellItemB)).setOnClickListener(this); 
        
	        picPathInput = (EditText) findViewById(R.id.sell_picPath);
	        prodTitle = (EditText) findViewById(R.id.sell_inputProdTitle);
	        prodQty = (EditText) findViewById(R.id.sell_inputQty);
	        prodModel = (EditText) findViewById(R.id.sell_inputModel);
	        prodProduct = (EditText) findViewById(R.id.sell_inputProduct);
	        prodBrand = (EditText) findViewById(R.id.sell_inputBrand);
	        prodDimen = (EditText) findViewById(R.id.sell_inputDimensions);
	        prodDescrip = (EditText) findViewById(R.id.sell_inputDescription);
	        prodBuyPriceIn = (EditText) findViewById(R.id.sell_inputBuyNowPrice);
	        prodStartingPrice = (EditText) findViewById(R.id.sell_inputStartingPrice);
	        shippingPrice = (EditText) findViewById(R.id.sell_inputShipping);	        
	        prodTime = (EditText) findViewById(R.id.sell_inputNumofDays);
	        forBidCheck = (CheckBox) findViewById(R.id.sell_ForBiddingCheck);        
	         
	        forBidCheck.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {	
		
			if(v.getId() == R.id.sell_ForBiddingCheck){
				if(!forBidCheck.isChecked()){
					prodBuyPriceIn.setClickable(false);
				}
			}
				
      		// in onCreate or any event where your want the user to
            //   select a file
      		if (v.getId() == R.id.sell_uploadPicB)
      		{
      			 Intent getPic = new Intent();
      		        getPic.setType("image/*");
      		        getPic.setAction(Intent.ACTION_GET_CONTENT);
      		        startActivityForResult(Intent.createChooser(getPic,"Select Picture"), SELECT_PICTURE);    		     
      		 
      		}
      		      		
    		if(v.getId() == R.id.sell_sellItemB){
    			if(forBidCheck.isChecked()){
    				newProd = new ProductForAuctionInfo(prodID, prodTitle.getText().toString(),prodTime.getText().toString(), Double.parseDouble(shippingPrice.getText().toString()), 
    						 picPathInput.getText().toString(), sellerUsername, sellerRate,  Double.parseDouble(shippingPrice.getText().toString()), 
    						 -1, -1, prodProduct.getText().toString(), prodModel.getText().toString(), prodBrand.getText().toString(), prodDimen.getText().toString(), prodDescrip.getText().toString());    				
    				//add to server
    			}
    			else{    	    				
    				
    				newProd = new ProductForSaleInfo(prodID, prodTitle.getText().toString(),prodTime.getText().toString(), Double.parseDouble(shippingPrice.getText().toString()), 
   						 picPathInput.getText().toString(), sellerUsername, sellerRate, Integer.parseInt(prodQty.getText().toString()), Double.parseDouble(prodBuyPriceIn.getText().toString()),
   						 prodProduct.getText().toString(), prodModel.getText().toString(), prodBrand.getText().toString(), prodDimen.getText().toString(), prodDescrip.getText().toString());
    						    						
   			//add to server
    			}
    			Toast.makeText(this, "Your product has been put on sale", Toast.LENGTH_SHORT).show();
    		}
		  }
	
//	 public void onActivityResult(int requestCode, int resultCode, Intent data) {
//	        if (resultCode == RESULT_OK) {
//	            if (requestCode == SELECT_PICTURE) {
//	                Uri selectedImageUri = data.getData();
//
//	                //OI FILE Manager
//	                filemanagerstring = selectedImageUri.getPath();
//
//	                //MEDIA GALLERY
//	                selectedImagePath = getPath(selectedImageUri);
//
//	                //DEBUG PURPOSE - you can delete this if you want
//	                if(selectedImagePath!=null)
//	                    System.out.println(selectedImagePath);
//	                else System.out.println("selectedImagePath is null");
//	                if(filemanagerstring!=null)
//	                    System.out.println(filemanagerstring);
//	                else System.out.println("filemanagerstring is null");
//
//	                //NOW WE HAVE OUR WANTED STRING
//	                if(selectedImagePath!=null)
//	                    System.out.println("selectedImagePath is the right one for you!");
//	                else
//	                    System.out.println("filemanagerstring is the right one for you!");
//	            }
//	        }
//	    }
//
//	    public String getPath(Uri uri) {
//	      String selectedImagePath;
//	      //1:MEDIA GALLERY --- query from MediaStore.Images.Media.DATA
//	      String[] projection = { MediaStore.Images.Media.DATA };
//	      Cursor cursor = managedQuery(uri, projection, null, null, null);
//	      if(cursor != null){
//	          int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
//	          cursor.moveToFirst();
//	          selectedImagePath = cursor.getString(column_index);
//	      }else{
//	          selectedImagePath = null;
//	      }
//
//	      if(selectedImagePath == null){
//	          //2:OI FILE Manager --- call method: uri.getPath()
//	          selectedImagePath = uri.getPath();
//	      }
//	      return selectedImagePath;
//	  }
	
}