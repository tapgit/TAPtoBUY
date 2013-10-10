package com.gui.taptobuy.customadapter;

import java.util.ArrayList;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.gui.taptobuy.Entities.Product;
import com.gui.taptobuy.Entities.ProductForSale;
import com.gui.taptobuy.activity.BidProductInfoActivity;
import com.gui.taptobuy.activity.BuyItProductInfoActivity;
import com.gui.taptobuy.activity.CartActivity;
import com.gui.taptobuy.activity.SearchActivity.MyViewItem;
import com.gui.taptobuy.phase1.R;

public class CartCustomListAdapter extends BaseAdapter implements OnClickListener{
	
	private CartActivity activity;
	//private IconTask imgFetcher;  -- clases que usa para loadear las imagenes
	private ImageView itemPic;
	private LayoutInflater layoutInflater;
	private ArrayList<ProductForSale> items;	
	
    public CartCustomListAdapter (CartActivity a, LayoutInflater l, ArrayList<ProductForSale> items)
    {
    	this.activity = a;    	
    	this.layoutInflater = l;
    	this.items = items;
    }
  ////////////////////////////////////////////////////////// 
    @Override
    public int getCount() {
        return this.items.size();
    }

    @Override
    public boolean areAllItemsEnabled () 
    {
    	return true;
    }
    
    @Override
    public Object getItem(int arg0) {
        return null;
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }
///////////////////////////////////////////////////////////////////////
    @Override
    public View getView(int position, View itemRow, ViewGroup parent) {
        MyViewItem itemHolder;
        ProductForSale item = items.get(position);
            	
                 itemRow = layoutInflater.inflate(R.layout.cart_productrow, parent, false); 
                 itemHolder = new MyViewItem();
                 itemHolder.itemPic =  (ImageView) itemRow.findViewById(R.id.cartProductPic);
                 itemHolder.productName = (TextView) itemRow.findViewById(R.id.cartProdName);
                 itemHolder.sellerUserName = (TextView) itemRow.findViewById(R.id.cartSellerUsername);
                 itemHolder.priceAndShiping = (TextView) itemRow.findViewById(R.id.cartPrice);                               
                 itemHolder.sellerRating = (RatingBar)itemRow.findViewById(R.id.cartSellerRating);
                 itemHolder.check = (CheckBox) itemRow.findViewById(R.id.cartcheckBox);
                 itemHolder.cartBuy = (Button) itemRow.findViewById(R.id.cartBuyNowB);
                 itemHolder.cartRemove = (Button) itemRow.findViewById(R.id.cartBuyItRemoveB);                
                 
                 itemHolder.sellerRating.setTag(itemHolder);
                 itemHolder.itemPic.setTag(itemHolder);
                 itemHolder.cartBuy.setTag(itemHolder);
                 itemHolder.cartRemove.setTag(itemHolder);                 
                 itemRow.setTag(itemHolder);      
     
        	itemRow.setOnClickListener(this);  
        
   			itemHolder.item = item;
   			itemHolder.productName.setText(item.getTitle());   		
	   		itemHolder.sellerUserName.setText(item.getSellerUsername());
	   		itemHolder.priceAndShiping.setText(item.getInstantPrice()+" + "+item.getShippingPrice());     		
	   		itemHolder.sellerRating.setRating((float)item.getSellerRate());
	   		itemHolder.timeRemaining.setText(item.getTimeRemaining()); //viene del server    	

        return itemRow;
    }
    
    @Override
	public void onClick(View v) 
    {
    	MyViewItem itemHolder = (MyViewItem) v.getTag();    	    
    
    	if(v instanceof View)
    	{      	
//			if(itemHolder.item.getforAuction()){
//				this.activity.startActivity(new Intent(this.activity, BidProductInfoActivity.class));	
//			}
//			else{
//				this.activity.startActivity(new Intent(this.activity, BuyItProductInfoActivity.class));
//			}		
    	}    	
    }

}
