package com.project.app.exam.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.app.exam.service.IEmployeeRegisterService;

@Path("/employeeRegister")
public class EmployeeRegisterController{
	
	@Autowired
	public IEmployeeRegisterService service;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response EmployeeRegister(String json) {
		return service.register(json);
	}

}
