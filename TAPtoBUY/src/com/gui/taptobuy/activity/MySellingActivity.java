package com.gui.taptobuy.activity;

import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.graphics.Bitmap;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;

import android.widget.ListView;

import com.gui.taptobuy.Entities.Product;
import com.gui.taptobuy.Entities.ProductForAuction;

import com.gui.taptobuy.customadapter.BiddingsCustomListAdapter;
import com.gui.taptobuy.customadapter.MySellingListCustomAdapter;
import com.gui.taptobuy.datatask.ImageDownload;
import com.gui.taptobuy.datatask.Main;

import com.gui.taptobuy.phase1.R;

public class MySellingActivity extends Activity  {
 private ListView list;
 private LayoutInflater layoutInflator;
 private ArrayList<Product> itemsList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.emptylist);		
		list = (ListView)findViewById(R.id.ViewList);	
		this.layoutInflator = LayoutInflater.from(this);
		list.setAdapter(new MySellingListCustomAdapter(this,this.layoutInflator, itemsList));
		list.invalidateViews();
	//	new searchProductsTask().execute("aaaaaaaaaaaaaaaaaaaaa");
	}	
	
//	private ArrayList<ProductForAuction> getSearchItems(String searchString){
//		HttpClient httpClient = new DefaultHttpClient();
//		String searchDir = Main.hostName +"/search/" + "aaaaaaaaaaaaaaaaaaaaa";
//		HttpGet get = new HttpGet(searchDir);
//		get.setHeader("content-type", "application/json");
//		try
//		{
//			HttpResponse resp = httpClient.execute(get);
//			if(resp.getStatusLine().getStatusCode() == 200){
//				String jsonString = EntityUtils.toString(resp.getEntity());
//				JSONArray searchResultArray = (new JSONObject(jsonString)).getJSONArray("results");
//				itemsList = new ArrayList<Product>();
//
//				JSONObject searchElement = null;
//				JSONObject jsonItem = null;
//				ProductForAuction anItem = null;
//
//				for(int i=0; i<searchResultArray.length();i++){
//					searchElement = searchResultArray.getJSONObject(i);
//					jsonItem = searchElement.getJSONObject("item");
//					if(searchElement.getBoolean("forBid")){
//						anItem = new ProductForAuction(jsonItem.getInt("id"), jsonItem.getString("title"), jsonItem.getString("timeRemaining"), 
//								jsonItem.getDouble("shippingPrice"), jsonItem.getString("imgLink"),  jsonItem.getString("sellerUsername"), 
//								jsonItem.getDouble("sellerRate"),  jsonItem.getDouble("startinBidPrice"),  jsonItem.getDouble("currentBidPrice"),  jsonItem.getInt("totalBids"));
//					}
//				
//					itemsList.add(anItem);
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
//		return itemsList;
//	}
//
//	private class searchProductsTask extends AsyncTask<String,Void,ArrayList<ProductForAuction>> {
//		public  int downloadadImagesIndex = 0;
//		protected ArrayList<ProductForAuction> doInBackground(String... params) {
//			return getSearchItems(params[0]);//get search result
//		}
//		protected void onPostExecute(ArrayList<Product> searchResultItems ) {
//			//download images
//			for(Product itm: searchResultItems){
//				new DownloadImageTask().execute(itm.getImgLink());
//			}
//			biddingList.setAdapter(new BiddingsCustomListAdapter(MyBiddingActivity.this, MyBiddingActivity.this.layoutInflator, itemsList));
//		}			
//		private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
//
//			protected Bitmap doInBackground(String... urls) {
//				return ImageDownload.downloadImage(urls[0]);
//			}
//			protected void onPostExecute(Bitmap result) {
//				biddingList.invalidateViews();
//				itemsList.get(downloadadImagesIndex++).setImg(result);
//			}
//		}
//	}
}
