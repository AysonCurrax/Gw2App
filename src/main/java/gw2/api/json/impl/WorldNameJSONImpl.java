package gw2.api.json.impl;

import java.util.ArrayList;
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
	
	private static String WORLDNAMES_URL_DE = "https://api.guildwars2.com/v1/world_names.json?lang=de";
	private static String WORLDNAMES_URL_EN = "https://api.guildwars2.com/v1/world_names.json?lang=en";
	private static String WORLDNAMES_URL_ES = "https://api.guildwars2.com/v1/world_names.json?lang=es";
	private static String WORLDNAMES_URL_FR = "https://api.guildwars2.com/v1/world_names.json?lang=fr";
	
	@Override
	public void update() {
		List<WorldName> list = new ArrayList<WorldName>();
		List<WorldName> listDE = request.send(WORLDNAMES_URL_DE);
		List<WorldName> listEN = request.send(WORLDNAMES_URL_EN);
		List<WorldName> listES = request.send(WORLDNAMES_URL_ES);
		List<WorldName> listFR = request.send(WORLDNAMES_URL_FR);
		listDE = setLang(listDE, "de");
		listEN = setLang(listEN, "en");
		listES = setLang(listES, "es");
		listFR = setLang(listFR, "fr");
		list.addAll(listDE);
		list.addAll(listEN);
		list.addAll(listES);
		list.addAll(listFR);
		worldNameDao.insertIntoWorlds(list);
	}
	
	@Override
	public void delete() {
		List<WorldName> list = new ArrayList<WorldName>();
		List<WorldName> listDE = request.send(WORLDNAMES_URL_DE);
		List<WorldName> listEN = request.send(WORLDNAMES_URL_EN);
		List<WorldName> listES = request.send(WORLDNAMES_URL_ES);
		List<WorldName> listFR = request.send(WORLDNAMES_URL_FR);
		listDE = setLang(listDE, "de");
		listEN = setLang(listEN, "en");
		listES = setLang(listES, "es");
		listFR = setLang(listFR, "fr");
		list.addAll(listDE);
		list.addAll(listEN);
		list.addAll(listES);
		list.addAll(listFR);
		worldNameDao.deleteFromWorlds(list);
	}
	
	public List<WorldName> setLang(List<WorldName> list, String lang) {
		for(WorldName w : list) {
			w.setLang(lang);
		}
		return list;
	}
}
