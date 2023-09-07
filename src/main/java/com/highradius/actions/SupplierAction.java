package com.highradius.actions;

import com.highradius.manager.SupplierManager;
import com.highradius.pojo.Supplier;

public class SupplierAction {
	private SupplierManager supplierManager;
	public void insertSupplier(Supplier supplier) {
		supplierManager.insertSupplier(supplier);
	}
}
