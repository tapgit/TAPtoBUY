package com.gui.taptobuy.activity;

import com.gui.taptobuy.manager.CategoryManager;
import com.gui.taptobuy.phase1.R;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;

public class SignInActivity extends Activity implements View.OnClickListener {

	private Button cartB;
	private Button categoriesB;
	private Button signInB;
	private Button signOutB;
	private Button registerB;
	private Button bSearch;
	private TextView signInText;
	private ImageView signOutPic;
	private TextView registerText;
	public static boolean signed = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signin_home);

		cartB = (Button) findViewById(R.id.bCart);
		categoriesB = (Button) findViewById(R.id.bCategories);
		signInB = (Button) findViewById(R.id.bSign_in);
		registerB = (Button) findViewById(R.id.bRegister); 
		bSearch = (Button) findViewById(R.id.bSearch);
		signOutB = (Button) findViewById(R.id.bSign_Out);
		signInText = (TextView)findViewById(R.id.textSign_in);
		signOutPic = (ImageView)findViewById(R.id.signOutPic);
		registerText = (TextView)findViewById(R.id.textRegister);
		
		bSearch.setOnClickListener(this);
		cartB.setOnClickListener(this);
		categoriesB.setOnClickListener(this);
		signInB.setOnClickListener(this);
		registerB.setOnClickListener(this);
		signOutB.setOnClickListener(this);	
		
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		if(SignInActivity.signed){			
			signInB.setVisibility(View.GONE);
			signInText.setVisibility(View.GONE);
			registerB.setVisibility(View.GONE);
			registerText.setVisibility(View.GONE);
			signOutB.setVisibility(View.VISIBLE);
			signOutPic.setVisibility(View.VISIBLE);		
		}		
	}

	@Override
	public void onClick(View v) { 
		
		final Dialog dialog = new Dialog(SignInActivity.this);
    	
    	dialog.setContentView(R.layout.login_dialog);
        dialog.setTitle("Sign in");
        
        final EditText username = (EditText) dialog.findViewById(R.id.etNameToLogin);
        final EditText password = (EditText) dialog.findViewById(R.id.etPasswordToLogin);        
        Button btnSignIn = (Button) dialog.findViewById(R.id.bSignIn);

		switch( v.getId() ) {

		case R.id.bCart:
			if(!signed){
			
				  btnSignIn.setOnClickListener(new View.OnClickListener() {
			            
			            public void onClick(View v) 
			            {			                
			            	String userID = username.getText().toString();
			        		String userPassword = password.getText().toString();
			        		
			        		if(userID.equals("") || userPassword.equals("")){
			        			Toast.makeText(SignInActivity.this, "Error, you must provide userID & password", Toast.LENGTH_SHORT).show();			                    
			        		}
			        		else if(!userID.equals(userPassword)){
								Toast.makeText(SignInActivity.this, "Incorrect Password or User", Toast.LENGTH_SHORT).show();								
							}
			        		else if(userID.equals(userPassword)){     		
				        		Toast.makeText(SignInActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();				        		
				        		signInDisabler();
				        		dialog.dismiss();             
				                startActivity(new Intent(SignInActivity.this,CartActivity.class)); 				                
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
			// deben estar dentro de un try catch todos los startActivity

			CategoryManager.getCategories();//download categories (initialize)    		
			startActivity(new Intent(this, CategoryActivity.class));   		
			break;

		case R.id.bSign_in:			       
	        
	         btnSignIn.setOnClickListener(new View.OnClickListener() 
	         {	            
	            public void onClick(View v) 
	            {	              
	            	String userID = username.getText().toString();
	        		String userPassword = password.getText().toString();
	        		
	        		if(userID.equals("") || userPassword.equals("")){
	        			Toast.makeText(SignInActivity.this, "Error, you must provide userID & password", Toast.LENGTH_SHORT).show();	                   
	        		}
	        		else if(!userID.equals(userPassword)){
						Toast.makeText(SignInActivity.this, "Incorrect Password or User", Toast.LENGTH_SHORT).show();								
					}
	        		else if(userID.equals(userPassword)){      		
		        		Toast.makeText(SignInActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();		        	
		        		signInDisabler();
		        		dialog.dismiss();		              	                
						startActivity(new Intent(SignInActivity.this, SearchActivity.class));					
		        	}
	             }
	        });    
	         dialog.show();
	         break;

		case R.id.bRegister:			
			startActivity(new Intent(this, RegisterActivity.class));
			break;

		case R.id.bSearch:    
			startActivity(new Intent(this, SearchActivity.class));			
			break;
			
		case R.id.bSign_Out:			
			signInEnabler();
			break;
		}
	}
	
	private void signInDisabler()
	{
		signed = true;
		signInB.setVisibility(View.GONE);
		signInText.setVisibility(View.GONE);
		registerB.setVisibility(View.GONE);
		registerText.setVisibility(View.GONE);
		signOutB.setVisibility(View.VISIBLE);
		signOutPic.setVisibility(View.VISIBLE);
	}
	private void signInEnabler()
	{
		signed = false;
		signInB.setVisibility(View.VISIBLE);
		signInText.setVisibility(View.VISIBLE);
		registerB.setVisibility(View.VISIBLE);
		registerText.setVisibility(View.VISIBLE);
		signOutB.setVisibility(View.GONE);
		signOutPic.setVisibility(View.GONE);
	} 
}