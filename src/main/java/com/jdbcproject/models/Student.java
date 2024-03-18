package com.jdbcproject.models;

public class Student {
	
	
	
//	     create table students (
//			id int primary key, 
//			firstName varchar(30),
//			lastName varchar(30),
//			phoneNumber int(10),
//			email varchar(40) unique not null,
//			cityname varchar(50)
//			);
	private int id;
	private String firstName;
	private String lastName;
	private int phoneNumber;
	private String email;
	private String cityname;
	
	
	public Student() {
		
	}
    public Student(int id,String firstName, String lastName,int phoneNumber, String email,String cityname) {
	
    	this.id = id;
    	this.firstName= firstName;
    	this.lastName = lastName;
    	this.phoneNumber = phoneNumber;
    	this.email = email;
    	this.cityname= cityname;
	}
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber="
				+ phoneNumber + ", email=" + email + ", cityname=" + cityname + "]";
	}
	

    
    
}
