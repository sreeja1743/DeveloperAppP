package com.app.dca.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dca.entity.Developer;
import com.app.dca.entity.Feed;
import com.app.dca.entity.FeedResponse;
import com.app.dca.exception.UnknownDeveloperException;
import com.app.dca.exception.UnknownFeedException;
import com.app.dca.exception.UnknownFeedResponseException;
import com.app.dca.repository.DeveloperRepository;
import com.app.dca.repository.FeedRepository;
import com.app.dca.repository.FeedResponseRepository;


@Service
public class IFeedResponseServiceImpl implements IFeedResponseService {
	
	@Autowired
	private FeedResponseRepository repo;
	@Autowired
	private FeedRepository fr;
  
	
	
	@Override
	@Transactional
	public FeedResponse addResponse(FeedResponse resp) {
		
		repo.save(resp);
		return resp;
	}

	
	@Override
	public FeedResponse editResponse(FeedResponse resp, Integer id) {
		
		return repo.save(resp);
	}

	@Override
	public FeedResponse removeResponse(int respId) throws UnknownFeedResponseException {
		 FeedResponse f = repo.findById(respId).get();
		 if(f.equals(null))
			 throw new UnknownFeedResponseException();
		 repo.deleteById(respId);
		return f;
		
	}

	@Override
	public FeedResponse likeResponse(int respId) {
		
		FeedResponse resp = repo.findById(respId).get();
		resp.setAccuracy(resp.getAccuracy()+1);
		return resp;
		
		
	}

	@Override
	public List<FeedResponse> getResponseByFeed(int feedId) throws UnknownFeedException {
		Feed f = fr.findById(feedId).get();
		 if(f.equals(null))
			 throw new UnknownFeedException();
		 List<FeedResponse> feedResponse = repo.findAll();
		 List<FeedResponse> newFeedResponse = new ArrayList<>(); 
		 for (FeedResponse feedResponse2 : feedResponse) {
			  if(feedResponse2.getFeed().getFeedId() == feedId)
				  newFeedResponse.add(feedResponse2);
		}
		return newFeedResponse;
	}
	
	@Override
	public List<FeedResponse> getResponseByDeveloper(int devId) throws UnknownDeveloperException {
		//Developer d = dr.findById(devId).get();
            
		return null;
	}


	@Override
	public FeedResponse editResponse(FeedResponse resp) {
		
		return repo.save(resp);
	}


	@Override
	public List<FeedResponse> getAllResponses() {

		return repo.findAll();
	}



} //end class