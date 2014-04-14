package gw2.api.persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import gw2.api.persistence.dao.api.WorldNameDao;
import gw2.api.persistence.domain.WorldName;

@Repository
public class WorldNameDaoImpl implements WorldNameDao{

	@PersistenceContext
	EntityManager em;
	
	public List<WorldName> getAllWorldNames() {
		List<WorldName> result = new ArrayList<WorldName>();
		TypedQuery<WorldName> query = em.createQuery("SELECT w FROM WorldName w", WorldName.class);
		result = query.getResultList();
		return result;
	}
}
