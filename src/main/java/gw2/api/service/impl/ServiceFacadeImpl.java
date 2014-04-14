package gw2.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gw2.api.persistence.dao.api.WorldNameDao;
import gw2.api.persistence.domain.WorldName;
import gw2.api.service.api.ServiceFacade;

@Service
public class ServiceFacadeImpl implements ServiceFacade{

	@Autowired
	WorldNameDao worldNameDao;
	
	@Override
	public List<WorldName> getAllWorldNames() {
		return worldNameDao.getAllWorldNames();
	}
}
