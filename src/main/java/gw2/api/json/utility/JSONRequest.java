package gw2.api.json.utility;

import gw2.api.persistence.domain.ItemMapping;
import gw2.api.persistence.domain.WorldNameEN;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class JSONRequest {

	public enum RequestType {
		WORLD_NAME_EN,
		ITEM_ID,
		ITEM_MAPPING;
		
		private RequestType() {
			
		}
	}
	private RestTemplate rest = new RestTemplate();
	
	private ObjectMapper mapper = new ObjectMapper();
	
	public <T> List<T> sendList(String url, RequestType r) {
		List<T> list = new ArrayList<T>();
		String json = null;
		JsonNode node;
		json = rest.getForObject(url, String.class);
		try {
			if(r.equals(RequestType.WORLD_NAME_EN)) {
				node = mapper.readTree(json);
				list = mapper.readValue(node.traverse(), new TypeReference<List<WorldNameEN>>() {});
			} 
			else if(r.equals(RequestType.ITEM_ID)) {
				node = mapper.readTree(json);
				node = node.get("items");
				list = mapper.readValue(node.traverse(), new TypeReference<List<Number>>() {});
			}
		} catch (IOException e) {
			e.getMessage();
		}
		return list;	
	}
	
	public <T> T send(String url, RequestType r) {
		T result = null;
		String json = null;
		JsonNode node;
		json = rest.getForObject(url, String.class);
		try {
			if(r.equals(RequestType.ITEM_MAPPING)) {
				node = mapper.readTree(json);
				result = mapper.readValue(node.traverse(), new TypeReference<ItemJSONObject>() {});
			}
			else if(r.equals(RequestType.ITEM_ID)) {
				node = mapper.readTree(json);
				node = node.get("items");
				result = mapper.readValue(node.traverse(), new TypeReference<List<Number>>() {});
			}
		} catch (IOException e) {
			e.getMessage();
		}
		return result;
	}
}
