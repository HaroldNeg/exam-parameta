package com.project.app.exam.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Locale;

import org.springframework.stereotype.Component;

import com.project.app.exam.dto.EmployeeDto;

@Component
public class EmployeeValid {

	public boolean validNull(EmployeeDto employee) {
		if (employee.getNames() == null || employee.getSurnames() == null || employee.getBirthDate() == null
				|| employee.getDocumentType() == null || employee.getDocumentNumber() == null
				|| employee.getPositionCompany() == null || employee.getLinkingCompanyDate() == null
				|| employee.getSalary() == null) {
			return false;
		} else if (employee.getNames().isBlank() || employee.getSurnames().isBlank()
				|| employee.getBirthDate().isBlank() || employee.getDocumentType().isBlank()
				|| employee.getDocumentNumber().isBlank() || employee.getPositionCompany().isBlank()
				|| employee.getLinkingCompanyDate().isBlank()) {
			return false;
		} else {
			return true;
		}
	}

	public boolean isAdult(LocalDate birthDate) {
		long age = LocalDate.now().getYear() - birthDate.getYear();
		return age >= 18;
	}

	public boolean formatDate(String date) {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.getDefault());
		dateTimeFormatter.withResolverStyle(ResolverStyle.STRICT);
		try {
			LocalDate.parse(date, dateTimeFormatter);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
