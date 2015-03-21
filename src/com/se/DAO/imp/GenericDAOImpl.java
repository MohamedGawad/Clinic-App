/**
 * 
 */
package com.se.DAO.imp;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.se.DAO.GenericDAO;
import com.se.utils.DBUtils;

/**
 * @author Mohamed
 * 
 */
public abstract class GenericDAOImpl<T, PK extends Serializable> implements
		GenericDAO<T, PK> {

	protected SessionFactory sessionFactory;
	protected Session session;
	protected Transaction tx;
	private Class<T> type;

	public GenericDAOImpl(Class<T> type) {
		this.type = type;
		setSessionFactory(DBUtils.getSessionFactory());

	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected SessionFactory getSessionFactory() {
		if (sessionFactory == null)
			throw new IllegalStateException(
					"SessionFactory has not been set on DAO before usage");
		return sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findById(PK id) {

		try {
			session = sessionFactory.openSession();
			T instance = (T) session.get(type, id);
			return instance;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		return null;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {

		try {
			session = sessionFactory.openSession();
			List<T> resultList = session.createCriteria(type).list();

			return resultList;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		return null;

	}

	@SuppressWarnings("unchecked")
	@Override
	public PK add(T newInstance) {

		try {

			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			PK pk = (PK) session.save(newInstance);
			tx.commit();
			return pk;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}

	}

	@Override
	public boolean remove(T persistentObject) {

		try {

			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.delete(persistentObject);
			tx.commit();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}

	}

	@Override
	public boolean update(T transientObject) {

		try {

			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.update(transientObject);
			tx.commit();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}

	}

}
