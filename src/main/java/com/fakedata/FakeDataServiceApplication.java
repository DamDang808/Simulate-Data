package com.fakedata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FakeDataServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FakeDataServiceApplication.class, args);
	}

}
