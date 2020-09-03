package com.project.app.exam.consumingwebservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.project.app.exam.consumingwebservice.wsdl.Employee;
import com.project.app.exam.consumingwebservice.wsdl.SaveEmployeeRequest;
import com.project.app.exam.consumingwebservice.wsdl.SaveEmployeeResponse;

public class EmployeeClient extends WebServiceGatewaySupport {

	@Value("${config.endpoint}")
	private String endpoint;

	public String saveEmployeeResponse(Employee employee) throws Exception{
		SaveEmployeeRequest request = new SaveEmployeeRequest();
		request.setEmployee(employee);
		SaveEmployeeResponse response = (SaveEmployeeResponse) getWebServiceTemplate()
				.marshalSendAndReceive(endpoint+"/ws/employee", request,
			            new SoapActionCallback("http://negreteharold.com/exam/parameta/GetCountryRequest"));
		return response.getResponse();
	}

}
