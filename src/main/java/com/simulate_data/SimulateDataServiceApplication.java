package com.simulate_data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SimulateDataServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimulateDataServiceApplication.class, args);
	}

}
