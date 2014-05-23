package gw2.api.webapp.controller;

import gw2.api.persistence.domain.WorldNameEN;
import gw2.api.service.api.ServiceFacade;
import gw2.api.webapp.model.TestData;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/api/v1")
public class TestController {
	
	private Logger logger = LoggerFactory.getLogger(TestController.class);
	
	private List<TestData> dataList = new ArrayList<TestData>();
	
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
	public List<WorldNameEN> testService() {
		List<WorldNameEN> result = new ArrayList<WorldNameEN>();
		result = services.getAllWorldNames();
		return result;
	}
	
	@RequestMapping("/testGetById/{id}")
	@ResponseBody
	public List<WorldNameEN> testGetById(@PathVariable String id) {
		return services.getWorldNamesById(id);
	}
	
	@RequestMapping("/testGetSingle/en/{id}")
	@ResponseBody
	public WorldNameEN testGetSingle(@PathVariable String id) {
		return services.getWorldName(id);
	}
	
	@RequestMapping("/testInsert/{id}/en/{name}")
	@ResponseBody
	public String testInsert(@PathVariable String id, @PathVariable String name) {
		services.insertIntoWorlds(id, name);
		return "Eintrag hinzugefügt.";
	}
	
	@RequestMapping("/testDelete/{id}/en")
	@ResponseBody
	public String testDelete(@PathVariable String id) {
		services.deleteFromWorlds(id);
		return "Eintrag gelöscht.";
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public String updateTable() {
		services.update();
		return "updated.";
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public String deleteTable() {
		services.delete();
		return "deleted.";
	}
	
	@RequestMapping(value = "/jspTest", method = RequestMethod.GET)
	public ModelAndView handleJspTestRequest() {
		ModelAndView model = new ModelAndView("JspTest");
		model.addObject("dataList", dataList);
		return model;
	}
	
	@RequestMapping(value = "/jspTest", method = RequestMethod.POST)
	@ResponseBody
	public String jspTestPostResponse(@ModelAttribute("text") TestData test) {
		dataList.add(test);
		return "Your Value has been added.";
	}
}
