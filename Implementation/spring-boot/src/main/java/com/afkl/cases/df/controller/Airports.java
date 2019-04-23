package com.afkl.cases.df.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.afkl.cases.df.service.TravelService;
import com.afkl.cases.df.vo.LocationVO;
import com.afkl.cases.df.vo.LocationsDataVO;

@RestController
@RequestMapping("/airports")
public class Airports {

	@Autowired
	TravelService travelService;
	
	@GetMapping
	public LocationsDataVO list(@RequestParam(name = "term", required=false) String searchTerm, @RequestParam(name = "page", required=false) Integer page){
		return travelService.listLocations(searchTerm, page);
	}
	
	@GetMapping("/{code}")
	public LocationVO getByCode(@PathVariable String code){
		return travelService.getByLocationCode(code);
	}
	
}
