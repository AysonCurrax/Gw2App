package gw2.api.service.api;

import gw2.api.persistence.domain.WorldName;

import java.util.List;

public interface ServiceFacade {

	List<WorldName> getAllWorldNames();
}
