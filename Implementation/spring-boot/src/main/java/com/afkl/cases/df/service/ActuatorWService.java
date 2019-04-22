package com.afkl.cases.df.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.afkl.cases.df.actuator.mapping.Root;
import com.afkl.cases.df.common.AppConfig;
import com.afkl.cases.df.util.MetricsUtility;
import com.afkl.cases.df.vo.MetricsVO;

@Service
public class ActuatorWService {
	@Autowired
	private RestTemplate msRestTemplate;
	
	@Autowired
	AppConfig appConfig;
	
	public MetricsVO getHealthMetrics() {
		String url = appConfig.getActuatorUrl() + "/actuator/httptrace";
		
		Root traceData = msRestTemplate.getForEntity(url , Root.class).getBody();
		MetricsUtility utility = new MetricsUtility();
		
		MetricsVO metricsVO = utility.processAndReturnMetrics(traceData);
		
		return metricsVO;
	}
}
