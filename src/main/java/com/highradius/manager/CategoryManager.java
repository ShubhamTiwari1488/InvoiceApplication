package com.highradius.manager;

import java.util.List;
import com.highradius.pojo.Category;

public interface CategoryManager {
	int insertCategory(Category category);
	int insertCategories(List<Category> categories);
}
