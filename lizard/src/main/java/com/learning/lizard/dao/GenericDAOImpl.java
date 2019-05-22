package com.learning.lizard.dao;

import java.util.HashMap;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author abhishek.vishnoi
 * 
 */
@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GenericDAOImpl<T> implements GenericDAO<T> {

	private Class<T> clazz;

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public final void setClazz(Class<T> clazzToSet) {
		this.clazz = clazzToSet;
	}

	@Override
	public void create(T entity) {
		getCurrentSession().save(entity);
	}

	/**
	 * Method to find List of all the records in a database table.
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		return getCurrentSession().createQuery("from " + clazz.getName())
				.list();
	}

	@Override
	public T findByID(int id) {
		return (T) getCurrentSession().get(clazz, id);
	}

	@Override
	public <T> List<T> findAllByProperty(String propertyName, Object value) {
		final Criteria crit = getCurrentSession().createCriteria(clazz);
		crit.add(Restrictions.eq(propertyName, value));
		return crit.list();
	}

	@Override
	public <T> List<T> findAllByProperty(HashMap<String, Object> propertiesMap) {

		final Criteria crit = getCurrentSession().createCriteria(clazz);
		for (String propertyName : propertiesMap.keySet()) {
			crit.add(Restrictions.eq(propertyName,
					propertiesMap.get(propertyName)));
		}
		return crit.list();
	}

	/**
	 * 
	 * @param propertiesMap
	 * @return
	 */
	@Override
	public <T> List<T> findAllByOr(List<Integer> properties , String propertyName) {

		final Criteria criteria = getCurrentSession().createCriteria(clazz);
		
		Disjunction or = Restrictions.disjunction();

		for (int itr = 0; itr < properties.size(); itr++) {
			or.add(Restrictions.eq(propertyName, properties.get(itr)));
		}

		criteria.add(or);
		return criteria.list();
	}

	/**
	 * 
	 */
	@Override
	public T update(T entity) {
		return (T) getCurrentSession().merge(entity);
	}

	@Override
	public void delete(T entity) {
		getCurrentSession().delete(entity);
	}

	@Override
	public void deleteById(int entityId) {
		T entity = findByID(entityId);
		delete(entity);
	}

	protected final Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

}