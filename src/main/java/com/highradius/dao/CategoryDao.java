package com.highradius.dao;

import java.util.List;

import com.highradius.pojo.Category;

public interface CategoryDao {
	int insertCategory(Category category);
	int insertCategories(List<Category> categories);
}
