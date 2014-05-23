package gw2.api.service.api;

import gw2.api.json.utility.ItemJSONObject;
import gw2.api.persistence.domain.ItemEN;
import gw2.api.persistence.domain.ItemMapping;
import gw2.api.persistence.domain.WorldNameEN;

import java.util.List;

public interface ServiceFacade {

	List<WorldNameEN> getAllWorldNames();
	List<WorldNameEN> getWorldNamesById(String id);
	WorldNameEN getWorldName(String id);
	void insertIntoWorlds(String id, String name);
	void update();
	void deleteFromWorlds(String id);
	void delete();
	List<Number> getIds();
	ItemJSONObject getMapping(String id);
}
