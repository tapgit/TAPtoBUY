package com.gui.taptobuy.Entities;

public class Bid 
{
	private int BidderID, prodId;
	private double bidPrice;
	String BidderUserName;
	
	
	public Bid(int placerId, double bidPrice, int productId, String BidderUsername){
		this.BidderID = placerId;
		this.prodId = productId;
		this.bidPrice = bidPrice;
		this.BidderUserName = BidderUsername;
	}


	public int getBidderID() {
		return BidderID;
	}


	public void setBidderID(int bidderID) {
		BidderID = bidderID;
	}


	public int getProdId() {
		return prodId;
	}


	public void setProdId(int prodId) {
		this.prodId = prodId;
	}


	public double getBidPrice() {
		return bidPrice;
	}


	public void setBidPrice(double bidPrice) {
		this.bidPrice = bidPrice;
	}


	public String getBidderUserName() {
		return BidderUserName;
	}


	public void setBidderUserName(String bidderUserName) {
		BidderUserName = bidderUserName;
	}


}
