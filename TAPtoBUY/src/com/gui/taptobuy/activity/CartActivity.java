package com.gui.taptobuy.activity;

import java.util.ArrayList;

import com.gui.taptobuy.Entities.Product;
import com.gui.taptobuy.phase1.R;
import com.gui.taptobuy.phase1.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

public class CartActivity extends Activity 
{		
	private ArrayList<Product> itemsOnCart;
	private Button buyB;
	private Button removeB;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);		
		setContentView(R.layout.cart);
		///////////////////////
		itemsOnCart = SearchActivity.itemsOnSale;
	
	}

}
