package com.gui.taptobuy.activity;

import com.gui.taptobuy.phase1.R;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class AccountSettingsActivity extends Activity implements OnClickListener {
	
	private Spinner cardsSpinner;
	private Dialog dialog;
	private Button setDef;
	private Button add;
	private Button remove;
	private Button save;
	
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		setContentView(R.layout.account_settings);
		
		setDef = (Button)findViewById(R.id.accSet_setDefaultCardB);
		add = (Button)findViewById(R.id.accSet_AddB);
		remove = (Button)findViewById(R.id.accSet_RemoveB);
		save = (Button)findViewById(R.id.accSet_SaveB);
		
		setDef.setOnClickListener(this);
		add.setOnClickListener(this);
		remove.setOnClickListener(this);
		save.setOnClickListener(this);
		
		cardsSpinner = (Spinner) findViewById (R.id.accSet_CardsSpinner);
		//creditCardsList sacarla del server -DB
		//ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice, creditCardsList);
		//cardsSpinner.setAdapter(adapter);


		// setting action for when an sorting instance is selected
		cardsSpinner.setOnItemSelectedListener(new OnItemSelectedListener(){	
			@Override
			public void onItemSelected(AdapterView<?> arg0,View arg1,int arg2, long arg3) 
			{
				int index = arg0.getSelectedItemPosition();									
			}
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {}	        	
		});
	}

	@Override
	public void onClick(View v) {
		
		
		switch (v.getId()){
		
		case R.id.accSet_setDefaultCardB:
			Toast.makeText(this, "Credit Card X has been place as default", Toast.LENGTH_LONG).show(); // X lo saco del spinner
			break;
			
		case R.id.accSet_AddB:
			
			dialog = new Dialog(AccountSettingsActivity.this);

			dialog.setContentView(R.layout.addcard_dialog);
			dialog.setTitle("Add Credit Card");

			final EditText CardNumET = (EditText) dialog.findViewById(R.id.addCard_CardNum);
			final EditText CardHolderET = (EditText) dialog.findViewById(R.id.addCard_HolderName);  
			final EditText CardExpDateET = (EditText) dialog.findViewById(R.id.addCard_ExpDate);        
			Button btnAdd = (Button) dialog.findViewById(R.id.addCardB);			
			btnAdd.setOnClickListener(new View.OnClickListener() {

				public void onClick(View v) 
				{			                
					String CardNum = CardNumET.getText().toString();
					String CardHolder = CardHolderET.getText().toString();
					String CardDate = CardExpDateET.getText().toString();
					if(!CardNum.equals("")||!CardHolder.equals("")||!CardExpDateET.equals("")){
						//add it to the server - Db  
						Toast.makeText(AccountSettingsActivity.this, "Successfully added", Toast.LENGTH_SHORT).show();
						dialog.dismiss();
					}	
					else{
						Toast.makeText(AccountSettingsActivity.this, "Error: You must fill every field", Toast.LENGTH_LONG).show();
					}					      				                
				}
			});    
			dialog.show();
			
			break;
			
		case R.id.accSet_RemoveB:
			Toast.makeText(this, "Successfully Removed", Toast.LENGTH_SHORT).show();	
			break;
		
		case R.id.accSet_SaveB:
			Toast.makeText(this, "Your settings had been updated", Toast.LENGTH_SHORT).show();
			break;		
		}
	}
}
