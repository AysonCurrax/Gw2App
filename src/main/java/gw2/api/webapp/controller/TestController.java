package gw2.api.webapp.controller;

import gw2.api.persistence.domain.WorldName;
import gw2.api.service.api.ServiceFacade;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/v1")
public class TestController {
	
	private Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	ServiceFacade services;
	
	@RequestMapping("/test")
	@ResponseBody
	public Map<String, String> testMap() {
		
		Map<String, String> result = new LinkedHashMap<String, String>();
		for(int i=0;i<50;i++) {
			result.put("foo"+i, "bar"+i);
			logger.debug("{} : {} added.", "foo"+i, "bar"+i);
		}
		return result;
	}
	
	@RequestMapping("/testService")
	@ResponseBody
	public List<WorldName> testService() {
		List<WorldName> result = new ArrayList<WorldName>();
		result = services.getAllWorldNames();
		return result;
	}
	
	@RequestMapping("/testGetById/{id}")
	@ResponseBody
	public List<WorldName> testGetById(@PathVariable String id) {
		return services.getWorldNamesById(id);
	}
	
	@RequestMapping("/testGetByLang/{lang}")
	@ResponseBody
	public List<WorldName> testGetByLang(@PathVariable String lang) {
		return services.getWorldNamesByLanguage(lang);
	}
	
	@RequestMapping("/testGetSingle/{lang}/{id}")
	@ResponseBody
	public WorldName testGetSingle(@PathVariable String lang, @PathVariable String id) {
		return services.getWorldName(id, lang);
	}
	
	@Transactional
	@RequestMapping("/testInsert/{id}/{lang}/{name}")
	@ResponseBody
	public String testInsert(@PathVariable String id, @PathVariable String lang, @PathVariable String name) {
		services.insertIntoWorlds(id, lang, name);
		return "Eintrag hinzugefügt.";
	}
	
	@Transactional
	@RequestMapping("/testDelete/{id}/{lang}")
	@ResponseBody
	public String testDelete(@PathVariable String id, @PathVariable String lang) {
		services.deleteFromWorlds(id, lang);
		return "Eintrag gelöscht.";
	}
	
	@Transactional
	@RequestMapping("/update")
	@ResponseBody
	public String updateTable() {
		services.update();
		return "updated.";
	}
	
	@Transactional
	@RequestMapping("/delete")
	@ResponseBody
	public String deleteTable() {
		services.delete();
		return "deleted.";
	}
}
