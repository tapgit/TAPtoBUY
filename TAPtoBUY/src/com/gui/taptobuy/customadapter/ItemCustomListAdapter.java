package com.gui.taptobuy.customadapter;

import java.util.ArrayList;

import com.gui.taptobuy.Entities.Product;
import com.gui.taptobuy.Entities.ProductForAuction;
import com.gui.taptobuy.Entities.ProductForSale;
import com.gui.taptobuy.activity.BidProductInfoActivity;
import com.gui.taptobuy.activity.BuyItProductInfoActivity;
import com.gui.taptobuy.activity.SearchActivity;
import com.gui.taptobuy.activity.SearchActivity.MyViewItem;
import com.gui.taptobuy.phase1.R;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class ItemCustomListAdapter extends BaseAdapter implements OnClickListener{
	
	private SearchActivity activity;
	//private IconTask imgFetcher;  -- clases que usa para loadear las imagenes
	private ImageView itemPic;
	private LayoutInflater layoutInflater;
	private ArrayList<Product> items;	
	
    public ItemCustomListAdapter (SearchActivity a, ImageView i, LayoutInflater l, ArrayList<Product> items)
    {
    	this.activity = a;
    	//this.itemPic = i;
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
        Product item = items.get(position);
        if(item instanceof ProductForAuction)
        {        	
                 itemRow = layoutInflater.inflate(R.layout.bidproduct_row, parent, false); 
                 itemHolder = new MyViewItem();
                 itemHolder.itemPic =  (ImageView) itemRow.findViewById(R.id.BidProductPic);
                 itemHolder.productName = (TextView) itemRow.findViewById(R.id.BidProdName);
                 itemHolder.sellerUserName = (TextView) itemRow.findViewById(R.id.BidSellerUserName);
                 itemHolder.priceAndShiping = (TextView) itemRow.findViewById(R.id.BidPrice);
                 itemHolder.bidsAmount = (TextView) itemRow.findViewById(R.id.bids);
                 itemHolder.timeRemaining = (TextView) itemRow.findViewById(R.id.BidRemaningTime);                      
                 itemHolder.sellerRating = (RatingBar)itemRow.findViewById(R.id.BidSellerRating);
                 
                 itemHolder.sellerRating.setTag(itemHolder);
                 itemHolder.itemPic.setTag(itemHolder);
                 itemRow.setTag(itemHolder);
                 
                 itemHolder.bidsAmount.setText(((ProductForAuction) item).getTotalBids()+" bids");
                 itemHolder.priceAndShiping.setText(((ProductForAuction) item).getCurrentBidPrice()+" + "+item.getShippingPrice());  
        }
        else //for sale
        {	        
        	    itemRow = layoutInflater.inflate(R.layout.buyitproduct_row, parent, false); 
	            itemHolder = new MyViewItem();
	            itemHolder.itemPic =  (ImageView) itemRow.findViewById(R.id.BuyItProductPic);
	            itemHolder.productName = (TextView) itemRow.findViewById(R.id.BuyItProdName);
	            itemHolder.sellerUserName = (TextView) itemRow.findViewById(R.id.BuyItSellerID);
	            itemHolder.priceAndShiping = (TextView) itemRow.findViewById(R.id.BuyItPrice);        
	            itemHolder.timeRemaining = (TextView) itemRow.findViewById(R.id.BuyItRemaningTime);
	            itemHolder.buyItNow = (TextView) itemRow.findViewById(R.id.BuyItNowText);        
	            itemHolder.sellerRating = (RatingBar)itemRow.findViewById(R.id.BuyItSellerRating);            
	            
	            itemHolder.sellerRating.setTag(itemHolder);
	            itemHolder.itemPic.setTag(itemHolder);
	            itemRow.setTag(itemHolder);        
	            
	            itemHolder.priceAndShiping.setText(((ProductForSale) item).getInstantPrice()+" + "+item.getShippingPrice());  
        }        
        
        	itemRow.setOnClickListener(this);  
        	
   			itemHolder.item = item;
   			itemHolder.productName.setText(item.getTitle());   		
	   		itemHolder.sellerUserName.setText(item.getSellerUsername());		
	   		itemHolder.sellerRating.setRating((float)item.getSellerRate());
	   		//itemHolder.timeRemaining.setText(item.get) //viene del server    	

        return itemRow;
    }
    
    @Override
	public void onClick(View v) 
    {
    	MyViewItem itemHolder = (MyViewItem) v.getTag();    	    
    
    	if(v instanceof View)
    	{      	
			if(itemHolder.item instanceof ProductForAuction){
				this.activity.startActivity(new Intent(this.activity, BidProductInfoActivity.class));	
			}
			else{//for sale
				this.activity.startActivity(new Intent(this.activity, BuyItProductInfoActivity.class));
			}		
    	}    	
    }
}
