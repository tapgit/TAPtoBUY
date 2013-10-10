package com.gui.taptobuy.Entities;

import java.util.ArrayList;

public class Cart {
	private int id;
	private ArrayList<ProductForSale> itemsInCart;
	public Cart(int id, ArrayList<ProductForSale> itemsInCart) {
		super();
		this.id = id;
		this.itemsInCart = itemsInCart;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<ProductForSale> getItemsInCart() {
		return itemsInCart;
	}
	public void setItemsInCart(ArrayList<ProductForSale> itemsInCart) {
		this.itemsInCart = itemsInCart;
	}
	public boolean addItemToCart(ProductForSale item){
		return itemsInCart.add(item);
	}
	public boolean removeItemToCart(){
		return itemsInCart.remove(itemsInCart);
	}
}
