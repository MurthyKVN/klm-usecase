package com.afkl.cases.df.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("application.properties")
public class AppConfig {
	
	@Value("${travel.serviceApiUrl}")
	private String serviceApiUrl;
	
	@Value("${travel.actuatorUrl}")
	private String actuatorUrl;
	
	
	public String getServiceApiUrl() {
		return serviceApiUrl;
	}
	public void setServiceApiUrl(String serviceApiUrl) {
		this.serviceApiUrl = serviceApiUrl;
	}
	public String getActuatorUrl() {
		return actuatorUrl;
	}
	public void setActuatorUrl(String actuatorUrl) {
		this.actuatorUrl = actuatorUrl;
	}
}
