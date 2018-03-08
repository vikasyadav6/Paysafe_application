package com.paysafe.golo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.paysafe.golo.model.ServerDetail;
import com.paysafe.golo.model.Statistics;

/**
 * This service will handle all the requests made by controller class.
 * 
 * @author Vikas Yadav
 *
 */

@Service
public class ApplicationService {

	// List of statistics object
	static ArrayList<Statistics> stats = new ArrayList<>();

	/**
	 * This method will save all request details sent to server.
	 * 
	 * @param serverDetail
	 */
	public void saveServerDetails(ServerDetail serverDetail) {

		// First case: when list is empty
		if (stats.isEmpty()) {
			if (serverDetail.getStatus().equalsIgnoreCase("START")) {
				Statistics stat = new Statistics();
				stat.setAction(serverDetail.getStatus());
				stat.setStartTime(serverDetail.getCreateDateTime());
				stats.add(stat);
			}
		} else {
			if (!stats.get(stats.size() - 1).getAction().equalsIgnoreCase(serverDetail.getStatus())) {
				Statistics lastStat = stats.get(stats.size() - 1);
				lastStat.setStopTime(serverDetail.getCreateDateTime());
				lastStat.setTimeElapsed(lastStat.getStopTime().getTime() - lastStat.getStartTime().getTime());
				Statistics stat = new Statistics();
				stat.setAction(serverDetail.getStatus());
				stat.setStartTime(serverDetail.getCreateDateTime());
				stats.add(stat);
			} else {
				// If same request action received consecutively, do nothing.
			}

		}

	}

	/**
	 * This method will retrieve all the statistics related to requests and provide
	 * server status.
	 * 
	 * @return
	 */

	public List<Statistics> getStatistics() {
		return stats;
	}

}
