package com.project.app.exam.service;

import javax.ws.rs.core.Response;

public interface IEmployeeRegisterService {

	public abstract Response register(String json);
}
