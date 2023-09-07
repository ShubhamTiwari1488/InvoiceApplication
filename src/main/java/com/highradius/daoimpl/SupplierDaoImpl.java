package com.highradius.daoimpl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.highradius.dao.SupplierDao;
import com.highradius.hibernateutil.HibernateUtil;
import com.highradius.pojo.Supplier;

public class SupplierDaoImpl implements SupplierDao{

	@Override
	public void insertSupplier(Supplier supplier) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.save(supplier);
			transaction.commit();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			session.close();

		}

		
	}

}
