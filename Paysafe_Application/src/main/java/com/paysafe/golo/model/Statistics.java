package com.paysafe.golo.model;

import java.util.Date;

public class Statistics {
	
	 private String action;
	
	 private Date startTime;
	 
	 private Date stopTime;
	 
	 private Long timeElapsed;

	public void setTimeElapsed(Long timeElapsed){
		this.timeElapsed = timeElapsed;
	}
	
	public Long getTimeElapsed() {
		return timeElapsed;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getStopTime() {
		return stopTime;
	}

	public void setStopTime(Date stopTime) {
		this.stopTime = stopTime;
	}

}
