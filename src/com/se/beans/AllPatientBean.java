package com.se.beans;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;

import com.se.DAO.PatientDAO;
import com.se.DAO.VisitDAO;
import com.se.DAO.imp.PatientDAOImpl;
import com.se.DAO.imp.VisitDAOImpl;
import com.se.mapping.Patient;
import com.se.mapping.Visit;

@ManagedBean(name = "allPatient")
@RequestScoped
public class AllPatientBean {

	private LazyDataModel<Patient> allPatientmodel;
	public Patient selectedpatient;
	@ManagedProperty(value = "#{navBean}")
	private NavigationBean navBean;

	public List<Visit> visits;

	@PostConstruct
	public void init() {
		PatientDAO patientDAO = new PatientDAOImpl();
		allPatientmodel = new LazyModelPatient(patientDAO.findAllPatient());
	}

	public void onRowSelect(SelectEvent event) {

		VisitDAO visitDAO = new VisitDAOImpl();
		int id = ((Patient) event.getObject()).getId();
		visits = visitDAO.findByPatientID(id);
		/*
		 * FacesMessage msg = new FacesMessage("Patient Selected", ((Patient)
		 * event.getObject()).getId().toString());
		 * FacesContext.getCurrentInstance().addMessage(null, msg);
		 */
		// try {
		// FacesContext.getCurrentInstance().getExternalContext()
		// .redirect("/pages/PatientForm.xhtml");
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}

	public Patient getSelectedpatient() {
		return selectedpatient;
	}

	public void setSelectedpatient(Patient selectedpatient) {
		this.selectedpatient = selectedpatient;
	}

	public LazyDataModel<Patient> getAllPatientmodel() {
		return allPatientmodel;
	}

	public void setNavBean(NavigationBean navBean) {
		this.navBean = navBean;
	}

	public String openvisit() {
		// FacesContext context = FacesContext.getCurrentInstance();
		// HttpServletResponse response = (HttpServletResponse) context
		// .getExternalContext().getResponse();
		// try {
		// response.sendRedirect(navBean.redirectToPatient());
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		System.out.println("Clicked..........");
		return navBean.redirectToPatient();
	}

	public List<Visit> getVisits() {
		return visits;
	}

}
