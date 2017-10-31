package org.ejemplo.com.dao.facade.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.ejemplo.com.dao.AbstractDao;
import org.ejemplo.com.dao.facade.UsuarioFacade;
import org.ejemplo.com.dao.property.PropertyDao;
import org.ejemplo.com.entity.User;

public class UsuarioFacadeImpl extends AbstractDao<Integer, User> implements UsuarioFacade {

	@PersistenceContext(name=PropertyDao.PERSISTENCE_UNIT_NAME)
	EntityManager entityManager; 
	
	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	protected Class<User> getTypeClass() {
		return User.class;
	}

	
	
}
