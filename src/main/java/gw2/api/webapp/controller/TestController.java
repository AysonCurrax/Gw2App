package gw2.api.webapp.controller;

import gw2.api.persistence.domain.WorldName;
import gw2.api.service.api.ServiceFacade;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/v1")
public class TestController {

	@Autowired
	ServiceFacade services;
	
	@RequestMapping("/test")
	@ResponseBody
	public Map<String, String> testMap() {
		Map<String, String> result = new LinkedHashMap<String, String>();
		/*
		String dbHost = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
		String dbPort = System.getenv("OPENSHIFT_MYSQL_DB_PORT");
		String dbUser = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
		String dbPass = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
		String dbUrl = System.getenv("OPENSHIFT_MYSQL_DB_URL");
		*/
		for(int i=0;i<50;i++) {
			result.put("foo"+i, "bar"+i);
		}
		/*
		result.put("foo", "bar");
		result.put(dbHost, dbPort);
		result.put(dbUser, dbPass);
		result.put(dbUrl, "ok");
		*/
		return result;
	}
	
	@RequestMapping("/testService")
	@ResponseBody
	public List<WorldName> testService() {
		List<WorldName> result = new ArrayList<WorldName>();
		result = services.getAllWorldNames();
		return result;
	}
}
