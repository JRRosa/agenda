package org.ejemplo.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
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

}