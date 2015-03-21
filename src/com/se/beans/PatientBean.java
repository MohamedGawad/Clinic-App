package com.se.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.se.DAO.FollowUpDAO;
import com.se.DAO.PatientDAO;
import com.se.DAO.VisitDAO;
import com.se.DAO.imp.FollowUpDAOImpl;
import com.se.DAO.imp.PatientDAOImpl;
import com.se.DAO.imp.VisitDAOImpl;
import com.se.mapping.Followup;
import com.se.mapping.Patient;
import com.se.mapping.Visit;

@ManagedBean(name = "PBean")
@RequestScoped
public class PatientBean {

	private Patient patient;
	private Visit visit;
	private List<Followup> followups;
	private boolean isNew;
	public String visitid;
	@ManagedProperty(value = "#{navBean}")
	private NavigationBean navBean;

	@PostConstruct
	public void init() {

		ExternalContext ec = FacesContext.getCurrentInstance()
				.getExternalContext();
		// System.out.println("user " + user.getFirstName());
		visitid = ec.getRequestParameterMap().get("visitid");
		// System.out.println("prop id " + porpertyId);

		if (visitid == null) {
			initialize();
			setNew(true);
			System.out.println("initialized new");
		} else {
			initialize(Integer.valueOf(visitid));
			setNew(false);
			System.out.println("initialized old");
		}
	}

	public void initialize() {
		patient = new Patient();
		visit = new Visit();
	}

	public void initialize(int id) {
		PatientDAO patientDAO = new PatientDAOImpl();
		Patient editAbleapatient = patientDAO.findByVisitId(id);
		setPatient(editAbleapatient);
		VisitDAO visitDAO = new VisitDAOImpl();
		List<Visit> editAbleVisit = visitDAO.findByVisitId(id);
		setVisit(editAbleVisit.get(0));
		FollowUpDAO followupDAO = new FollowUpDAOImpl();
		List<Followup> followups = followupDAO.findByVisitId(id);
		setFollowups(followups);
	}

	public List<Followup> getFollowups() {
		return followups;
	}

	public void setFollowups(List<Followup> followups) {
		this.followups = followups;
	}

	public Visit getVisit() {
		return visit;
	}

	public void setVisit(Visit visit) {
		this.visit = visit;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public boolean isNew() {
		return isNew;
	}

	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}

	public void setNavBean(NavigationBean navBean) {
		this.navBean = navBean;
	}

}
