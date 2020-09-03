package com.project.app.exam;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.project.app.exam.consumingwebservice.EmployeeClient;

@Configuration
public class EmployeeConfig {

	@Bean
	public Jaxb2Marshaller marshaller() {
	    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
	    // this package must match the package in the <generatePackage> specified in
	    // pom.xml
	    marshaller.setContextPath("com.project.app.exam.consumingwebservice.wsdl");
	    return marshaller;
	  }

	  @Bean
	  public EmployeeClient employeeClient(Jaxb2Marshaller marshaller) {
		  EmployeeClient client = new EmployeeClient();
	    client.setDefaultUri("http://localhost:8080/ws");
	    client.setMarshaller(marshaller);
	    client.setUnmarshaller(marshaller);
	    return client;
	  }
}
