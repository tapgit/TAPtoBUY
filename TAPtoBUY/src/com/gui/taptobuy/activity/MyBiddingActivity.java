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

import com.gui.taptobuy.customadapter.BiddingsCustomListAdapter;
import com.gui.taptobuy.datatask.ImageDownload;
import com.gui.taptobuy.datatask.Main;
import com.gui.taptobuy.phase1.R;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MyBiddingActivity extends Activity{

	private ListView biddingList ;
	private LayoutInflater layoutInflator;
	public static ArrayList<ProductForAuction> biddingFromItem;

	@Override
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.emptylist);
		this.layoutInflator = LayoutInflater.from(this);
		this.biddingList = (ListView) findViewById(R.id.ViewList);	
		new searchProductsTask().execute("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

		//biddingFromItem = new ArrayList<ProductForAuction>();
		//	ProductForAuction item1 = new ProductForAuction(0, "hg", "ghg", 2.30, "kjhjk", "klkk", 3.5, 4.3, 5.6, 8);
		//	biddingFromItem.add(item1);
		//	biddingFromItem.add(item1);
		//biddingList.setAdapter(new BiddingsCustomListAdapter(this,this.layoutInflator, biddingFromItem));
	}

	public static class MyViewAuctionItem {
		public TextView productName, sellerUserName, priceAndShiping,bidsAmount,timeRemaining;
		public RatingBar sellerRating;		
		public ImageView itemPic;
		public ProductForAuction item;		

	}

	//edit name and url info
	private ArrayList<ProductForAuction> getSearchItems(String searchString){
		HttpClient httpClient = new DefaultHttpClient();
		String searchDir = Main.hostName +"/search/" + "aaaaaaaaaaaaaaaaaaaaa";
		HttpGet get = new HttpGet(searchDir);
		get.setHeader("content-type", "application/json");
		try
		{
			HttpResponse resp = httpClient.execute(get);
			if(resp.getStatusLine().getStatusCode() == 200){
				String jsonString = EntityUtils.toString(resp.getEntity());
				JSONArray searchResultArray = (new JSONObject(jsonString)).getJSONArray("results");
				biddingFromItem = new ArrayList<ProductForAuction>();

				JSONObject searchElement = null;
				JSONObject jsonItem = null;
				ProductForAuction anItem = null;

				for(int i=0; i<searchResultArray.length();i++){
					searchElement = searchResultArray.getJSONObject(i);
					jsonItem = searchElement.getJSONObject("item");
					if(searchElement.getBoolean("forBid")){
						anItem = new ProductForAuction(jsonItem.getInt("id"), jsonItem.getString("title"), jsonItem.getString("timeRemaining"), 
								jsonItem.getDouble("shippingPrice"), jsonItem.getString("imgLink"),  jsonItem.getString("sellerUsername"), 
								jsonItem.getDouble("sellerRate"),  jsonItem.getDouble("startinBidPrice"),  jsonItem.getDouble("currentBidPrice"),  jsonItem.getInt("totalBids"));

						biddingFromItem.add(anItem);
					}
				}

			}
			else{
				Log.e("JSON","search json could not be downloaded.");
			}
		}
		catch(Exception ex)
		{
			Log.e("Search","Error!", ex);
		}
		return biddingFromItem;
	}

	private class searchProductsTask extends AsyncTask<String,Void,ArrayList<ProductForAuction>> {
		public  int downloadadImagesIndex = 0;
		protected ArrayList<ProductForAuction> doInBackground(String... params) {
			return getSearchItems(params[0]);//get search result
		}
		protected void onPostExecute(ArrayList<ProductForAuction> biddingFromItem ) {
			//download images
			for(Product itm: biddingFromItem){
				new DownloadImageTask().execute(itm.getImgLink());
			}
			Toast.makeText(MyBiddingActivity.this,biddingFromItem.get(0).getSellerUsername() + "", Toast.LENGTH_LONG).show();
			//biddingList.setAdapter(new BiddingsCustomListAdapter(MyBiddingActivity.this, MyBiddingActivity.this.layoutInflator, biddingFromItem));
			biddingList.setAdapter(new BiddingsCustomListAdapter(MyBiddingActivity.this,MyBiddingActivity.this.layoutInflator, biddingFromItem));
		}			
		private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {

			protected Bitmap doInBackground(String... urls) {
				return ImageDownload.downloadImage(urls[0]);
			}
			protected void onPostExecute(Bitmap result) {
				biddingList.invalidateViews();
				biddingFromItem.get(downloadadImagesIndex++).setImg(result);
			}
		}
	}
}
