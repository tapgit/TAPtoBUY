package com.gui.taptobuy.activity;

import com.gui.taptobuy.manager.CategoryManager;
import com.gui.taptobuy.phase1.R;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;
import android.os.AsyncTask;
import android.util.Log;
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
        
        final EditText usernameET = (EditText) dialog.findViewById(R.id.etNameToLogin);
        final EditText passwordET = (EditText) dialog.findViewById(R.id.etPasswordToLogin);        
        Button btnSignIn = (Button) dialog.findViewById(R.id.bSignIn);

		switch( v.getId() ) {

		case R.id.bCart:
			if(!signed){
			
				  btnSignIn.setOnClickListener(new View.OnClickListener() {
			            
			            public void onClick(View v) 
			            {			                
			            	String userID = usernameET.getText().toString();
			        		String userPassword = passwordET.getText().toString();
			        		
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
		//			
//			if(SignIn.doSignIn(this)){
//				signInDisabler();
//				startActivity(new Intent(this, SearchActivity.class));
//			}
//			goSignIn(); 
			
			Button dlgBtnSignIn = (Button) dialog.findViewById(R.id.bSignIn);	
			dlgBtnSignIn.setOnClickListener(new View.OnClickListener() 
			{	
				public void onClick(View v) 
				{	
					String username = usernameET.getText().toString();
					String password = passwordET.getText().toString();
					if(username.equals("") || password.equals("")){
						Toast.makeText(SignInActivity.this, "Error, you must provide userID & password", Toast.LENGTH_SHORT).show();			
					}	
					new DoSignInTask().execute(username,password);
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
	public class DoSignInTask extends AsyncTask<String,Integer,Boolean> {
		
	    @Override
		protected void onPreExecute() {
			super.onPreExecute();
			
		}

		protected Boolean doInBackground(String... params) {
	    	
	    	boolean result = true;
	    	
	    	HttpClient httpClient = new DefaultHttpClient();
	        
			HttpPost post = new HttpPost("http://10.0.2.2:9000/login");
			post.setHeader("content-type", "application/json");
			
			try
	        {
				//Construimos el objeto cliente en formato JSON
				JSONObject userData = new JSONObject();
				
				//dato.put("Id", Integer.parseInt(txtId.getText().toString()));
				userData.put("username", params[0]);
				userData.put("password", params[1]);
				
				StringEntity entity = new StringEntity(userData.toString());
				post.setEntity(entity);
				
	        	HttpResponse resp = httpClient.execute(post);
	        	if(resp.getStatusLine().getStatusCode() == 200){
	        		result = true;
	        	}
	        	else{
	        		result = false;
	        	}
	        }
	        catch(Exception ex)
	        {
	        	Log.e("ServicioRest","Error!", ex);
	        	result = false;
	        }
	 
	        return result;
	    }
	    
	    protected void onPostExecute(Boolean result) {
	    	
	    	if (result)
	    	{
				Toast.makeText(SignInActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
				signInDisabler();
	    	}
	    	else{
				Toast.makeText(SignInActivity.this, "Incorrect Password or User", Toast.LENGTH_SHORT).show();
				signInEnabler();
	    	}
	    }
	}
}