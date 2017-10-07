package org.ejemplo.com.dao.facade.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.ejemplo.com.dao.AbstractDao;
import org.ejemplo.com.dao.facade.ActividadFacade;
import org.ejemplo.com.entity.Actividad;

public class ActiviadFacadeImpl extends AbstractDao<Integer, Actividad> implements ActividadFacade {
	
	@PersistenceContext(name="agenda")
	EntityManager entityManager;

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	protected Class<Actividad> getTypeClass() {
		return Actividad.class;
	}

}
