package com.paysafe.golo.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author Vikas Yadav
 *
 *         This class corresponds with request object sent to server.
 */

public class RequestDetail {

	@NotNull
	private String serverUrl;

	@NotNull
	private Long timeInterval;

	@NotNull
	private String action;

	public String getServerUrl() {
		return serverUrl;
	}

	public void setServerUrl(String serverUrl) {
		this.serverUrl = serverUrl;
	}

	public Long getTimeInterval() {
		return timeInterval;
	}

	public void setTimeInterval(Long timeInterval) {
		this.timeInterval = timeInterval;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

}
