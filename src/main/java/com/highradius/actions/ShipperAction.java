package com.highradius.actions;

import com.highradius.manager.ShipperManager;
import com.highradius.pojo.Shipper;

public class ShipperAction {
	private ShipperManager shipperManager;
	public void insertShipper(Shipper shipper) {
		shipperManager.insertShipper(shipper);
	}
}
