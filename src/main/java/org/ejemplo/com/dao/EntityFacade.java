package org.ejemplo.com.dao;

import java.util.List;

import org.ejemplo.com.dao.exceptions.JPAException;
import org.ejemplo.com.dao.exceptions.NoDataFoundException;

public interface EntityFacade<K, T> {
	public T create(T entity) throws JPAException;

	public T update(T entity) throws JPAException;
	
	public void delete(T entity) throws JPAException;

	public T findById(K id) throws NoDataFoundException, JPAException;

	public List<T> findAll() throws NoDataFoundException, JPAException;

}
