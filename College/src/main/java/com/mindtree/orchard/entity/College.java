package com.mindtree.orchard.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class College 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer collegeid;
	private String collegeName;
	private int totalStudents;
	
	public College(int collegeid, String collegeName, int totalStudents)
	{
		super();
		this.collegeid = collegeid;
		this.collegeName = collegeName;
		this.totalStudents = totalStudents;
	}
	public College()
	{
		super();
	}
	public Integer getCollegeid() {
		return collegeid;
	}
	public void setCollegeid(Integer collegeid) {
		this.collegeid = collegeid;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public Integer getTotalStudents() {
		return totalStudents;
	}
	public void setTotalStudents(Integer totalStudents) {
		this.totalStudents = totalStudents;
	}
	
}
