/**
 * 
 */
package com.se.DAO.imp;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.se.DAO.PatientDAO;
import com.se.mapping.Patient;
import com.se.mapping.Visit;

public class PatientDAOImpl extends GenericDAOImpl<Patient, Integer> implements
		PatientDAO {

	public PatientDAOImpl() {

		super(Patient.class);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Patient> findByPatientId(int id) {
		try {
			session = getSessionFactory().openSession();
			List<Patient> resultList = (List<Patient>) session
					.createCriteria(Patient.class)
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
	public List<Patient> findByPatientName(String name) {
		try {
			session = getSessionFactory().openSession();
			List<Patient> resultList = session.createCriteria(Patient.class)
					.add(Restrictions.eq("name", name)).list();
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
	public List<Patient> findAllPatient() {
		try {
			session = getSessionFactory().openSession();

			List<Patient> resultList = (List<Patient>) session.createCriteria(
					Patient.class).list();
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
	public Patient findByVisitId(int id) {
		try {
			session = getSessionFactory().openSession();

			Criteria cri = session.createCriteria(Visit.class);
			List<Visit> resultList = cri.createAlias("patient", "p")
					.add(Restrictions.eq("p.id", id)).list();
			return resultList.get(0).getPatient();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		return null;
	}

}
