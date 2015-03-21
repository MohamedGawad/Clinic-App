package com.se.beans;

import java.util.Comparator;

import org.primefaces.model.SortOrder;

import com.se.mapping.Patient;

public class LazySorter implements Comparator<Patient> {

	private String sortField;

	private SortOrder sortOrder;

	public LazySorter(String sortField, SortOrder sortOrder) {
		this.sortField = sortField;
		this.sortOrder = sortOrder;
	}

	public int compare(Patient car1, Patient car2) {
		try {
			Object value1 = Patient.class.getField(this.sortField).get(car1);
			Object value2 = Patient.class.getField(this.sortField).get(car2);

			int value = ((Comparable) value1).compareTo(value2);

			return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
}
