package com.highradius.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.highradius.dao.CategoryDao;
import com.highradius.hibernateutil.HibernateUtil;
import com.highradius.pojo.Category;

public class CategoryDaoImpl implements CategoryDao{

	@Override
	public int insertCategory(Category category) {
		
		Session session =  HibernateUtil.getSessionFactory().openSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.save(category);
			transaction.commit();
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return 0;
		
	}

	

	@Override
	public int insertCategories(List<Category> categories) {
		Session session =  HibernateUtil.getSessionFactory().openSession();
		try {
			Transaction transaction = session.beginTransaction();
			for(Category category : categories) {
				session.save(category);
			}
			transaction.commit();
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return 0;
	}

}
