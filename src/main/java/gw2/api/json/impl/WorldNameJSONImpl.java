package gw2.api.json.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gw2.api.json.api.WorldNameJSON;
import gw2.api.json.utility.JSONRequest;
import gw2.api.json.utility.JSONRequest.RequestType;
import gw2.api.persistence.dao.api.WorldNameDao;
import gw2.api.persistence.domain.WorldNameEN;

@Service
public class WorldNameJSONImpl implements WorldNameJSON{

	@Autowired
	WorldNameDao worldNameDao;
	
	@Autowired
	JSONRequest request;
	
	private final String WORLDNAMES_URL_EN = "https://api.guildwars2.com/v1/world_names.json?lang=en";
	
	@Override
	public void update() {
		List<WorldNameEN> list = request.send(WORLDNAMES_URL_EN, RequestType.WORLD_NAME_EN);
		worldNameDao.insertIntoWorlds(list);
	}
	
	@Override
	public void delete() {
		List<WorldNameEN> list = request.send(WORLDNAMES_URL_EN, RequestType.WORLD_NAME_EN);
		worldNameDao.deleteFromWorlds(list);
	}
}
