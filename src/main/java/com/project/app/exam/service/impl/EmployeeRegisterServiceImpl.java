package com.project.app.exam.service.impl;

import java.time.LocalDate;
import java.time.Period;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.project.app.exam.consumingwebservice.EmployeeClient;
import com.project.app.exam.dto.EmployeeDto;
import com.project.app.exam.dto.ErrorDto;
import com.project.app.exam.mapper.EmployeeMapper;
import com.project.app.exam.mapper.EmployeeValid;
import com.project.app.exam.model.EmployeeModel;
import com.project.app.exam.service.IEmployeeRegisterService;

@Service
public class EmployeeRegisterServiceImpl implements IEmployeeRegisterService{
	
	@Autowired
	private EmployeeValid valid;
	
	@Autowired
	private EmployeeMapper mapper;
	
	@Autowired
	private EmployeeClient client;

	@Override
	public Response register(String json) {
		//Convert json to model employee
		EmployeeDto employeeDto = new Gson().fromJson(json, EmployeeDto.class);
		EmployeeModel employeeModel = null;
		//validation data no blank
		if (valid.validNull(employeeDto) && valid.formatDate(employeeDto.getBirthDate()) && valid.formatDate(employeeDto.getLinkingCompanyDate())) {
			employeeModel = mapper.mapperDto(employeeDto);
			if (valid.isAdult(employeeModel.getBirthDate())) {
				try {
					//call service SOAP
					String response = client.saveEmployeeResponse(mapper.mapperXml(employeeModel));
					if (response.equals("Se ha guardado exitosamente")) {
						employeeDto.setAge(mapper.mapperDateDto(obtainPeriod(employeeModel.getBirthDate())));
						employeeDto.setTimeLinkingCompanyDate(mapper.mapperDateDto(obtainPeriod(employeeModel.getLinkingCompanyDate())));
						return Response.status(200).entity(employeeDto).build();
					} else {
						ErrorDto error = new ErrorDto("Ocurrió un error en el SOAP", response);
						return Response.status(500).entity(new Gson().toJson(error)).build();
					}
				} catch (Exception e) {
					ErrorDto error = new ErrorDto("Ocurrió un error en el servidor", e.toString());
					return Response.status(500).entity(new Gson().toJson(error)).build();
				}
			} else {
				ErrorDto error = new ErrorDto("El empleado debe ser mayor de edad", "BirthDate "+employeeDto.getBirthDate());
				json = "message: El empleado debe ser mayor de edad";
				return Response.status(400).entity(new Gson().toJson(error)).build();
			}
		} else {
			ErrorDto error = new ErrorDto("No pueden haber parámetros vacíos, las fechas tienen que tener el formato 'yyyy-MM-dd' y ser válidas", employeeDto.toString());
			return Response.status(400).entity(new Gson().toJson(error)).build();
		}
		
	}
	
	private Period obtainPeriod(LocalDate date) {
		LocalDate now = LocalDate.now();
		return Period.between(date, now);
	}

}
