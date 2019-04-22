package com.afkl.cases.df.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.afkl.cases.df.common.AppConfig;
import com.afkl.cases.df.vo.LocationVO;
import com.afkl.cases.df.vo.LocationsDataVO;

@Service
public class LocationService {
	
	@Autowired
	private RestTemplate msRestTemplate;
	
	@Autowired
	AppConfig appConfig;
	
	public LocationsDataVO list(String searchTerm, Integer page) {
		String url = appConfig.getServiceApiUrl()+"/airports";
		
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(url);
		
		if(searchTerm !=null && !searchTerm.isEmpty()) {
			uriBuilder.queryParam("term", searchTerm);
		}
		
		if(page !=null) {
			uriBuilder.queryParam("page", page);
		}
		
		return msRestTemplate.getForEntity(uriBuilder.build().toString(), LocationsDataVO.class).getBody();
	}
	
	public LocationVO getByLocationCode(String code) {
		String url = appConfig.getServiceApiUrl() + "/airports/" + code;
		return msRestTemplate.getForEntity(url , LocationVO.class).getBody();
	}

}
