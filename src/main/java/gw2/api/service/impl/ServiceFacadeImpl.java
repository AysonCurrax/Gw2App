package gw2.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gw2.api.json.api.ItemJSON;
import gw2.api.json.api.WorldNameJSON;
import gw2.api.json.utility.ItemJSONObject;
import gw2.api.persistence.dao.api.WorldNameDao;
import gw2.api.persistence.domain.ItemEN;
import gw2.api.persistence.domain.ItemMapping;
import gw2.api.persistence.domain.WorldNameEN;
import gw2.api.service.api.ServiceFacade;

@Service
public class ServiceFacadeImpl implements ServiceFacade{

	@Autowired
	WorldNameDao worldNameDao;
	
	@Autowired
	WorldNameJSON worldNameJSON;
	
	@Autowired
	ItemJSON itemJSON;
	
	@Override
	public List<WorldNameEN> getAllWorldNames() {
		return worldNameDao.getAllWorldNames();
	}
	
	@Override
	public List<WorldNameEN> getWorldNamesById(String id) {
		return worldNameDao.getWorldNamesById(id);
	}
	
	@Override
	public WorldNameEN getWorldName(String id) {
		return worldNameDao.getWorldName(id);
	}
	
	@Override
	public void insertIntoWorlds(String id, String name) {
		worldNameDao.insertIntoWorlds(id, name);
	}
	
	@Override
	public void update() {
		worldNameJSON.update();
	}
	
	@Override
	public void deleteFromWorlds(String id) {
		worldNameDao.deleteFromWorlds(id);
	}
	
	@Override
	public void delete() {
		worldNameJSON.delete();
	}
	
	@Override
	public List<Number> getIds() {
		return itemJSON.getIds();
	}
	
	@Override
	public ItemJSONObject getMapping(String id) {
		return itemJSON.getMapping(id);
	}
}
