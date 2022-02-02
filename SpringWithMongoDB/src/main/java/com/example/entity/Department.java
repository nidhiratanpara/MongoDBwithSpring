package com.example.entity;

import org.springframework.data.mongodb.core.mapping.Field;

public class Department {
	
	@Field(name = "deptment_name")
	private String DepartmentName;
	
	private String location;

	public String getDepartmentName() {
		return DepartmentName;
	}

	public void setDepartmentName(String departmentName) {
		DepartmentName = departmentName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
