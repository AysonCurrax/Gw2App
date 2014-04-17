package gw2.api.service.api;

import gw2.api.persistence.domain.WorldName;

import java.util.List;

public interface ServiceFacade {

	List<WorldName> getAllWorldNames();
	List<WorldName> getWorldNamesByLanguage(String lang);
	List<WorldName> getWorldNamesById(String id);
	WorldName getWorldName(String id, String lang);
	void insertIntoWorlds(String id, String lang, String name);
	void update();
	void deleteFromWorlds(String id, String lang);
	void delete();
}
