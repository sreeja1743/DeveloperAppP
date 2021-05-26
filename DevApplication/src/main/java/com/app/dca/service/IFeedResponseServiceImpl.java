package com.app.dca.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dca.entity.FeedResponse;
import com.app.dca.exception.UnknownDeveloperException;
import com.app.dca.exception.UnknownFeedException;
import com.app.dca.exception.UnknownFeedResponseException;
import com.app.dca.repository.FeedResponseRepository;
import com.app.dca.repository.IFeedResponseRepository;

@Service
public class IFeedResponseServiceImpl implements IFeedResponseService {
	
	@Autowired
	private FeedResponseRepository repo;
	
	
	@Override
	@Transactional
	public FeedResponse addResponse(FeedResponse resp) {
		
		repo.save(resp);
		return resp;
	}

	
	@Override
	public FeedResponse editResponse(FeedResponse resp, Integer id) {
		// TODO Auto-generated method stub
		Optional<FeedResponse> up = repo.findById(id);
		FeedResponse response = null;

		if(up.isPresent())
		{
			 response = up.get();

			response.setRespId(resp.getRespId());
			response.setAnswer(resp.getAnswer());
			response.setRespDate(resp.getRespDate());
			response.setRespTime(resp.getRespTime());
			response.setAccuracy(resp.getAccuracy());
			response.setDev(resp.getDev());
			response.setFeed(resp.getFeed());
			return repo.save(response);
		}
		
		return response;
	}

	@Override
	public FeedResponse removeResponse(int respId) throws UnknownFeedResponseException {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public FeedResponse likeResponse(int respId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FeedResponse> getResponseByFeed(int feedId) throws UnknownFeedException {

		return repo.findAll();
	}

	@Override
	public List<FeedResponse> getResponseByDeveloper(int devId) throws UnknownDeveloperException {
            
		return null;
	}


	@Override
	public FeedResponse editResponse(FeedResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<FeedResponse> getAllResponses() {

		System.out.println("Inside get all responses");
		return repo.findAll();
	}

} //end class