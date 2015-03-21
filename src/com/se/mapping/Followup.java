package com.se.mapping;
// Generated Mar 21, 2015 7:24:01 PM by Hibernate Tools 3.6.0


import java.util.Date;

/**
 * Followup generated by hbm2java
 */
public class Followup  implements java.io.Serializable {


     private Integer id;
     private Visit visit;
     private Date followDate;
     private String staisfaction;
     private String complaint;
     private String examination;
     private String investigation;
     private String treatment;

    public Followup() {
    }

    public Followup(Visit visit, Date followDate, String staisfaction, String complaint, String examination, String investigation, String treatment) {
       this.visit = visit;
       this.followDate = followDate;
       this.staisfaction = staisfaction;
       this.complaint = complaint;
       this.examination = examination;
       this.investigation = investigation;
       this.treatment = treatment;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Visit getVisit() {
        return this.visit;
    }
    
    public void setVisit(Visit visit) {
        this.visit = visit;
    }
    public Date getFollowDate() {
        return this.followDate;
    }
    
    public void setFollowDate(Date followDate) {
        this.followDate = followDate;
    }
    public String getStaisfaction() {
        return this.staisfaction;
    }
    
    public void setStaisfaction(String staisfaction) {
        this.staisfaction = staisfaction;
    }
    public String getComplaint() {
        return this.complaint;
    }
    
    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }
    public String getExamination() {
        return this.examination;
    }
    
    public void setExamination(String examination) {
        this.examination = examination;
    }
    public String getInvestigation() {
        return this.investigation;
    }
    
    public void setInvestigation(String investigation) {
        this.investigation = investigation;
    }
    public String getTreatment() {
        return this.treatment;
    }
    
    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }




}

