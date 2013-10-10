package com.gui.taptobuy.activity;

import com.gui.taptobuy.phase1.R;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class SellAnItemActivity extends Activity implements OnClickListener
{	
	private static final int SELECT_PICTURE = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		setContentView(R.layout.account_sellanitem);	 

	        ((Button) findViewById(R.id.sell_uploadPicB)).setOnClickListener(this);  
	        ((Button) findViewById(R.id.sell_sellItemB)).setOnClickListener(this); 
	         
	}

	@Override
	public void onClick(View v) {		
      		// in onCreate or any event where your want the user to
              // select a file
      		if (v.getId() == R.id.sell_uploadPicB)
      		{
      			 Intent getPic = new Intent();
      		        getPic.setType("image/*");
      		        getPic.setAction(Intent.ACTION_GET_CONTENT);
      		        startActivityForResult(Intent.createChooser(getPic,"Select Picture"), SELECT_PICTURE);    		     
      		 
      		}
      		      		
    		if(v.getId( )== R.id.sell_sellItemB){
    			Toast.makeText(this, "Your product has been put on sale", Toast.LENGTH_SHORT);
    		}
		  }
	
//	 public void onActivityResult(int requestCode, int resultCode, Intent data) {
//	        if (resultCode == RESULT_OK) {
//	            if (requestCode == SELECT_PICTURE) {
//	                Uri selectedImageUri = data.getData();
//
//	                //OI FILE Manager
//	                filemanagerstring = selectedImageUri.getPath();
//
//	                //MEDIA GALLERY
//	                selectedImagePath = getPath(selectedImageUri);
//
//	                //DEBUG PURPOSE - you can delete this if you want
//	                if(selectedImagePath!=null)
//	                    System.out.println(selectedImagePath);
//	                else System.out.println("selectedImagePath is null");
//	                if(filemanagerstring!=null)
//	                    System.out.println(filemanagerstring);
//	                else System.out.println("filemanagerstring is null");
//
//	                //NOW WE HAVE OUR WANTED STRING
//	                if(selectedImagePath!=null)
//	                    System.out.println("selectedImagePath is the right one for you!");
//	                else
//	                    System.out.println("filemanagerstring is the right one for you!");
//	            }
//	        }
//	    }
//
//	    public String getPath(Uri uri) {
//	      String selectedImagePath;
//	      //1:MEDIA GALLERY --- query from MediaStore.Images.Media.DATA
//	      String[] projection = { MediaStore.Images.Media.DATA };
//	      Cursor cursor = managedQuery(uri, projection, null, null, null);
//	      if(cursor != null){
//	          int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
//	          cursor.moveToFirst();
//	          selectedImagePath = cursor.getString(column_index);
//	      }else{
//	          selectedImagePath = null;
//	      }
//
//	      if(selectedImagePath == null){
//	          //2:OI FILE Manager --- call method: uri.getPath()
//	          selectedImagePath = uri.getPath();
//	      }
//	      return selectedImagePath;
//	  }
	
}