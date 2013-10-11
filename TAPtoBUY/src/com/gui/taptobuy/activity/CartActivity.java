package com.gui.taptobuy.activity;

import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import com.gui.taptobuy.Entities.Product;
import com.gui.taptobuy.Entities.ProductForAuction;
import com.gui.taptobuy.Entities.ProductForSale;


import com.gui.taptobuy.datatask.ImageDownload;
import com.gui.taptobuy.datatask.Main;
import com.gui.taptobuy.phase1.R;
import com.gui.taptobuy.phase1.R.layout;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

public class CartActivity extends Activity implements OnClickListener{	
	private ArrayList<ProductForSale> cartItems;
	private Button buyB;
	private Button buySelectedB;
	private Button removeB;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);		
		setContentView(R.layout.cart);
		
//		buyB = (Button) findViewById(R.id.cartBuyNowB);
//		buyB.setOnClickListener(this);
//		
//		buySelectedB = (Button) findViewById(R.id.cartBuySelectedB);
//		buySelectedB.setOnClickListener(this);
//		
//		removeB = (Button) findViewById(R.id.);
//		removeB.setOnClickListener(this);

		
	
	}
	

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}
	
//	
//	private ArrayList<ProductForSale> getCartItems(String searchString){
//		HttpClient httpClient = new DefaultHttpClient();
//		String searchDir = Main.hostName +"/cart/" + Main.userId;
//		HttpGet get = new HttpGet(searchDir);
//		get.setHeader("content-type", "application/json");
//		try
//		{
//			HttpResponse resp = httpClient.execute(get);
//			if(resp.getStatusLine().getStatusCode() == 200){
//				String jsonString = EntityUtils.toString(resp.getEntity());
//				JSONArray cartResultArray = (new JSONObject(jsonString)).getJSONArray("cart");
//				cartItems = new ArrayList<ProductForSale>();
//
//				JSONObject searchElement = null;
//				JSONObject jsonItem = null;
//				ProductForSale anItem = null;
//
//				for(int i=0; i<cartResultArray.length();i++){
//					searchElement = cartResultArray.getJSONObject(i);
//					jsonItem = searchElement.getJSONObject("item");
//						anItem = new ProductForSale(jsonItem.getInt("id"), jsonItem.getString("title"), jsonItem.getString("timeRemaining"), 
//								jsonItem.getDouble("shippingPrice"), jsonItem.getString("imgLink"),  jsonItem.getString("sellerUsername"), 
//								jsonItem.getDouble("sellerRate"), jsonItem.getInt("remainingQuantity"), jsonItem.getDouble("instantPrice"));
//				
//					cartItems.add(anItem);
//				}
//
//			}
//			else{
//				Log.e("JSON","search json could not be downloaded.");
//			}
//		}
//		catch(Exception ex)
//		{
//			Log.e("Search","Error!", ex);
//		}
//		return cartItems;
//	}
//
//	private class searchProductsTask extends AsyncTask<String,Void,ArrayList<ProductForSale>> {
//		public  int downloadadImagesIndex = 0;
//		protected ArrayList<ProductForSale> doInBackground(String... params) {
//			return getCartItems(params[0]);//get search result
//		}
//		protected void onPostExecute(ArrayList<Product> searchResultItems ) {
//			//download images
//			for(Product itm: searchResultItems){
//				new DownloadImageTask().execute(itm.getImgLink());
//			}
//			itemsList.setAdapter(new ItemCustomListAdapter(CartActivity.this,CartActivity.this.layoutInflator, searchResultItems));
//		}			
//		private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
//
//			protected Bitmap doInBackground(String... urls) {
//				return ImageDownload.downloadImage(urls[0]);
//			}
//			protected void onPostExecute(Bitmap result) {
//				itemsList.invalidateViews();
//				searchResultItems.get(downloadadImagesIndex++).setImg(result);
//			}
//		}
//	}


}
