package com.revature.ProjectOneBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("com.revature.models")//Databases
@ComponentScan("com.revature")//Beans
public class ProjectOneBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectOneBackendApplication.class, args);
		System.out.println("Project One Up and Running");
	}

}
