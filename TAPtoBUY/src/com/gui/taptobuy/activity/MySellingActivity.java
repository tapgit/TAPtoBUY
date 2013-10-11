package com.gui.taptobuy.activity;

import java.util.ArrayList;

import android.app.Activity;

import android.os.Bundle;
import android.view.LayoutInflater;

import android.widget.ListView;

import com.gui.taptobuy.Entities.Product;
import com.gui.taptobuy.customadapter.MySellingListCustomAdapter;

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
	}	
}
