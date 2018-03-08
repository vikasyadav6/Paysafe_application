package com.paysafe.golo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author Vikas Yadav
 *
 */
@SpringBootApplication
public class MonitorConfiguration {

	public static void main(String[] args) {
		SpringApplication.run(MonitorConfiguration.class, args);
	}

}
