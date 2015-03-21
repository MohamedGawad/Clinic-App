package com.se.DAO;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO <T , PK extends Serializable> {

	T findById(final PK id);

	List<T> findAll();

	PK add(T newInstance);

	boolean remove(T persistentObject);

	boolean  update(T transientObject);
}