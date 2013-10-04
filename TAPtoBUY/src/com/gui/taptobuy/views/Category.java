package com.gui.taptobuy.views;

import java.util.ArrayList;

public class Category {
	private String name;
	private ArrayList<Category> subCategories;

	public Category(String name, ArrayList<Category> subCategories){
		this.name = name;
		this.subCategories = subCategories;
	}
//	public void addSubCategory(Category subCategory){
//		this.subCategories.add(subCategory);
//	}
	public String getCategoryName(){
		return this.name;
	}
	public ArrayList<String> getSubcategoriesNames(){
		ArrayList<String> result = new ArrayList<String>();
		if(this.subCategories!=null){
			for(Category sub:this.subCategories){
				result.add(sub.getCategoryName());
			}
		}
		return result;
	}
	public Category getSubCategory(int index){
		return this.subCategories.get(index);
	}
	
}
