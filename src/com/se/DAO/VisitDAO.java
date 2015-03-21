/**
 * 
 */
package com.se.DAO;

import java.util.List;

import com.se.mapping.Visit;

public interface VisitDAO extends GenericDAO<Visit, Integer> {

	List<Visit> findByVisitId(int id);

	List<Visit> findByPatientID(int id);

	List<Visit> findAllVisits();
}
