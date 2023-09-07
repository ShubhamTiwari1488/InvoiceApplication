package com.highradius.daoimpl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.highradius.dao.ProductDao;
import com.highradius.hibernateutil.HibernateUtil;
import com.highradius.pojo.Product;

public class ProductDaoImpl implements ProductDao{

	@Override
	public void insertProduct(Product product) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.save(product.getSupplier());
			session.save(product.getCategory());
			session.save(product);
			transaction.commit();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}

}
