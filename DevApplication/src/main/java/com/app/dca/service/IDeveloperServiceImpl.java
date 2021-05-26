package com.app.dca.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dca.entity.Developer;
import com.app.dca.exception.UnknownDeveloperException;
import com.app.dca.repository.IDeveloperRepository;

@Service
public class IDeveloperServiceImpl implements IDeveloperService{
	@Autowired
	private  IDeveloperRepository repo;
	
	@Override
	@Transactional
	public Developer addDeveloper(Developer dev)
	{
		
		return repo.save(dev);
	}
	
	
	
	@Override
	public Developer getDeveloper(int devId) throws UnknownDeveloperException
	{
		return repo.findById(devId).get();
	}
	
	@Override
	public List<Developer> getAllDevelopers()
	{
		return repo.findAll();
	}

	@Override
	public Developer editDeveloper(Developer dev) {
		
		return repo.save(dev);
	}



	@Override
	public Developer statusUpdate(Developer dev) {
		// TODO Auto-generated method stub
		return null;
	}
}
