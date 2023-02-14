package com.citiustech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MicroPatientModuleApplication {

	public static void main(String[] args) {
		System.out.println("patient module");
		SpringApplication.run(MicroPatientModuleApplication.class, args);
	}
	
	@Bean
	public RestTemplate rt()
	{
		RestTemplate rt=new RestTemplate();
		return rt;
	}

}
