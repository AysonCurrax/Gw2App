package gw2.api.persistence.dao.api;

import gw2.api.persistence.domain.WorldName;

import java.util.List;

public interface WorldNameDao {

	List<WorldName> getAllWorldNames();
	void insertIntoWorlds(String id, String lang, String name);
	void insertIntoWorlds(List<WorldName> list);
	void deleteFromWorlds(String id, String lang);
	void deleteFromWorlds(List<WorldName> list);
}
