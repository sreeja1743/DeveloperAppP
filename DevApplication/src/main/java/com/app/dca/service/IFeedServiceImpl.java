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
import com.app.dca.repository.FeedRepository;


import com.app.dca.exception.UnknownFeedException;

@Service
public class IFeedServiceImpl implements IFeedService{

	@Autowired
	private FeedRepository repo;
	
	@Autowired
	private IDeveloperService devServcie;
	
	@Override
	@Transactional
	public Feed addFeed(Feed feed){
		return repo.save(feed);
	}

	@Override
	public Feed editFeed(Feed feed) {
		
		return repo.save(feed);
	}

	@Override
	public Feed likeFeed(int feedId){
		Feed f =  repo.findById(feedId).get();
		f.setRelevance(f.getRelevance()+1);
		return f;
	}

	@Override
	public Feed getFeed(int feedId) throws UnknownFeedException {
		Feed f = repo.findById(feedId).get();
		if(f.equals(null))
			throw new UnknownFeedException();
		return repo.findById(feedId).get();
	}

	@Override
	public String removeFeed(int feedId) throws UnknownFeedException {
		Feed feed = repo.findById(feedId).get();
		if(feed.equals(null))
			throw new UnknownFeedException();
	repo.deleteById(feedId);
		return "deleted";
	}

	@Override
	public List<Feed> getFeedsByDeveloper(int devId) throws UnknownDeveloperException{
	    Developer d = devServcie.getDeveloper(devId);
	    if(d.equals(null))
	    	throw new UnknownDeveloperException();
	    List<Feed> feed = repo.findAll();
	    List<Feed> newFeed = new ArrayList<>();
	    for (Feed feed2 : feed) {
			if(feed2.getDev().getDevId() == devId)
				newFeed.add(feed2);
		}
		return newFeed;
	}
	
	public void getAllFeeds() {
		repo.findAll();
	}

	@Override
	public List<Feed> getFeedsByKeyword(String keyword) {
		
		return repo.getFeedsByKeyWord(keyword);
	}

	@Override
	public List<Feed> getFeedsByTopic(String topic) {
		
	return repo.getFeedsByTopic(topic);
	}

}
