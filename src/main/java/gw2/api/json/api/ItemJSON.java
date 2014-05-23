package gw2.api.json.api;

import gw2.api.json.utility.ItemJSONObject;
import gw2.api.persistence.domain.ItemMapping;

import java.util.List;

public interface ItemJSON {

	List<Number> getIds();
	ItemJSONObject getMapping(String id);
}
