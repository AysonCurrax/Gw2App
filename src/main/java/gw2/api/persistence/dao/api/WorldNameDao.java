package gw2.api.persistence.dao.api;

import gw2.api.persistence.domain.WorldName;

import java.util.List;

public interface WorldNameDao {

	List<WorldName> getAllWorldNames();
}