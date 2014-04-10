package gw2.api.webapp.controller;

import java.util.HashMap;
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
		Map<String, String> result = new HashMap<String, String>();
		result.put("foo", "bar");
		return result;
	}
}
