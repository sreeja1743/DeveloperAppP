package com.app.dca.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dca.service.IUserService;
@Validated
@RestController
@RequestMapping("/api")
public class UserRestController {
	@Autowired
	private IUserService service;
	
	@GetMapping("/home")
	public String homeRequest() {
		return "welcome";		
	}


	public IUserService getService() {
		return service;
	}

	public void setService(IUserService service) {
		this.service = service;
	}
}