package com.project.app.exam.mapper;

import java.time.LocalDate;
import java.time.Period;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.stereotype.Component;

import com.project.app.exam.consumingwebservice.wsdl.Employee;
import com.project.app.exam.dto.DateDto;
import com.project.app.exam.dto.EmployeeDto;
import com.project.app.exam.model.EmployeeModel;

@Component
public class EmployeeMapper {

	public EmployeeModel mapperDto(EmployeeDto employeeDto) {
		EmployeeModel employee = new EmployeeModel();
		employee.setNames(employeeDto.getNames());
		employee.setSurnames(employeeDto.getSurnames());
		employee.setDocumentType(employeeDto.getDocumentType());
		employee.setDocumentNumber(employeeDto.getDocumentNumber());
		employee.setBirthDate(LocalDate.parse(employeeDto.getBirthDate()));
		employee.setLinkingCompanyDate(LocalDate.parse(employeeDto.getLinkingCompanyDate()));
		employee.setPositionCompany(employeeDto.getPositionCompany());
		employee.setSalary(employeeDto.getSalary());
		return employee;
	}
	
	public DateDto mapperDateDto (Period period) {
		DateDto dateDto = new DateDto();
		dateDto.setYear(period.getYears());
		dateDto.setMonth(period.getMonths());
		dateDto.setDay(period.getDays());
		return dateDto;
	}
	
	public Employee mapperXml(EmployeeModel employeeModel) {
		Employee employee = new Employee();
		employee.setNames(employeeModel.getNames());
		employee.setSurnames(employeeModel.getSurnames());
		employee.setDocumentType(employeeModel.getDocumentType());
		employee.setDocumentNumber(employeeModel.getDocumentNumber());
		employee.setBirthDate(transformLocalDate(employeeModel.getBirthDate().toString()));
		employee.setLinkingCompanyDate(transformLocalDate(employeeModel.getBirthDate().toString()));
		employee.setPositionCompany(employeeModel.getPositionCompany());
		employee.setSalary(employeeModel.getSalary());
		return employee;
	}
	
	private XMLGregorianCalendar transformLocalDate(String localdate) {
		XMLGregorianCalendar xmlGregorianCalendar = null;
		try {
			xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(localdate);
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		return xmlGregorianCalendar;
	}
}
