package com.paysafe.golo.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.paysafe.golo.model.RequestDetail;
import com.paysafe.golo.model.ServerDetail;

import java.util.Calendar;

/**
 * 
 * @author Vikas Yadav
 * 
 *         This class contains convert method for request object.
 *
 */

@Component
public class ServerDetailConverter implements Converter<RequestDetail, ServerDetail> {

	@Override
	public ServerDetail convert(RequestDetail requestDetail) {
		ServerDetail serverDetail = new ServerDetail();
		serverDetail.setCreateDateTime(Calendar.getInstance().getTime());
		serverDetail.setServerUrl(requestDetail.getServerUrl());
		serverDetail.setInterval(requestDetail.getTimeInterval());
		serverDetail.setStatus(requestDetail.getAction());
		return serverDetail;
	}
}