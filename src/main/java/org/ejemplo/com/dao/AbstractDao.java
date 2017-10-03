package org.ejemplo.com.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

import org.ejemplo.com.dao.exceptions.JPAException;
import org.ejemplo.com.dao.exceptions.NoDataFoundException;

public abstract class AbstractDao<K, T> {
	
	protected abstract EntityManager getEntityManager();

	protected abstract Class<T> getTypeClass();

	public T create(T entity) throws JPAException {
		try {
			getEntityManager().persist(entity);
			getEntityManager().flush();
			return entity;

		} catch (PersistenceException | IllegalArgumentException ex) {
			throw new JPAException(ex.getMessage(), ex);
		}
	}

	public T update(T entity) throws JPAException {
		try {
			getEntityManager().merge(entity);
			return entity;
		} catch (PersistenceException | IllegalArgumentException ex) {
			throw new JPAException(ex.getMessage(), ex);
		}
	}

	public void delete(T entity) throws JPAException {
		try {
			getEntityManager().remove(entity);
		} catch (PersistenceException | IllegalArgumentException ex) {
			throw new JPAException(ex.getMessage(), ex);
		}
	}
	
	public T findById(K id) throws NoDataFoundException, JPAException {
		try {
			T entity = getEntityManager().find(getTypeClass(), id);
			return entity;
		} catch (PersistenceException | IllegalArgumentException ex) {
			throw new JPAException(ex.getMessage(), ex);
		}
	}

	public List<T> findAll() throws NoDataFoundException, JPAException {
		try {
			CriteriaQuery<T> query = getEntityManager().getCriteriaBuilder().createQuery(getTypeClass());
			query.select(query.from(getTypeClass()));
			List<T> entities = getEntityManager().createQuery(query).getResultList();
			return entities;
		} catch (PersistenceException | IllegalArgumentException ex) {
			throw new JPAException(ex.getMessage(), ex);
		}
	}

	protected T executeSingleNamedQuery(String namedQuery, Parameter parameters)
			throws NoDataFoundException, JPAException {
		try {
			return getTypedQuery(namedQuery, parameters).getSingleResult();

		} catch (NoResultException ex) {
			throw new NoDataFoundException(ex.getMessage(), ex);
		} catch (PersistenceException | IllegalArgumentException ex) {
			throw new JPAException(ex.getMessage(), ex);
		}
	}

	protected List<T> executeListNamedQuery(String namedQuery, Parameter parameters)
			throws NoDataFoundException, JPAException {

		try {
			return getTypedQuery(namedQuery, parameters).getResultList();
		} catch (NoResultException ex) {
			throw new NoDataFoundException(ex.getMessage(), ex);
		} catch (PersistenceException | IllegalArgumentException ex) {
			throw new JPAException(ex.getMessage(), ex);
		}

	}

	private TypedQuery<T> getTypedQuery(String namedQuery, Parameter parameters) {

		TypedQuery<T> query = getEntityManager().createNamedQuery(namedQuery, getTypeClass());

		for (Map.Entry<String, String> parameter : parameters.getParameters()) {
			query.setParameter(parameter.getKey(), parameter.getValue());
		}

		return query;
	}

}