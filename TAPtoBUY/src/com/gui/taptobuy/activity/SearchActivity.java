package com.gui.taptobuy.activity;


import java.util.ArrayList;

import com.gui.taptobuy.customadapter.ItemCustomAdapter;
import com.gui.taptobuy.manager.CategoryManager;
import com.gui.taptobuy.phase1.R;
import com.gui.taptobuy.views.Product;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
	//private boolean searchDone;
	private ArrayList<Product> itemsOnSale;
	private ListView itemsList;
	private LayoutInflater layoutInflator;
	/////////////////////////////////////////////
	private Product item1;
	private Product item2;
	private Product item3,item4,item5,item6,item7,item8;
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
		item1 = new Product(true,001,4,pic,"$190.50","$154.00","lumia","nokia","5.2 x 3 inches","new, unopend, factory unlocked","Einstein","free shipping","Nokia sasda 920 black 32gb","Phones","10/12/2013","10/1/2014");
		item2 = new Product(false,002,5,pic,"$10","$154.00","lumia","nokia","5.2 x 3 inches","new, unopend, factory unlocked","Gauss","free shipping","Nokia SHAshasha 920 black 32gb","Phones","10/12/2013","10/1/2014");
		item3 = new Product(true,003,10,pic,"$100000","$154.00","lumia","nokia","5.2 x 3 inches","new, unopend, factory unlocked","Tesla","free shipping","Nokia charmin! 920 black 32gb","Phones","10/12/2013","10/1/2014");
		item4 = new Product(false,002,5,pic,"$10","$154.00","lumia","nokia","5.2 x 3 inches","new, unopend, factory unlocked","Newton","free shipping","Nokia SHAshasha 920 black 32gb","Phones","10/12/2013","10/1/2014");
		item5 = new Product(true,003,10,pic,"$100000","$154.00","lumia","nokia","5.2 x 3 inches","new, unopend, factory unlocked","kido","free shipping","Nokia charmin! 920 black 32gb","Phones","10/12/2013","10/1/2014");
		item6 = new Product(false,003,10,pic,"$100000","$154.00","lumia","nokia","5.2 x 3 inches","new, unopend, factory unlocked","kevin","free shipping","Nokia charmin! 920 black 32gb","Phones","10/12/2013","10/1/2014");
		item7 = new Product(true,002,5,pic,"$10","$154.00","lumia","nokia","5.2 x 3 inches","new, unopend, factory unlocked","joshua","free shipping","Nokia SHAshasha 920 black 32gb","Phones","10/12/2013","10/1/2014");
		item8 = new Product(false,003,10,pic,"$100000","$154.00","lumia","nokia","5.2 x 3 inches","new, unopend, factory unlocked","efra","free shipping","Nokia charmin! 920 black 32gb","Phones","10/12/2013","10/1/2014");
		
		itemsOnSale = new ArrayList<Product>();
		itemsOnSale.add(item1);
		itemsOnSale.add(item2);
		itemsOnSale.add(item3);
		itemsOnSale.add(item4);
		itemsOnSale.add(item5);
		itemsOnSale.add(item6);
		itemsOnSale.add(item7);
		itemsOnSale.add(item8);
		
		///////////////////////////////////////////////////////////////////////////////////////
		categories = (Button)findViewById(R.id.bCategories);
		cart = (Button)findViewById(R.id.bCart);
		search = (Button)findViewById(R.id.bSearch);
		signOut = (Button)findViewById(R.id.bSignOut);
		myTap = (Button)findViewById(R.id.bMyTap);			
		signIn = (Button)findViewById(R.id.bSignIn);
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

			CategoryManager.getCategories();//download categories (initialize)    		
			startActivity(new Intent(this, CategoryActivity.class));   		
			break;

		case R.id.bMyTap:
			startActivity(new Intent(this, MyTapActivity.class));  
			break;

		case R.id.bSearch:
			setItems(itemsOnSale);
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
			signInEnabler();			         
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
	private void signInEnabler()
	{
		SignInActivity.signed = false;
		signIn.setVisibility(View.VISIBLE);
		signOut.setVisibility(View.GONE);
		myTap.setVisibility(View.GONE);  
	} 
	
	public static class MyViewItem {
		public TextView productName, sellerUserName, priceAndShiping,bidsAmount,timeRemaining;
		public RatingBar sellerRating;
		public TextView buyItNow;
		public ImageView itemPic;
		public Product item;
	}

	public void setItems(ArrayList<Product> items) {
		this.itemsList.setAdapter(new ItemCustomAdapter(this,this.pic,this.layoutInflator, this.itemsOnSale));
	}
}
