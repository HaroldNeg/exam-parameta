package com.project.app.exam;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.project.app.exam.controller.EmployeeRegisterController;

@Component
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(EmployeeRegisterController.class);
	}
		
}
