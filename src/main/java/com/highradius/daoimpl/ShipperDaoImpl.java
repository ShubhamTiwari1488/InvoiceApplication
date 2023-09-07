package com.highradius.daoimpl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.highradius.dao.ShipperDao;
import com.highradius.hibernateutil.HibernateUtil;
import com.highradius.pojo.Shipper;

public class ShipperDaoImpl implements ShipperDao {

	@Override
	public void insertShipper(Shipper shipper) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.save(shipper);
			transaction.commit();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			session.close();

		}

	}
}
