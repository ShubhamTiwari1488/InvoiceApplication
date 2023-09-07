package com.highradius.managerimpl;

import com.highradius.dao.SupplierDao;
import com.highradius.manager.SupplierManager;
import com.highradius.pojo.Supplier;

public class SupplierManagerImpl implements SupplierManager {
	private SupplierDao supplierDao;
	@Override
	public void insertSupplier(Supplier supplier) {
		
		supplierDao.insertSupplier(supplier);
		
	}

}
