package com.bank.bootcointransaction.msbootcointransaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsBootcointransactionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsBootcointransactionApplication.class, args);
	}

}
