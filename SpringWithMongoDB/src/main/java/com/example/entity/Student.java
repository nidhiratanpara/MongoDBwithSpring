package com.example.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "student" )
public class Student {
	
	@Id
	private String id;
	
	private String name;
	
	private String email;
	
	@Field(name = "deparment")
	private Department departemnt;
	
	private List<Subject> subjects;
	
	// if you want to create Department & Subjects as separate collection you can do it with this annotation you need to create Department as collection class. 
	// @DBRef
	// private Department departemnt;
	
	@Transient
	private double percentage;
	
	public Student(String id, String name, String email, Department departemnt, List<Subject> subjects) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.departemnt = departemnt;
		this.subjects = subjects;
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Department getDepartemnt() {
		return departemnt;
	}
	public void setDepartemnt(Department departemnt) {
		this.departemnt = departemnt;
	}
	public List<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	public double getPercentage() {
		if(subjects != null && subjects.size()>0)
		{
			int total=0;
			for (Subject subject : subjects) {
				total+=subject.getMarksObtained();
			}
			return total/subjects.size();
		}
		return 0.00;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	
	

}
