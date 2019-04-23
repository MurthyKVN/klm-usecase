package com.afkl.cases.df.service;

import com.afkl.cases.df.vo.FareVO;
import com.afkl.cases.df.vo.LocationVO;
import com.afkl.cases.df.vo.LocationsDataVO;
import com.afkl.cases.df.vo.MetricsVO;

public interface TravelService {
	public LocationsDataVO listLocations(String searchTerm, Integer page);
	public LocationVO getByLocationCode(String code);
	public String getFare(String originCode, String destinationCode);
	public FareVO getFare2(String originCode, String destinationCode);
	public MetricsVO getHealthMetrics();
}
