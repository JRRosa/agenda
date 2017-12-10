package org.ejemplo.com.dao.facade.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.ejemplo.com.dao.AbstractDao;
import org.ejemplo.com.dao.facade.ActivityFacade;
import org.ejemplo.com.dao.property.PropertyDao;
import org.ejemplo.com.entity.Activity;

public class ActivityFacadeImpl extends AbstractDao<Integer, Activity> implements ActivityFacade {
	
	@PersistenceContext(name=PropertyDao.PERSISTENCE_UNIT_NAME)
	EntityManager entityManager;

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	protected Class<Activity> getTypeClass() {
		return Activity.class;
	}

}
