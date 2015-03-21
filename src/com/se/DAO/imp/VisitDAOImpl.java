/**
 * 
 */
package com.se.DAO.imp;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import com.se.DAO.VisitDAO;
import com.se.mapping.Visit;

public class VisitDAOImpl extends GenericDAOImpl<Visit, Integer> implements
		VisitDAO {

	public VisitDAOImpl() {

		super(Visit.class);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Visit> findByVisitId(int id) {
		try {
			session = getSessionFactory().openSession();

			List<Visit> resultList = (List<Visit>) session
					.createCriteria(Visit.class).add(Restrictions.eq("id", id))
					.list();
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
	public List<Visit> findByPatientID(int id) {
		try {
			session = getSessionFactory().openSession();
			List<Visit> resultList = (List<Visit>) session
					.createCriteria(Visit.class).createAlias("patient", "p")
					.add(Restrictions.eq("p.id", id)).list();
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
	public List<Visit> findAllVisits() {
		try {
			session = getSessionFactory().openSession();
			List<Visit> resultList = (List<Visit>) session.createCriteria(
					Visit.class).list();
			return resultList;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		return null;
	}

}
