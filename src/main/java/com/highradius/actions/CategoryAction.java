package com.highradius.actions;

import java.util.List;


import com.highradius.manager.CategoryManager;
import com.highradius.managerimpl.CategoryManagerImpl;
import com.highradius.pojo.Category;



public class CategoryAction {
	
//	private CustomerManager customerManager;
	
	private List<Category> categories;
	
	private Category category;
	
	
	public Category getCustomer() {
		return category;
	}

	public void setCustomer(Category category) {
		this.category = category;
	}

	
	
	public List<Category> getCustomers() {
		return categories;
	}

	public void setCustomers(List<Category> categories) {
		this.categories = categories;
	}

	public String insertCategory() {
		
		String s = "ERROR";
		CategoryManager categoryManager = new CategoryManagerImpl();
		int result = categoryManager.insertCategory(category);
		if(result > 0) {
			s = "SUCCESS";
		}
		return s;
	}
	
	public String insertCategories() {
		String s = "ERROR";
		CategoryManager categoryManager = new CategoryManagerImpl();
		int result = categoryManager.insertCategories(categories);
		if(result > 0) {
			s = "SUCCESS";
		}
		return s;
	}
}

