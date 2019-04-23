package com.afkl.cases.df.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.afkl.cases.df.actuator.mapping.Root;
import com.afkl.cases.df.common.AppConfig;
import com.afkl.cases.df.util.MetricsUtility;
import com.afkl.cases.df.vo.FareVO;
import com.afkl.cases.df.vo.LocationVO;
import com.afkl.cases.df.vo.LocationsDataVO;
import com.afkl.cases.df.vo.MetricsVO;

@Service
public class TravelServiceImpl implements TravelService{

	@Autowired
	private RestTemplate msRestTemplate;

	@Autowired
	AppConfig appConfig;

	public LocationsDataVO listLocations(String searchTerm, Integer page, Integer size) {
		String url = appConfig.getServiceApiUrl() + "/airports";
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(url);
		if (searchTerm != null && !searchTerm.isEmpty()) {
			uriBuilder.queryParam("term", searchTerm);
		}
		if (page != null) {
			uriBuilder.queryParam("page", page);
		}
		if (size != null) {
			uriBuilder.queryParam("size", size);
		}
		return msRestTemplate.getForEntity(uriBuilder.build().toString(), LocationsDataVO.class).getBody();
	}
	
	public LocationVO getByLocationCode(String code) {
		String url = appConfig.getServiceApiUrl() + "/airports/" + code;
		return msRestTemplate.getForEntity(url, LocationVO.class).getBody();
	}
	
	public String getFare(String originCode, String destinationCode){
		String url = appConfig.getServiceApiUrl()+"/fares/" + originCode + "/" + destinationCode;
		System.out.println("fare api url->" + url);
		return msRestTemplate.getForEntity(url , String.class).getBody();
	}
	
	public FareVO getFare2(String originCode, String destinationCode){
		String url = appConfig.getServiceApiUrl()+"/fares/" + originCode + "/" + destinationCode;
		System.out.println("api url->" + url);
		FareVO fareVO =  msRestTemplate.getForEntity(url , FareVO.class).getBody();
		try {
			CompletableFuture<LocationVO> originCall = findLocationByCodeAsync(fareVO.getOrigin());
			CompletableFuture<LocationVO> destinationCall = findLocationByCodeAsync(fareVO.getOrigin());
			CompletableFuture.allOf(originCall,destinationCall).join();
			fareVO.setOriginLocation(originCall.get());
			fareVO.setDestVO(destinationCall.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return fareVO;
	}
	
	@Async("threadPoolTaskExecutor")
	public CompletableFuture<LocationVO> findLocationByCodeAsync(String code) throws InterruptedException {
		LocationVO locationVO = getByLocationCode(code);
		return CompletableFuture.completedFuture(locationVO);
	}
	
	public MetricsVO getHealthMetrics() {
		String url = appConfig.getActuatorUrl() + "/actuator/httptrace";
		Root traceData = msRestTemplate.getForEntity(url , Root.class).getBody();
		MetricsUtility utility = new MetricsUtility();
		MetricsVO metricsVO = utility.processAndReturnMetrics(traceData);
		return metricsVO;
	}
}
