package com.app.dca.restcontroller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dca.entity.FeedResponse;
import com.app.dca.exception.UnknownDeveloperException;
import com.app.dca.exception.UnknownFeedException;
import com.app.dca.exception.UnknownFeedResponseException;
import com.app.dca.service.IFeedResponseService;
import com.app.dca.service.IFeedResponseServiceImpl;

@Validated
@RestController
@RequestMapping("/api")
public class FeedResponseRestController {
	
	@Autowired
    IFeedResponseServiceImpl service;
	
	public FeedResponseRestController() {
		System.out.println("--------Response Rest Controller Constructor----------");
	}
	
	
	@PostMapping("/response")
	public FeedResponse addResponse(@RequestBody  FeedResponse resp)
	{
		service.addResponse(resp);
		return resp;
	}
	
	@PutMapping("/update")
	public FeedResponse updateFeedResponse(@RequestBody FeedResponse resp) {
		return service.editResponse(resp);
	}
	
	@GetMapping("/delete/{id}")
	public FeedResponse removeFeedResponse(@PathVariable int id) throws UnknownFeedResponseException {
		return service.removeResponse(id);
	}
	
	@GetMapping("/DevelopersFeedResponse/{id}")
	public List<FeedResponse> getFeedResponseByDeveloper(@PathVariable int id) throws UnknownDeveloperException {
		return service.getResponseByDeveloper(id);
	}
	
	@GetMapping("/FeedsFeedResponse/{id}")
	public List<FeedResponse> getFeedResponseByFeed(@PathVariable int id) throws UnknownFeedException {
		return service.getResponseByFeed(id);
	}
	
}
	
}//end class
