package com.se.beans;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "followBean")
@RequestScoped
public class FollowBean {

	private Date followDate;
	private String staisfaction;
	private String complaint;
	private String examination;
	private String investigation;
	private String treatment;
	@ManagedProperty(value = "#{navBean}")
	private NavigationBean navBean;

	public void setNavBean(NavigationBean navBean) {
		this.navBean = navBean;
	}

	public Date getFollowDate() {
		return followDate;
	}

	public void setFollowDate(Date followDate) {
		this.followDate = followDate;
	}

	public String getStaisfaction() {
		return staisfaction;
	}

	public void setStaisfaction(String staisfaction) {
		this.staisfaction = staisfaction;
	}

	public String getComplaint() {
		return complaint;
	}

	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}

	public String getExamination() {
		return examination;
	}

	public void setExamination(String examination) {
		this.examination = examination;
	}

	public String getInvestigation() {
		return investigation;
	}

	public void setInvestigation(String investigation) {
		this.investigation = investigation;
	}

	public String getTreatment() {
		return treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

}
