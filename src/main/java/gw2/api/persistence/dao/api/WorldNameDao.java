package gw2.api.persistence.dao.api;

import gw2.api.persistence.domain.WorldNameEN;

import java.util.List;

public interface WorldNameDao {

	List<WorldNameEN> getAllWorldNames();
	List<WorldNameEN> getWorldNamesById(String id);
	WorldNameEN getWorldName(String id);
	void insertIntoWorlds(String id, String name);
	void insertIntoWorlds(List<WorldNameEN> list);
	void deleteFromWorlds(String id);
	void deleteFromWorlds(List<WorldNameEN> list);
}
