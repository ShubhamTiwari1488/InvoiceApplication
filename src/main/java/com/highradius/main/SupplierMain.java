package com.highradius.main;

import com.highradius.dao.SupplierDao;
import com.highradius.daoimpl.SupplierDaoImpl;
import com.highradius.pojo.Supplier;

public class SupplierMain {

	public static void main(String[] args) {
		
		Supplier supplier1 = new Supplier(1,"Exotic Liquid","Charlotte Cooper","49 Gilbert St.","Londona","EC1 4SD","UK","(171) 555-2222");
		Supplier supplier2 = new Supplier(2,"New Orleans Cajun Delights","Shelley Burke","P.O. Box 78934","New Orleans","70117","USA","(100) 555-4822");
		Supplier supplier3 = new Supplier(3,"Grandma Kelly's Homestead","Regina Murphy","707 Oxford Rd.","Ann Arbor","48104","USA","(313) 555-5735");
		Supplier supplier4 = new Supplier(4,"Tokyo Traders","Yoshi Nagase","9-8 Sekimai Musashino-shi","Tokyo","100","Japan","(03) 3555-5011");
		Supplier supplier5 = new Supplier(5,"Cooperativa de Quesos 'Las Cabras'","Antonio del Valle Saavedra","Calle del Rosal 4","Oviedo","33007","Spain","(98) 598 76 54");
		
		SupplierDao supplierDao = new SupplierDaoImpl();
		supplierDao.insertSupplier(supplier1);
		supplierDao.insertSupplier(supplier2);
		supplierDao.insertSupplier(supplier3);
		supplierDao.insertSupplier(supplier4);
		supplierDao.insertSupplier(supplier5);
	}

}
