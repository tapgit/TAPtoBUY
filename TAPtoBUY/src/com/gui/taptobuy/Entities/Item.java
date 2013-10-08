package com.gui.taptobuy.Entities;

import android.widget.ImageView;

public class Item {
	
	private int productID;		
	private ImageView picture;
	private String price;	
	private String product;
	private String brand;
	private String dimensions;
	private String description;
	private String shipping;
	private String prodTitle;
	private String category;
	private String startingDate;
	private boolean ForAuction;
	private String endingDate;
	private int sellerID;
	private String sellerUserName;
	private int BidsAmount;
	
	public Item(boolean forAuction,int bidAmount,int productID, ImageView picture, String price,String currentBid,String product,String brand,String dimensions,String 
			description,String sellerUserName,String shipping,String prodTitle,String category,String startingDate,String endingDate)
	{	
		this.sellerUserName = sellerUserName;
		this.BidsAmount = bidAmount;
		this.ForAuction = forAuction;
		this.productID = productID;
		this.picture = picture;
		this.price = price;		
		this.product = product;
		this.brand = brand;
		this.dimensions = dimensions;
		this.description = description;
		this.shipping = shipping;
		this.prodTitle = prodTitle;
		this.category = category;
		this.startingDate = startingDate;
		this.endingDate = endingDate;		
	}	
	
	///////////////////////////
	public boolean getforAuction(){
		return ForAuction;
	}
	public int getProductID() {
		return productID;
	}	
	public ImageView getPicture() {
		return picture;
	}
	public String getPrice() {
		return price;
	}
	
	public String getProduct() {
		return product;
	}
	public String getBrand() {
		return brand;
	}
	public String getDimensions() {
		return dimensions;
	}
	public String getDescription() {
		return description;
	}
	public String getShipping() {
		return shipping;
	}
	public String getProdTitle() {
		return prodTitle;
	}
	public String getCategory() {
		return category;
	}
	public String getStartingDate() {
		return startingDate;
	}
	public String getEndingDate() {
		return endingDate;
	}	
	public int getSellerID() {
		return sellerID;
	}

	public int getBidsAmount() {		
		return BidsAmount;
	}

	public String getSellerUserName() {	
		return sellerUserName;
	}
}
