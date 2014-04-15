package gw2.api.persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import gw2.api.persistence.dao.api.WorldNameDao;
import gw2.api.persistence.domain.WorldName;
import gw2.api.persistence.domain.WorldName.WorldNameId;

@Repository
public class WorldNameDaoImpl implements WorldNameDao{

	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<WorldName> getAllWorldNames() {
		List<WorldName> result = new ArrayList<WorldName>();
		TypedQuery<WorldName> query = em.createQuery("SELECT w FROM WorldName w", WorldName.class);
		result = query.getResultList();
		return result;
	}
	
	@Override
	public void insertIntoWorlds(String id, String lang, String name) {
		WorldNameId wid = new WorldNameId(id, lang);
		WorldName world = em.find(WorldName.class, wid);
		if(world == null) {
		world = new WorldName();
		world.setId(id);
		world.setLang(lang);
		world.setName(name);
		em.persist(world);
		em.flush();
		}
	}
	
	@Override
	public void insertIntoWorlds(List<WorldName> list) {
		for(WorldName w : list) {
			WorldNameId wid = new WorldNameId(w.getId(), w.getLang());
			WorldName world = em.find(WorldName.class, wid);
			if(world == null) {
			em.persist(w);
			em.flush();
			}
		}
	}
	
	@Override
	public void deleteFromWorlds(String id, String lang) {
		WorldNameId wid = new WorldNameId(id, lang);
		WorldName world = em.find(WorldName.class, wid);
		if(world != null) {
			em.remove(world);
			em.flush();
		}	
	}
	
	@Override
	public void deleteFromWorlds(List<WorldName> list) {
		for(WorldName w : list) {
			WorldNameId wid = new WorldNameId(w.getId(), w.getLang());
			WorldName world = em.find(WorldName.class, wid);
			if(world != null) {
				em.remove(world);
				em.flush();
			}
		}
	}
}
