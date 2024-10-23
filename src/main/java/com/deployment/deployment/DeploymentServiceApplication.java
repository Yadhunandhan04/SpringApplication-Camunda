package com.deployment.deployment;

import io.camunda.zeebe.spring.client.annotation.Deployment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Deployment(resources = "classpath:newDiagram.bpmn")
public class DeploymentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeploymentServiceApplication.class, args);
	}
}

