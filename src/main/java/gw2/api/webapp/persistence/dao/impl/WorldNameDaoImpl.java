package gw2.api.webapp.persistence.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import gw2.api.webapp.persistence.dao.api.WorldNameDao;

public class WorldNameDaoImpl implements WorldNameDao{

	@PersistenceContext
	EntityManager em;
	
}
