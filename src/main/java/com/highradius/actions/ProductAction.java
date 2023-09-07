package com.highradius.actions;

import com.highradius.manager.ProductManager;
import com.highradius.pojo.Product;

public class ProductAction {
	ProductManager productManager;
	public void insertProduct(Product product) {
		productManager.insertProduct(product);
	}
}
