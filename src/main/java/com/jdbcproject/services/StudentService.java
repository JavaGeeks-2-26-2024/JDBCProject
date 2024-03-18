package com.jdbcproject.services;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import com.jdbcproject.daos.StudentDaoImpl;
import com.jdbcproject.models.Student;

public class StudentService {
	
	StudentDaoImpl studentDao=null;
	
	
	public StudentService(Connection con) {
		
		studentDao = new StudentDaoImpl(con);
	}
	
	
	public void createStudent() {
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter id:");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("enter firstName:");
		String firstName = sc.nextLine();
		System.out.println("enter lastName:");
		String lastName = sc.nextLine();
		System.out.println("enter phoneNumber:");
		int phoneNumber = sc.nextInt();
		sc.nextLine();
		System.out.println("enter email:");
		String email = sc.nextLine();
		System.out.println("enter cityname:");
		String cityname = sc.nextLine();
		
		Student student = new Student(id, firstName, lastName, phoneNumber, email, cityname);
		
		boolean status = false;
		
		
		status = this.studentDao.insertStudent(student);
		
		
		if(status) {
			System.out.println("student has been added successfully");
		}else {
			System.out.println("please check your code or connection");
		}
	
	}
	
	
	public void getAllstudents() {
		
		List<Student> studentsList =this.studentDao.getAllstudents();
		
		for(int i=0; i<studentsList.size();i++) {
			System.out.println("Student "+ i);
			System.out.println(studentsList.get(i));
		}
		
	}
	
	
	public void updateStudent() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter which id need to be updated:");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("enter firstName:");
		String firstName = sc.nextLine();
		System.out.println("enter lastName:");
		String lastName = sc.nextLine();
		System.out.println("enter phoneNumber:");
		int phoneNumber = sc.nextInt();
		sc.nextLine();
		System.out.println("enter email:");
		String email = sc.nextLine();
		System.out.println("enter cityname:");
		String cityname = sc.nextLine();
		
		Student updatedStudent = new Student(id, firstName, lastName, phoneNumber, email, cityname);
		
		boolean status = this.studentDao.updateStudent(updatedStudent, id);
		if(status) {
			System.out.println("student has been updated successfully");
		}else {
			System.out.println("please check your code or connection");
		}
		
	}
	
	public void deleteStudent() {
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter which id need to delete:");
		int id = sc.nextInt();
		sc.nextLine();
	boolean status = this.studentDao.deleteStudent(id);
		
		if(status) {
			System.out.println("student has been deleted successfully");
		}else {
			System.out.println("please check your code or connection");
		}
		
	}
	

}
