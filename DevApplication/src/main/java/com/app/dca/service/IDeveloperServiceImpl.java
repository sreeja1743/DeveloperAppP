package com.app.dca.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dca.entity.Developer;
import com.app.dca.exception.UnknownDeveloperException;
import com.app.dca.repository.DeveloperRepository;


@Service
public class IDeveloperServiceImpl implements IDeveloperService{
	@Autowired
	private DeveloperRepository repo;
	
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
	public Developer statusUpdate(Developer dev, int id) {
		Optional<Developer> up = repo.findById(id);
		Developer developer = null;
		if(up.isPresent())
		{
			developer = up.get();
			
			developer.setBlocked(dev.isBlocked());
		}
		
		return null;
	}
}
