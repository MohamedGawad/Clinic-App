package com.se.beans;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "msgBean")
@ApplicationScoped
public class MessageBean implements Serializable {
	

	public String getRequired() {
		return "*";
	}

	public String getInvalid() {
		return "Invalid";
	}

	public String getNotAvaiable() {
		return "Not available";
	}

}
