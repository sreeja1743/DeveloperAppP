package com.app.dca.restcontroller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dca.entity.FeedResponse;
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
	
	@GetMapping("/responses")
	public List<FeedResponse> getAllResponses()
	{
		return service.getAllResponses();
	}
	
}//end class
