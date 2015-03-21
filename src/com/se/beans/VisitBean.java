package com.se.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "visitBean")
@RequestScoped
public class VisitBean {

	private String complaint;
	private String hpi;
	private String ph;
	private String ears;
	private String nose;
	private String pharynx;
	private String larynx;
	private String neckOtherareas;
	private String otherData;
	private String investigationDone;
	private String investigationRequest;
	private String treatment;

	@ManagedProperty(value = "#{navBean}")
	private NavigationBean navBean;

	public void setNavBean(NavigationBean navBean) {
		this.navBean = navBean;
	}

	public String getComplaint() {
		return complaint;
	}

	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}

	public String getHpi() {
		return hpi;
	}

	public void setHpi(String hpi) {
		this.hpi = hpi;
	}

	public String getPh() {
		return ph;
	}

	public void setPh(String ph) {
		this.ph = ph;
	}

	public String getEars() {
		return ears;
	}

	public void setEars(String ears) {
		this.ears = ears;
	}

	public String getNose() {
		return nose;
	}

	public void setNose(String nose) {
		this.nose = nose;
	}

	public String getPharynx() {
		return pharynx;
	}

	public void setPharynx(String pharynx) {
		this.pharynx = pharynx;
	}

	public String getLarynx() {
		return larynx;
	}

	public void setLarynx(String larynx) {
		this.larynx = larynx;
	}

	public String getNeckOtherareas() {
		return neckOtherareas;
	}

	public void setNeckOtherareas(String neckOtherareas) {
		this.neckOtherareas = neckOtherareas;
	}

	public String getOtherData() {
		return otherData;
	}

	public void setOtherData(String otherData) {
		this.otherData = otherData;
	}

	public String getInvestigationDone() {
		return investigationDone;
	}

	public void setInvestigationDone(String investigationDone) {
		this.investigationDone = investigationDone;
	}

	public String getInvestigationRequest() {
		return investigationRequest;
	}

	public void setInvestigationRequest(String investigationRequest) {
		this.investigationRequest = investigationRequest;
	}

	public String getTreatment() {
		return treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

}
