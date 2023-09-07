package com.highradius.managerimpl;

import com.highradius.dao.ShipperDao;
import com.highradius.manager.ShipperManager;
import com.highradius.pojo.Shipper;

public class ShipperManagerImpl implements ShipperManager{
	private ShipperDao shipperDao;
	@Override
	public void insertShipper(Shipper shipper) {
		shipperDao.insertShipper(shipper);
	}

}
