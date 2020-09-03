package com.project.app.exam.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;

public class EmployeeDto implements Serializable {

	private static final long serialVersionUID = 1L;

	public EmployeeDto() {
	}

	private String names;

	private String surnames;

	private String documentType;

	private String documentNumber;

	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
	private String BirthDate;

	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
	private String linkingCompanyDate;

	private String positionCompany;

	private Double salary;

	private DateDto age;

	private DateDto timeLinkingCompanyDate;

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

	public String getBirthDate() {
		return BirthDate;
	}

	public void setBirthDate(String birthDate) {
		BirthDate = birthDate;
	}

	public String getLinkingCompanyDate() {
		return linkingCompanyDate;
	}

	public void setLinkingCompanyDate(String linkingCompanyDate) {
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

	public DateDto getAge() {
		return age;
	}

	public void setAge(DateDto age) {
		this.age = age;
	}

	public DateDto getTimeLinkingCompanyDate() {
		return timeLinkingCompanyDate;
	}

	public void setTimeLinkingCompanyDate(DateDto timeLinkingCompanyDate) {
		this.timeLinkingCompanyDate = timeLinkingCompanyDate;
	}

	@Override
	public String toString() {
		return "EmployeeDto [names=" + names + ", surnames=" + surnames + ", documentType=" + documentType
				+ ", documentNumber=" + documentNumber + ", BirthDate=" + BirthDate + ", linkingCompanyDate="
				+ linkingCompanyDate + ", positionCompany=" + positionCompany + ", salary=" + salary + ", age=" + age
				+ ", timeLinkingCompanyDate=" + timeLinkingCompanyDate + "]";
	}



}
