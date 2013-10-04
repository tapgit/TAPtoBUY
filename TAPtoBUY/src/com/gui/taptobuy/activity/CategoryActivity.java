package com.gui.taptobuy.activity;
import java.util.ArrayList;
import java.util.List;

import com.gui.taptobuy.manager.CategoryManager;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class CategoryActivity extends ListActivity {	
	@Override
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);			
		setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1, CategoryManager.currentCategoriesNames));
	}

	protected void onListItemClick(ListView lv, View v, int position,long id){
		super.onListItemClick(lv, v, position, id);

		CategoryManager.goforward(position);
		Intent showSubCategories = new Intent("com.gui.taptobuy.phase1.CATEGORYACTIVITY");//el nombre del action
		this.startActivity(showSubCategories);
	}
	@Override
	protected void onRestart() {	
		super.onRestart();
		CategoryManager.goBack();
	}
}