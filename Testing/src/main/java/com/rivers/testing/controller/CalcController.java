package com.rivers.testing.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rivers.testing.service.CalcService;

@RestController
public class CalcController {
	
	@Autowired
	private CalcService calcService;
	
	@GetMapping("/sum")
	public Map<?,?> sum() {
		Map<String, Integer> x = new HashMap<>();
		x.put("data", calcService.sum());
		return x;
	}
	

}
