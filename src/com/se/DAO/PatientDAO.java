/**
 * 
 */
package com.se.DAO;

import java.util.List;

import com.se.mapping.Patient;

public interface PatientDAO extends GenericDAO<Patient, Integer> {

	List<Patient> findByPatientId(int id);

	List<Patient> findByPatientName(String name);

	List<Patient> findAllPatient();

	Patient findByVisitId(int id);

}
