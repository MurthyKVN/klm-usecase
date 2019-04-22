package com.afkl.cases.df.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.afkl.cases.df.common.AppConfig;
import com.afkl.cases.df.vo.FareVO;
import com.afkl.cases.df.vo.LocationVO;

@Service
public class FareService {

	@Autowired
	RestTemplate msRestTemplate;
	
	@Autowired
	LocationService locationService;
	
	@Autowired
	AppConfig appConfig;
	
	public String getFare(String originCode, String destinationCode){
		String url = appConfig.getServiceApiUrl()+"/fares/" + originCode + "/" + destinationCode;
		System.out.println("api url->" + url);
		return msRestTemplate.getForEntity(url , String.class).getBody();
	}
	
	public FareVO getFare2(String originCode, String destinationCode){
		String url = appConfig.getServiceApiUrl()+"/fares/" + originCode + "/" + destinationCode;
		System.out.println("api url->" + url);
		FareVO fareVO =  msRestTemplate.getForEntity(url , FareVO.class).getBody();
		
		try {
			CompletableFuture<LocationVO> originCall = findLocationByCode(fareVO.getOrigin());
			CompletableFuture<LocationVO> destinationCall = findLocationByCode(fareVO.getOrigin());
			
			CompletableFuture.allOf(originCall,destinationCall).join();
			
			fareVO.setOriginLocation(originCall.get());
			fareVO.setDestVO(destinationCall.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fareVO;
	}
	
	@Async("threadPoolTaskExecutor")
	public CompletableFuture<LocationVO> findLocationByCode(String code) throws InterruptedException {
		LocationVO locationVO = locationService.getByLocationCode(code);
		return CompletableFuture.completedFuture(locationVO);
	}
}
