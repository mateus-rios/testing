package com.rivers.testing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rivers.testing.service.CalcService;

@RestController
public class CalcController {
	
	@Autowired
	private CalcService calcService;
	
	@GetMapping("/sum")
	public int sum() {
		return calcService.sum();
	}
	

}
