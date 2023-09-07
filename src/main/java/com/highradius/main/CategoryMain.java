package com.highradius.main;

import com.highradius.dao.CategoryDao;
import com.highradius.daoimpl.CategoryDaoImpl;
import com.highradius.pojo.Category;

public class CategoryMain {
	
	public static void main(String[] args) {
		Category category1 = new Category(1, "Beverages", "Soft drinks, coffees, teas, beers, and ales");
		Category category2 = new Category(2, "Condiments", "Sweet and savory sauces, relishes, spreads, and seasonings");
		Category category3 = new Category(3, "Confections", "Desserts, candies, and sweet breads");
		Category category4 = new Category(4, "Dairy Products", "Cheeses");
		Category category5 = new Category(5, "Grains/Cereals","Breads, crackers, pasta, and cereal");
		CategoryDao categoryDao = new CategoryDaoImpl();
		categoryDao.insertCategory(category1);
		categoryDao.insertCategory(category2);
		categoryDao.insertCategory(category3);
		categoryDao.insertCategory(category4);
		categoryDao.insertCategory(category5);

	}
}
