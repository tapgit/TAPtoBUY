package com.gui.taptobuy.manager;

import java.util.ArrayList;
import java.util.Stack;

import com.gui.taptobuy.views.Category;

public class CategoryManager {

	public static Category currentCategory;
	public static ArrayList<String> currentCategoriesNames;
	public static Stack<Category> categoryStack;

	public static void getCategories(){
		currentCategory = defaultCategories();//Download Categories
		currentCategoriesNames = currentCategory.getSubcategoriesNames();//extract categories titles
		categoryStack = new Stack<Category>();//initialize stack
	}
	public static void goBack(){
		currentCategory = categoryStack.pop();
		currentCategoriesNames = currentCategory.getSubcategoriesNames();
	}
	public static void goforward(int index){
		categoryStack.push(currentCategory);
		currentCategory = currentCategory.getSubCategory(index);
		currentCategoriesNames = currentCategory.getSubcategoriesNames();
	}
	
	public static Category defaultCategories(){
		ArrayList<Category> sub0 = new ArrayList<Category>();
		sub0.add(new Category("Children",null));
		sub0.add(new Category("Fiction",null));
		sub0.add(new Category("Technology",null));
		sub0.add(new Category("Business",null));
		Category sup0 = new Category("Books",sub0);
		
		ArrayList<Category> sub1 = new ArrayList<Category>();
		sub1.add(new Category("TV",null));
		sub1.add(new Category("Audio",null));
		sub1.add(new Category("Phones",null));
		sub1.add(new Category("Camera",null));
		sub1.add(new Category("Video",null));
		Category sup1 = new Category("Electronics",sub1);
		
		ArrayList<Category> sub2 = new ArrayList<Category>();
		sub2.add(new Category("Laptops",null));
		sub2.add(new Category("Desktops",null));
		sub2.add(new Category("Tablets",null));
		sub2.add(new Category("Printers",null));
		Category sup2 = new Category("Computers",sub2);
		
		ArrayList<Category> ssub3 = new ArrayList<Category>();
		ssub3.add(new Category("Shirts",null));
		ssub3.add(new Category("Pants",null));
		ssub3.add(new Category("Socks",null));
		Category sub3a = new Category("Men",ssub3);
		
		ArrayList<Category> ssub3a = new ArrayList<Category>();
		ssub3a.add(new Category("Shirts",null));
		ssub3a.add(new Category("Pants",null));
		ssub3a.add(new Category("Dresses",null));
		Category sub3b = new Category("Women",ssub3a);
		ArrayList<Category> sub3 = new ArrayList<Category>();
		sub3.add(new Category("Children",null));
		sub3.add(sub3a);
		sub3.add(sub3b);
		Category sup3 = new Category("Clothing",sub3);		

		ArrayList<Category> sup = new ArrayList<Category>();
		sup.add(sup0);
		sup.add(sup1);
		sup.add(sup2);
		sup.add(sup3);
		Category result = new Category("All",sup);
		return result;
	}
	


}
