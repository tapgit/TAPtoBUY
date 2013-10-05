package com.gui.taptobuy.activity;

import com.gui.taptobuy.phase1.R;
import com.gui.taptobuy.phase1.R.id;
import com.gui.taptobuy.phase1.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends Activity {

	private EditText userFirstName;
	private EditText userLastName;
	private EditText userCountry;
	private EditText userStreetAdd;
	private EditText userCity;
	private EditText userState;
	private EditText userZipCode;
	private EditText userCelNum;
	private EditText userEmail;
	private EditText userName;
	private EditText userPassword1;
	private EditText userPassword2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		setContentView(R.layout.user_register);		
		initialize();		
	}

	private void initialize() {
		// TODO Auto-generated method stub
		
		userFirstName = (EditText) findViewById(R.id.etUserNameF);
		userLastName = (EditText) findViewById(R.id.etUserNameL);
		userCountry = (EditText) findViewById(R.id.etUserCountry);
		userStreetAdd = (EditText) findViewById(R.id.etUserStreetAdd);
		userCity = (EditText) findViewById(R.id.etUserCity);
		userState = (EditText) findViewById(R.id.etUserState);
		userZipCode = (EditText) findViewById(R.id.etUserZipCode);
		userCelNum = (EditText) findViewById(R.id.etUserCelNum);
		userEmail = (EditText) findViewById(R.id.etUserEmail);
		userName = (EditText) findViewById(R.id.etUserName);
		userPassword1 = (EditText) findViewById(R.id.etUserPassword1);
		userPassword2 = (EditText) findViewById(R.id.etUserPassword2);		
		Button submitInf = (Button) findViewById(R.id.bSubmitUserInf);
		submitInf.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				if(v.equals((Button) findViewById(R.id.bSubmitUserInf)))
				{
	        		String password1 = userPassword1.getText().toString();
	        		String password2 = userPassword2.getText().toString();
					
					if( password1.equals(password2) ) {
						Toast.makeText(RegisterActivity.this, "You are now a member! :D", Toast.LENGTH_LONG).show();										
	//					Intent intent = new Intent(UserRegister.this, Home.class);
	//	                startActivity(intent);					
					}
					else {
					
						Toast.makeText(RegisterActivity.this, "Passwords don't match, try again", Toast.LENGTH_LONG).show();			
					}		
				}
			}       	
        });	
	}
}
