package gw2.api.persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import gw2.api.persistence.dao.api.WorldNameDao;
import gw2.api.persistence.domain.WorldNameEN;

@Repository
public class WorldNameDaoImpl implements WorldNameDao{

	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<WorldNameEN> getAllWorldNames() {
		List<WorldNameEN> result = new ArrayList<WorldNameEN>();
		TypedQuery<WorldNameEN> query = em.createQuery("SELECT w FROM WorldNameEN w", WorldNameEN.class);
		result = query.getResultList();
		return result;
	}
	
	@Override
	public List<WorldNameEN> getWorldNamesById(String id) {
		List<WorldNameEN> result = new ArrayList<WorldNameEN>();
		TypedQuery<WorldNameEN> query = em.createQuery("SELECT w FROM WorldNameEN w WHERE w.id=:id", WorldNameEN.class);
		query.setParameter("id", id);
		result = query.getResultList();
		return result;
	}
	
	@Override
	public WorldNameEN getWorldName(String id) {
		WorldNameEN result = em.find(WorldNameEN.class, id);
		return result;
	}
	
	@Override
	@Transactional
	public void insertIntoWorlds(String id, String name) {
		WorldNameEN world = em.find(WorldNameEN.class, id);
		if(world == null) {
		world = new WorldNameEN();
		world.setId(id);
		world.setName(name);
		em.persist(world);
		em.flush();
		}
	}
	
	@Override
	@Transactional
	public void insertIntoWorlds(List<WorldNameEN> list) {
		for(WorldNameEN w : list) {
			WorldNameEN world = em.find(WorldNameEN.class, w.getId());
			if(world == null) {
			em.persist(w);
			em.flush();
			}
		}
	}
	
	@Override
	@Transactional
	public void deleteFromWorlds(String id) {
		WorldNameEN world = em.find(WorldNameEN.class, id);
		if(world != null) {
			em.remove(world);
			em.flush();
		}	
	}
	
	@Override
	@Transactional
	public void deleteFromWorlds(List<WorldNameEN> list) {
		for(WorldNameEN w : list) {
			WorldNameEN world = em.find(WorldNameEN.class, w.getId());
			if(world != null) {
				em.remove(world);
				em.flush();
			}
		}
	}
}
