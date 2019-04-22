package com.afkl.cases.df.vo;

public class MetricsVO {
	
	private int maxTime;
	private int minTime;
	private int totalCount;
	private int statusOKCount;
	private int status4XXCount;
	private int status5XXCount;
	
	public int getMaxTime() {
		return maxTime;
	}
	public void setMaxTime(int maxTime) {
		this.maxTime = maxTime;
	}
	public int getMinTime() {
		return minTime;
	}
	public void setMinTime(int minTime) {
		this.minTime = minTime;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getStatusOKCount() {
		return statusOKCount;
	}
	public void setStatusOKCount(int statusOKCount) {
		this.statusOKCount = statusOKCount;
	}
	public int getStatus4XXCount() {
		return status4XXCount;
	}
	public void setStatus4XXCount(int status4xxCount) {
		status4XXCount = status4xxCount;
	}
	public int getStatus5XXCount() {
		return status5XXCount;
	}
	public void setStatus5XXCount(int status5xxCount) {
		status5XXCount = status5xxCount;
	}
	
}
