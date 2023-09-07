package com.highradius.managerimpl;

import java.util.List;

import com.highradius.dao.CategoryDao;
import com.highradius.daoimpl.CategoryDaoImpl;
import com.highradius.manager.CategoryManager;
import com.highradius.pojo.Category;

public class CategoryManagerImpl implements CategoryManager {
	private CategoryDao categoryDao;

	@Override
	public int insertCategory(Category category) {
		categoryDao = new CategoryDaoImpl();
		return categoryDao.insertCategory(category);

	}

	@Override
	public int insertCategories(List<Category> categories) {
		categoryDao = new CategoryDaoImpl();
		return categoryDao.insertCategories(categories);

	}

}
