package com.afkl.cases.df.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.afkl.cases.df.service.LocationService;
import com.afkl.cases.df.vo.LocationVO;
import com.afkl.cases.df.vo.LocationsDataVO;

@RestController
@RequestMapping("/airports")
public class Airports {

	@Autowired
	LocationService locationService;
	
	@GetMapping
	public LocationsDataVO list(@RequestParam(name = "term", required=false) String searchTerm, @RequestParam(name = "page", required=false) Integer page){
		return locationService.list(searchTerm, page);
	}
	
	@GetMapping("/{code}")
	public LocationVO getByCode(@PathVariable String code){
		return locationService.getByLocationCode(code);
	}
	
}
