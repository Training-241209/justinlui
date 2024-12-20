package com.reimbursementsystem.employeereimbursementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import static org.springframework.boot.SpringApplication.run;
@SpringBootApplication
public class EmployeereimbursementsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeereimbursementsystemApplication.class, args);
	}

}
