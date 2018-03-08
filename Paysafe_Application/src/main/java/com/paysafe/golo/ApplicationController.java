package com.paysafe.golo;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.paysafe.golo.converter.ServerDetailConverter;
import com.paysafe.golo.model.RequestDetail;
import com.paysafe.golo.model.Statistics;

/**
 * 
 * @author Vikas Yadav
 * 
 *         This controller class contains rest methods to communicate with
 *         golo_app_server
 *
 */

@RestController
@RequestMapping("/golo")
public class ApplicationController {

	@Autowired
	ApplicationService applicationService;

	/**
	 * Rest End point to start and stop the monitoring application
	 * 
	 * @param requestDetail
	 * @return
	 */

	@RequestMapping(path = "monitor", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public RequestDetail sendRequest(@Valid @NotNull @RequestBody final RequestDetail requestDetail) {
		if (requestDetail.getAction().equalsIgnoreCase("START") || requestDetail.getAction().equalsIgnoreCase("STOP")) {
			applicationService.saveServerDetails((new ServerDetailConverter()).convert(requestDetail));
			return requestDetail;
		} else {
			throw new InvalidActionException(requestDetail.getAction());
		}
	}

	/**
	 * Rest End point to retrieves application statistics
	 * 
	 * @return
	 */

	@RequestMapping(path = "statistics")
	public List<String> getStatisticss() {
		List<String> results = new ArrayList<>();
		
		List<Statistics> stats = applicationService.getStatistics();
		if(stats.isEmpty()) {
			results.add("No request has been sent to server");
		}else {
			for(Statistics stat: stats) {
				if(stat.getStopTime()!= null) {
					results.add("Application was in "+stat.getAction()+" mode for total time :"+stat.getTimeElapsed()+" from "+stat.getStartTime());
				}else
				results.add("Application is in "+stat.getAction() +" mode. Started at :" + stat.getStartTime());
				}
			}
			
		return results;	
		}

		
		
		
	}

