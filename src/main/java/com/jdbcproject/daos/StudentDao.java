package com.jdbcproject.daos;

import java.util.List;

import com.jdbcproject.models.Student;



public interface StudentDao {
	
	public Boolean insertStudent(Student student);
	
	public List<Student> getAllstudents();
	
	public Boolean updateStudent(Student updatedStudent, int id);
	
	public Boolean deleteStudent(int id);

}
