package gw2.api.webapp.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/v1")
public class TestController {

	@RequestMapping("/test")
	@ResponseBody
	public Map<String, String> testMap() {
		Map<String, String> result = new LinkedHashMap<String, String>();
		String dbHost = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
		String dbPort = System.getenv("OPENSHIFT_MYSQL_DB_PORT");
		result.put("foo", "bar");
		result.put(dbHost, dbPort);
		return result;
	}
}
