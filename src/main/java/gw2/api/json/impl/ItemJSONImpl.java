package gw2.api.json.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gw2.api.json.api.ItemJSON;
import gw2.api.json.utility.ItemJSONObject;
import gw2.api.json.utility.JSONRequest;
import gw2.api.json.utility.JSONRequest.RequestType;
import gw2.api.persistence.domain.ItemEN;
import gw2.api.persistence.domain.ItemMapping;

@Service
public class ItemJSONImpl implements ItemJSON{
	
	@Autowired
	JSONRequest request;
	
	private final String ITEMS_URL = "https://api.guildwars2.com/v1/items.json";
	private final String ITEMS_MAPPING = "https://api.guildwars2.com/v1/item_details.json?item_id=";
	
	@Override
	public List<Number> getIds() {
		List<Number> list = request.send(ITEMS_URL, RequestType.ITEM_ID);
		return list;
	}
	
	@Override
	public ItemJSONObject getMapping(String id) {
		ItemJSONObject list = request.send(ITEMS_MAPPING+id, RequestType.ITEM_MAPPING);
		return list;
	}
}
