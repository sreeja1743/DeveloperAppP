package com.app.dca.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dca.entity.Developer;
import com.app.dca.entity.Feed;
import com.app.dca.entity.Feedresponse;
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
	
	public IFeedServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IFeedServiceImpl(FeedRepository repo) {
		this.repo = repo;
	}

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
		return f;
	}

	@Override
	public Feed removeFeed(int feedId) throws UnknownFeedException {
		Feed feed = repo.findById(feedId).get();
		if(feed.equals(null))
			throw new UnknownFeedException();
	repo.deleteById(feedId);
		return feed;
	}

	@Override
	public Optional<List<Feed>> getFeedsByDeveloper(int devId) throws UnknownDeveloperException{
		Optional<List<Feed>> feed = repo.getFeedsByDeveloper(devId);
		if(feed==null || feed.isEmpty()) {
			throw new UnknownDeveloperException(devId);
		}
	   
		return feed;
	}
	
	public void getAllFeeds() {
		repo.findAll();
	}

	@Override
	public Optional<List<Feed>> getFeedsByKeyword(String keyword) {
		
		return repo.getFeedsByKeyWord(keyword);
	}

	@Override
	public Optional<List<Feed>> getFeedsByTopic(String topic) {
		
	return repo.getFeedsByTopic(topic);
	}

}
