package com.afkl.cases.df.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.afkl.cases.df.service.TravelService;
import com.afkl.cases.df.vo.FareVO;

@RestController
@RequestMapping("/fares")
public class Fares {
	
	@Autowired
	TravelService travelService;
	
	@GetMapping
	public String list(@RequestParam("origin") String origin, @RequestParam("dest") String destination){
		return travelService.getFare(origin, destination);
	}
	
	@GetMapping("/list2")
	public FareVO list2(@RequestParam("origin") String origin, @RequestParam("dest") String destination){
		return travelService.getFare2(origin, destination);
	}
	
}
