package com.afkl.cases.df.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.afkl.cases.df.service.FareService;
import com.afkl.cases.df.vo.FareVO;

@RestController
@RequestMapping("/fares")
public class Fares {
	
	@Autowired
	FareService fareService;
	
	@GetMapping
	public String list(@RequestParam("origin") String origin, @RequestParam("dest") String destination){
		return fareService.getFare(origin, destination);
	}
	
	@GetMapping("/list2")
	public FareVO list2(@RequestParam("origin") String origin, @RequestParam("dest") String destination){
		return fareService.getFare2(origin, destination);
	}
	
}
