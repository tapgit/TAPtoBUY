package com.gui.taptobuy.activity;


import java.util.ArrayList;
import java.util.Iterator;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import com.gui.taptobuy.Entities.Category;
import com.gui.taptobuy.Entities.Item;
import com.gui.taptobuy.Entities.Product;
import com.gui.taptobuy.Entities.ProductForAuction;
import com.gui.taptobuy.Entities.ProductForSale;
import com.gui.taptobuy.customadapter.CategoriesCustomListAdapter;
import com.gui.taptobuy.customadapter.ItemCustomListAdapter;
import com.gui.taptobuy.phase1.R;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SearchActivity extends Activity implements OnClickListener   {

	private String[] sortingOptions;
	private Button categories;
	private Button cart;
	private Button search;
	private Button signIn;
	private Button signOut;
	private Button myTap;	
	private Spinner sorter;
	private EditText searchET;
	//private boolean searchDone;
	private ArrayList<Product> itemsOnSale;
	private ListView itemsList;
	private LayoutInflater layoutInflator;
	/////////////////////////////////////////////

	//private Item item1, item2, item3,item4,item5,item6,item7,item8;
	private Product item;
	private ImageView pic;
	/////////////////////////////////////////////////
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);	
		setContentView(R.layout.search);
		/////////////////////////////////////////////////////////////////////////////////
				pic = (ImageView)findViewById(R.id.BuyItProductPic);
				itemsOnSale = new ArrayList<Product>();
				Intent myIntent = getIntent();
				
				//Toast.makeText(this,myIntent.getStringExtra("toSearch"),Toast.LENGTH_LONG).show();
				
		//		item1 = new Item(true,001,4,pic,"$190.50","$154.00","lumia","nokia","5.2 x 3 inches","new, unopend, factory unlocked","Einstein","free shipping","Nokia sasda 920 black 32gb","Phones","10/12/2013","10/1/2014");
		//		item2 = new Item(false,002,5,pic,"$10","$154.00","lumia","nokia","5.2 x 3 inches","new, unopend, factory unlocked","Gauss","free shipping","Nokia SHAshasha 920 black 32gb","Phones","10/12/2013","10/1/2014");
		//		item3 = new Item(true,003,10,pic,"$100000","$154.00","lumia","nokia","5.2 x 3 inches","new, unopend, factory unlocked","Tesla","free shipping","Nokia charmin! 920 black 32gb","Phones","10/12/2013","10/1/2014");
		//		item4 = new Item(false,002,5,pic,"$10","$154.00","lumia","nokia","5.2 x 3 inches","new, unopend, factory unlocked","Newton","free shipping","Nokia SHAshasha 920 black 32gb","Phones","10/12/2013","10/1/2014");
		//		item5 = new Item(true,003,10,pic,"$100000","$154.00","lumia","nokia","5.2 x 3 inches","new, unopend, factory unlocked","kido","free shipping","Nokia charmin! 920 black 32gb","Phones","10/12/2013","10/1/2014");
		//		item6 = new Item(false,003,10,pic,"$100000","$154.00","lumia","nokia","5.2 x 3 inches","new, unopend, factory unlocked","kevin","free shipping","Nokia charmin! 920 black 32gb","Phones","10/12/2013","10/1/2014");
		//		item7 = new Item(true,002,5,pic,"$10","$154.00","lumia","nokia","5.2 x 3 inches","new, unopend, factory unlocked","joshua","free shipping","Nokia SHAshasha 920 black 32gb","Phones","10/12/2013","10/1/2014");
		//		item8 = new Item(false,003,10,pic,"$100000","$154.00","lumia","nokia","5.2 x 3 inches","new, unopend, factory unlocked","efra","free shipping","Nokia charmin! 920 black 32gb","Phones","10/12/2013","10/1/2014");
		//		
		//		itemsOnSale = new ArrayList<Item>();
		//		itemsOnSale.add(item1);
		//		itemsOnSale.add(item2);
		//		itemsOnSale.add(item3);
		//		itemsOnSale.add(item4);
		//		itemsOnSale.add(item5);
		//		itemsOnSale.add(item6);
		//		itemsOnSale.add(item7);
		//		itemsOnSale.add(item8);
		
//		item = new ProductForSale(0, "iphone 5s", "3d 7h", false, 0, "iphone", "5s", "apple", "100x35", "brand new", "http:image","kido" , (float) 4.5, 10, 7, 670.45);
//		itemsOnSale.add(item);

		///////////////////////////////////////////////////////////////////////////////////////
		categories = (Button)findViewById(R.id.bCategories);
		cart = (Button)findViewById(R.id.bCart);
		search = (Button)findViewById(R.id.bSearch);
		signOut = (Button)findViewById(R.id.bSignOut);
		myTap = (Button)findViewById(R.id.bMyTap);			
		signIn = (Button)findViewById(R.id.bSignIn);
		searchET= (EditText) findViewById(R.id.searchText);
		itemsList = (ListView)findViewById(R.id.itemsListView);
		this.layoutInflator = LayoutInflater.from(this);

		signIn.setOnClickListener(this);
		categories.setOnClickListener(this);		
		cart.setOnClickListener(this);
		search.setOnClickListener(this);
		signOut.setOnClickListener(this);
		myTap.setOnClickListener(this);	

		if(SignInActivity.signed){
			signIn.setVisibility(View.GONE);		
		}
		else{
			signOut.setVisibility(View.GONE);
			myTap.setVisibility(View.GONE);
		}

		//setting the spinner
		sortingOptions = getResources().getStringArray(R.array.sortBy);   
		sorter = (Spinner) findViewById (R.id.SortSpinner);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice, sortingOptions);
		sorter.setAdapter(adapter);

	

		// setting action for when an sorting instance is selected
		sorter.setOnItemSelectedListener(new OnItemSelectedListener(){	
			@Override
			public void onItemSelected(AdapterView<?> arg0,View arg1,int arg2, long arg3) 
			{
				int index = arg0.getSelectedItemPosition();
				switch (index)
				{						
				case 0: // by name
					//supongo que decirle al db y obtenerlo sorteado luego settiar el view de nuevo con los
					// items ya sorted...
					break;
				case 1: // by price
					break;
				case 2: // by brand
				}						
			}
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {}	        	
		});

		/////////////////////// check above define products
		// setItems(itemsOnSale);
	}//end of on create method

	@Override
	public void onClick(View v) { 

		final Dialog dialog = new Dialog(SearchActivity.this);

		dialog.setContentView(R.layout.login_dialog);
		dialog.setTitle("Sign in");

		final EditText usernameID_ET = (EditText) dialog.findViewById(R.id.etNameToLogin);
		final EditText passwordET = (EditText) dialog.findViewById(R.id.etPasswordToLogin);        
		Button btnSignIn = (Button) dialog.findViewById(R.id.bSignIn);

		switch (v.getId())
		{		
		case R.id.bCart:			
			if(!SignInActivity.signed){

				btnSignIn.setOnClickListener(new View.OnClickListener() {

					public void onClick(View v) 
					{			                
						String userID = usernameID_ET.getText().toString();
						String userPassword = passwordET.getText().toString();

						if(userID.equals("") || userPassword.equals("")){
							Toast.makeText(SearchActivity.this, "Error, you must provide userID & password", Toast.LENGTH_SHORT).show();			                    
						}
						else if(!userID.equals(userPassword)){
							Toast.makeText(SearchActivity.this, "Incorrect Password or User", Toast.LENGTH_SHORT).show();								
						}
						else if(userID.equals(userPassword)){     		
							Toast.makeText(SearchActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();				        		
							signInDisabler();
							dialog.dismiss();             
							startActivity(new Intent(SearchActivity.this,CartActivity.class)); 				                
						}
					}
				});    
				dialog.show();				
			}
			else{
				startActivity(new Intent(this, CartActivity.class));
			}
			break;


		case R.id.bCategories:

			startActivity(new Intent(this, CategoryActivity.class));   		
			break;

		case R.id.bMyTap:
			startActivity(new Intent(this, MyTapActivity.class));  
			break;

		case R.id.bSearch:
			//itemsList.setAdapter(new ItemCustomListAdapter(this,this.pic,this.layoutInflator, this.itemsOnSale));
			new searchProductsTask().execute(searchET.getText().toString());
			break;

		case R.id.bSignIn:		
			btnSignIn.setOnClickListener(new View.OnClickListener() {

				public void onClick(View v) 
				{	          
					String userID = usernameID_ET.getText().toString();
					String userPassword = passwordET.getText().toString();

					if(userID.equals("") || userPassword.equals("")){
						Toast.makeText(SearchActivity.this, "Error, you must provide userID & password", Toast.LENGTH_SHORT).show();			                    
					}
					else if(!userID.equals(userPassword)){
						Toast.makeText(SearchActivity.this, "Incorrect Password or User", Toast.LENGTH_SHORT).show();								
					}
					else if(userID.equals(userPassword)){     		
						Toast.makeText(SearchActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();				        		
						signInDisabler();
						dialog.dismiss(); 		                				                
					}
				}
			});    
			dialog.show();				
			break;

		case R.id.bSignOut:
			SignInActivity.signed = false;
			Intent home = new Intent(this, SignInActivity.class);
			home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(home);			

			break;
		}
	}

	private void signInDisabler()
	{
		SignInActivity.signed = true;
		signIn.setVisibility(View.GONE);
		signOut.setVisibility(View.VISIBLE);
		myTap.setVisibility(View.VISIBLE);
	}

	public static class MyViewItem {
		public TextView productName, sellerUserName, priceAndShiping,bidsAmount,timeRemaining;
		public RatingBar sellerRating;
		public TextView buyItNow;
		public ImageView itemPic;
		public Product item;
		public CheckBox check;
		public Button cartBuy;
		public Button cartRemove;
	}	
	private ArrayList<Product> getSearchItems(String searchString){
		HttpClient httpClient = new DefaultHttpClient();
		String searchDir = "http://10.0.2.2:9000/search/" + searchString;
		HttpGet get = new HttpGet(searchDir);
		get.setHeader("content-type", "application/json");
		try
		{
			HttpResponse resp = httpClient.execute(get);
			//if(resp.getStatusLine().getStatusCode() == 200){
				String jsonString = EntityUtils.toString(resp.getEntity());
				JSONObject json = new JSONObject(jsonString);
				itemsOnSale = new ArrayList<Product>();		
				
				//				String tmpCatName = "";
				//				Iterator<String> iter = (Iterator<String>) json.keys();
				//				while(iter.hasNext()){
				//					tmpCatName = String.valueOf(iter.next());
				//					showingCategories.add(new Category(tmpCatName,json.getBoolean(tmpCatName)));
				//				}
				
				JSONObject aSearchRes = null;
				JSONObject item = null;
				Product tempProduct = null;

				for(int i=0;i<json.length();i++){
					aSearchRes = json.getJSONObject("item-00" + i);
					if(aSearchRes.getBoolean("forBid")){
						item = aSearchRes.getJSONObject("item");
						tempProduct = new ProductForAuction(item.getInt("id"), item.getString("title"), item.getString("timeDuration"), item.getBoolean("timeEnded"), 
								item.getDouble("shippingPrice"), item.getString("product"), item.getString("model"), item.getString("brand"),  item.getString("dimensions"),
								item.getString("description"), item.getString("imgLink"), item.getString("sellerUsername"), item.getDouble("sellerRate"), 
								item.getDouble("startinBidPrice"), item.getDouble("currentBidPrice"), item.getInt("totalBids"), item.getDouble("bidRate"));
					}
					else{
						item = aSearchRes.getJSONObject("item");
						tempProduct = new ProductForSale(item.getInt("id"), item.getString("title"), item.getString("timeDuration"), item.getBoolean("timeEnded"), 
								item.getDouble("shippingPrice"), item.getString("product"), item.getString("model"), item.getString("brand"),  item.getString("dimensions"),
								item.getString("description"), item.getString("imgLink"), item.getString("sellerUsername"), item.getDouble("sellerRate"), 
								item.getInt("startingQuantity"),item.getInt("remainingQuantity"), item.getDouble("instantPrice"));
					}
					itemsOnSale.add(tempProduct);
				}
//
//			}
//			else{
//				Log.e("JSON","search json could not be downloaded.");
//			}
		}
		catch(Exception ex)
		{
			Log.e("Search","Error!", ex);
		}
		return itemsOnSale;
	}

	private class searchProductsTask extends AsyncTask<String,Void,ArrayList<Product>> {

		protected ArrayList<Product> doInBackground(String... params) {
			return getSearchItems(params[0]);//get search result
		}

		protected void onPostExecute(ArrayList<Product> searchResult ) {
			itemsList.setAdapter(new ItemCustomListAdapter(SearchActivity.this,SearchActivity.this.pic,SearchActivity.this.layoutInflator, searchResult));
		}
	}
}
