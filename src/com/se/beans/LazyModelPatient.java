package com.se.beans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import com.se.mapping.Patient;

public class LazyModelPatient extends LazyDataModel<Patient> {

	/**
	 * 
	 */
	private List<Patient> datasource;

	public LazyModelPatient(List<Patient> datasource) {
		this.datasource = datasource;
	}

	@Override
	public Patient getRowData(String rowKey) {
		for (Patient patient : datasource) {
			if (patient.getId().toString().equals(rowKey))
				return patient;
		}

		return null;
	}

	@Override
	public Object getRowKey(Patient patient) {
		return patient.getId();
	}

	@Override
	public List<Patient> load(int first, int pageSize, String sortField,
			SortOrder sortOrder, Map<String, Object> filters) {
		List<Patient> data = new ArrayList<Patient>();

		// filter
		for (Patient patient : datasource) {
			boolean match = true;

			if (filters != null) {
				for (Iterator<String> it = filters.keySet().iterator(); it
						.hasNext();) {
					try {
						String filterProperty = it.next();
						Object filterValue = filters.get(filterProperty);
						// patient.getClass().getField(filterProperty);
						String fieldValue = String.valueOf(patient.getClass()
								.getField(filterProperty).get(patient));

						if (filterValue == null
								|| fieldValue
										.startsWith(filterValue.toString())) {
							match = true;
						} else {
							match = false;
							break;
						}
					} catch (Exception e) {
						e.printStackTrace();
						match = false;
					}
				}
			}

			if (match) {
				data.add(patient);
			}
		}

		// sort
		if (sortField != null) {
			Collections.sort(data, new LazySorter(sortField, sortOrder));
		}

		// rowCount
		int dataSize = data.size();
		this.setRowCount(dataSize);

		// paginate
		if (dataSize > pageSize) {
			try {
				return data.subList(first, first + pageSize);
			} catch (IndexOutOfBoundsException e) {
				return data.subList(first, first + (dataSize % pageSize));
			}
		} else {
			return data;
		}
	}
}