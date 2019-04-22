package com.afkl.cases.df.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.afkl.cases.df.service.ActuatorWService;
import com.afkl.cases.df.vo.MetricsVO;

@RestController
@RequestMapping("/actuator")
public class MgmtWrapper {
	
	@Autowired
	private ActuatorWService mgmtService;
	
	@GetMapping("getHealthMetrics")
	public MetricsVO getMetricsWithFilter() {
		return mgmtService.getHealthMetrics();
	}
}
