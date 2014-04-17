package gw2.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gw2.api.json.api.WorldNameJSON;
import gw2.api.persistence.dao.api.WorldNameDao;
import gw2.api.persistence.domain.WorldName;
import gw2.api.service.api.ServiceFacade;

@Service
public class ServiceFacadeImpl implements ServiceFacade{

	@Autowired
	WorldNameDao worldNameDao;
	
	@Autowired
	WorldNameJSON worldNameJSON;
	
	@Override
	public List<WorldName> getAllWorldNames() {
		return worldNameDao.getAllWorldNames();
	}
	
	@Override
	public List<WorldName> getWorldNamesByLanguage(String lang) {
		return worldNameDao.getWorldNamesByLanguage(lang);
	}
	
	@Override
	public List<WorldName> getWorldNamesById(String id) {
		return worldNameDao.getWorldNamesById(id);
	}
	
	@Override
	public WorldName getWorldName(String id, String lang) {
		return worldNameDao.getWorldName(id, lang);
	}
	
	@Override
	public void insertIntoWorlds(String id, String lang, String name) {
		worldNameDao.insertIntoWorlds(id, lang, name);
	}
	
	@Override
	public void update() {
		worldNameJSON.update();;
	}
	
	@Override
	public void deleteFromWorlds(String id, String lang) {
		worldNameDao.deleteFromWorlds(id, lang);
	}
	
	@Override
	public void delete() {
		worldNameJSON.delete();
	}
}
