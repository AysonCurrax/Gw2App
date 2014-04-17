package gw2.api.json.utility;

import gw2.api.persistence.domain.WorldName;

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

	private RestTemplate rest = new RestTemplate();
	
	private ObjectMapper mapper = new ObjectMapper();
	
	public List<WorldName> send(String url) {
		List<WorldName> list = new ArrayList<WorldName>();
		String json = null;
			json = rest.getForObject(url, String.class);
			try {
				JsonNode node = mapper.readTree(json);
				list = mapper.readValue(node.traverse(), new TypeReference<List<WorldName>>() {
				});
			} catch (IOException e) {
				e.getMessage();
			}
		return list;	
	}
}
