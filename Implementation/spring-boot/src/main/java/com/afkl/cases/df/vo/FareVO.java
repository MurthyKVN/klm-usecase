package com.afkl.cases.df.vo;

public class FareVO {
	private Double amount;
	private String currency;
	private String destination;
	private String origin;
	
	private LocationVO originLocation;
	private LocationVO destVO;
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public LocationVO getOriginLocation() {
		return originLocation;
	}
	public void setOriginLocation(LocationVO originLocation) {
		this.originLocation = originLocation;
	}
	public LocationVO getDestVO() {
		return destVO;
	}
	public void setDestVO(LocationVO destVO) {
		this.destVO = destVO;
	}
	
}
