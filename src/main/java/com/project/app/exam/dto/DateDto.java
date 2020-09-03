package com.project.app.exam.dto;

import java.io.Serializable;

public class DateDto implements Serializable{

	private static final long serialVersionUID = 1L;

	public DateDto() {
	}

	private long year;
	
	private long month;
	
	private long day;

	public long getYear() {
		return year;
	}

	public void setYear(long year) {
		this.year = year;
	}

	public long getMonth() {
		return month;
	}

	public void setMonth(long month) {
		this.month = month;
	}

	public long getDay() {
		return day;
	}

	public void setDay(long day) {
		this.day = day;
	}

	@Override
	public String toString() {
		return "Date [year=" + year + ", month=" + month + ", day=" + day + "]";
	}
}
