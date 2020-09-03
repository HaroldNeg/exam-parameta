package com.project.app.exam.model;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class EmployeeModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String names;
	
	private String surnames;
	
	private String documentType;
	
	private String documentNumber;
	
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
	private LocalDate BirthDate;
	
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
	private LocalDate linkingCompanyDate;
	
	private String positionCompany;
	
	private Double salary;
	
	public String getNames() {
		return names;
	}
	public void setNames(String names) {
		this.names = names;
	}
	public String getSurnames() {
		return surnames;
	}
	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}
	public String getDocumentType() {
		return documentType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	public String getDocumentNumber() {
		return documentNumber;
	}
	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}
	public LocalDate getBirthDate() {
		return BirthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		BirthDate = birthDate;
	}
	public LocalDate getLinkingCompanyDate() {
		return linkingCompanyDate;
	}
	public void setLinkingCompanyDate(LocalDate linkingCompanyDate) {
		this.linkingCompanyDate = linkingCompanyDate;
	}
	public String getPositionCompany() {
		return positionCompany;
	}
	public void setPositionCompany(String positionCompany) {
		this.positionCompany = positionCompany;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [names=" + names + ", surnames=" + surnames + ", documentType=" + documentType
				+ ", documentNumber=" + documentNumber + ", BirthDate=" + BirthDate + ", linkingCompanyDate="
				+ linkingCompanyDate + ", positionCompany=" + positionCompany + ", salary=" + salary + "]";
	}
	
}
