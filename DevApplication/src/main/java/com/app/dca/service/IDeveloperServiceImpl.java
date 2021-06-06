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
	
	public IDeveloperServiceImpl(DeveloperRepository repo) {
	  this.repo = repo;
	}

   public IDeveloperServiceImpl() {
	super();
	}

	@Override
	@Transactional
	public Developer addDeveloper(Developer dev)
	{
		
		return repo.save(dev);
	}
	
	
	
	@Override
	public Developer getDeveloper(int devId) throws UnknownDeveloperException
	{
		Optional<Developer> s = repo.findById(devId);
		if(s.isEmpty()) {
			throw new UnknownDeveloperException(devId);
		}
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
