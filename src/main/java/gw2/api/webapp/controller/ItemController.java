package gw2.api.webapp.controller;

import java.util.List;

import gw2.api.json.utility.ItemJSONObject;
import gw2.api.service.api.ServiceFacade;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/items")
public class ItemController {

	@Autowired
	ServiceFacade services;
	
	@RequestMapping
	@ResponseBody
	public List<Number> getIds() {
		return services.getIds();
	}
	
	@RequestMapping("/get/{id}")
	@ResponseBody
	public ItemJSONObject getMapping(@PathVariable String id) {
		return services.getMapping(id);
	}
	
	@RequestMapping("/encodeBase64/{id}")
	@ResponseBody
	public String encodeBase64(@PathVariable Long id) {
		StringBuilder result = new StringBuilder();
		result.append("[&");
		byte[] bytes = new byte[6];
		bytes[0] = 0x02;
		bytes[1] = 0x01;
		if(id != null) {
			bytes[2] = (byte) (id % 256);
			bytes[3] = (byte) (id / 256);
		}
		bytes[4] = 0x00;
		bytes[5] = 0x00;
		result.append(Base64.encodeBase64String(bytes));
		result.append("]");
		return result.toString();
	}
	
	@RequestMapping("/decodeBase64/{base64}")
	@ResponseBody
	public String decodeBase64(@PathVariable String base64) {
		byte[] bytes = Base64.decodeBase64(base64);
		long l1 = (long) bytes[3];
		long l2 = (long) bytes[2];
		
		if(l1 < 0) {
			l1 = 256 + l1;
		}
		l1 = l1 * 256;
		if(l2 < 0) {
			l2 = 256 + l2;
		}
		l1 = l1 + l2;
		return ""+l1;
	}
}
