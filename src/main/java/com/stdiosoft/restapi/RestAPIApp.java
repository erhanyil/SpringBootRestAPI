package com.stdiosoft.restapi;

import com.stdiosoft.restapi.configuration.JpaConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


@Import(JpaConfiguration.class)
@SpringBootApplication(scanBasePackages={"com.stdiosoft.restapi"})// same as @Configuration @EnableAutoConfiguration @ComponentScan
public class RestAPIApp {

	public static void main(String[] args) {
		SpringApplication.run(RestAPIApp.class, args);
	}
}
