package com.learning.lizard.dao;

import java.util.HashMap;
import java.util.List;

/**
 * A generic Interface to provide all Data access objects. A single source that
 * can be used by any identity to perform CRUD
 * 
 * @author abhishek.vishnoi
 * 
 * @param <T>
 */
public interface GenericDAO<T> {

	/**
	 * Method to set a class object to use DAO layer.
	 * 
	 * @param clazz
	 */
	void setClazz(Class<T> clazz);

	/**
	 * Method to create a new entry in Database Tables
	 * 
	 * @param entity
	 */
	void create(final T entity);

	/**
	 * Method to find the list of all the entries of a particular table Type
	 * Generic <T>
	 * 
	 * @return
	 */
	List<T> findAll();

	/**
	 * Method to find a Particular record in a table on bass of unique Id
	 * 
	 * @param id
	 * @return
	 */
	T findByID(final int id);

	void delete(final T entity);

	/**
	 * Method to delete a record in detabase on basis of ID
	 * 
	 * @param entityId
	 */
	void deleteById(final int entityId);

	<T> List<T> findAllByProperty(String propertyName, Object value);

	<T> List<T> findAllByProperty(HashMap<String, Object> propertiesMap);

	T update(final T entity);
	
	public <T> List<T> findAllByOr(List<Integer> properties , String propertyName);



}
