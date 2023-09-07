package com.highradius.main;

import com.highradius.dao.ShipperDao;
import com.highradius.daoimpl.ShipperDaoImpl;
import com.highradius.pojo.Shipper;

public class ShipperMain {

	public static void main(String[] args) {
		
		Shipper shipper1 = new Shipper(1,"Speedy Express","(503) 555-9831");
		Shipper shipper2 = new Shipper(2,"United Package","(503) 555-3199");
		Shipper shipper3 = new Shipper(3,"Federal Shipping","(503) 555-9931");
		
		ShipperDao shipperDao = new ShipperDaoImpl();
		shipperDao.insertShipper(shipper1);
		shipperDao.insertShipper(shipper2);
		shipperDao.insertShipper(shipper3);

	}

}
