/**
 * 
 */
package com.se.DAO.imp;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import com.se.DAO.FollowUpDAO;
import com.se.mapping.Followup;

public class FollowUpDAOImpl extends GenericDAOImpl<Followup, Integer>
		implements FollowUpDAO {

	public FollowUpDAOImpl() {

		super(Followup.class);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Followup> findByFollowId(int id) {
		try {
			session = getSessionFactory().openSession();
			List<Followup> resultList = (List<Followup>) session
					.createCriteria(Followup.class)
					.add(Restrictions.eq("id", id)).list();
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
	public List<Followup> findByVisitId(int id) {
		try {
			session = getSessionFactory().openSession();
			List<Followup> resultList = (List<Followup>) session
					.createCriteria(Followup.class).createAlias("visit", "v")
					.add(Restrictions.eq("v.id", id)).list();
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
