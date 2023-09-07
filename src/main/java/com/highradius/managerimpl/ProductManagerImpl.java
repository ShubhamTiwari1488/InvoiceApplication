package com.highradius.managerimpl;

import com.highradius.dao.ProductDao;
import com.highradius.manager.ProductManager;
import com.highradius.pojo.Product;

public class ProductManagerImpl implements ProductManager{
	private ProductDao productDao;
	@Override
	public void insertProduct(Product product) {
		productDao.insertProduct(product);
	}

}
