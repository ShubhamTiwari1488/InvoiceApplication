package com.highradius.main;

import com.highradius.dao.ProductDao;
import com.highradius.daoimpl.ProductDaoImpl;
import com.highradius.pojo.Category;
import com.highradius.pojo.Product;
import com.highradius.pojo.Supplier;

public class ProductMain {

	public static void main(String[] args) {
		
		//create objects of supplier
		Supplier supplier1 = new Supplier(1,"Exotic Liquid","Charlotte Cooper","49 Gilbert St.","Londona","EC1 4SD","UK","(171) 555-2222");
		Supplier supplier2 = new Supplier(2,"New Orleans Cajun Delights","Shelley Burke","P.O. Box 78934","New Orleans","70117","USA","(100) 555-4822");
		Supplier supplier3 = new Supplier(3,"Grandma Kelly's Homestead","Regina Murphy","707 Oxford Rd.","Ann Arbor","48104","USA","(313) 555-5735");
		Supplier supplier4 = new Supplier(4,"Tokyo Traders","Yoshi Nagase","9-8 Sekimai Musashino-shi","Tokyo","100","Japan","(03) 3555-5011");
		Supplier supplier5 = new Supplier(5,"Cooperativa de Quesos 'Las Cabras'","Antonio del Valle Saavedra","Calle del Rosal 4","Oviedo","33007","Spain","(98) 598 76 54");
		
		//create objects of category 
		Category category1 = new Category(1, "Beverages", "Soft drinks, coffees, teas, beers, and ales");
		Category category2 = new Category(2, "Condiments", "Sweet and savory sauces, relishes, spreads, and seasonings");
		Category category3 = new Category(3, "Confections", "Desserts, candies, and sweet breads");
		Category category4 = new Category(4, "Dairy Products", "Cheeses");
		Category category5 = new Category(5, "Grains/Cereals","Breads, crackers, pasta, and cereal");
		
		//create objects of product
		Product product1 = new Product(1, "Chais", supplier1, category1,"10 boxes x 20 bags", 18);
		Product product2 = new Product(2, "Chang", supplier2, category2,"24 - 12 oz bottles", 19);
		Product product3 = new Product(3, "Aniseed Syrup",supplier3,category3,"12 - 550 ml bottles",10);
		Product product4 = new Product(4,"Chef Anton's Cajun Seasoning",supplier4,category4,"48 - 6 oz jars",22);
		Product product5 = new Product(5,"Chef Anton's Gumbo Mix",supplier5,category5,"36 boxes",21.35f);
		
		
		
		//create object of daoImpl and call insert method
		ProductDao productDao = new ProductDaoImpl();
		productDao.insertProduct(product1);
		productDao.insertProduct(product2);
		productDao.insertProduct(product3);
		productDao.insertProduct(product4);
		productDao.insertProduct(product5);
		

	}

}
