package gw2.api.json.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gw2.api.json.api.WorldNameJSON;
import gw2.api.json.utility.JSONRequest;
import gw2.api.persistence.dao.api.WorldNameDao;
import gw2.api.persistence.domain.WorldName;

@Service
public class WorldNameJSONImpl implements WorldNameJSON{

	@Autowired
	WorldNameDao worldNameDao;
	
	@Autowired
	JSONRequest request;
	
	@Override
	public void update() {
		List<WorldName> list = request.send("https://api.guildwars2.com/v1/world_names.json?lang=");
		worldNameDao.insertIntoWorlds(list);
	}
	
	@Override
	public void delete() {
		List<WorldName> list = request.send("https://api.guildwars2.com/v1/world_names.json?lang=");
		worldNameDao.deleteFromWorlds(list);
	}
}
