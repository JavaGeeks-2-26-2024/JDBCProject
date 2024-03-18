package com.jdbcproject.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jdbcproject.models.Student;

public class StudentDaoImpl implements StudentDao {
        Connection connection = null;
	
	
        
        public StudentDaoImpl( Connection connection) {
        	this.connection = connection;
        }
	
	@Override
	public Boolean insertStudent(Student student) {
//		System.out.println("this is from StudentDaoImpl");
//		System.out.println(student);
		boolean status = false;
		try {
			String sql = "insert into students(id, firstName, lastName, phoneNumber, email,cityname) values(?,?,?,?,?,?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, student.getId());
			preparedStatement.setString(2, student.getFirstName());
			preparedStatement.setString(3, student.getLastName());
			preparedStatement.setInt(4, student.getPhoneNumber());
			preparedStatement.setString(5, student.getEmail());
			preparedStatement.setString(6, student.getCityname());
			
			int returndata = preparedStatement.executeUpdate();
			
			if(returndata > 0) {
				status = true;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		return status;
	}

	@Override
	public List<Student> getAllstudents() {
		
		
		List<Student> styList = new ArrayList<Student>();
		try {
			String sql = "select * from students";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
	
			
			ResultSet  result = preparedStatement.executeQuery(sql);
			
			
			while(result.next()) {
				Student s = new Student();
				s.setId(result.getInt(1));
				s.setFirstName(result.getString(2));
				s.setLastName(result.getString(3));
				s.setPhoneNumber(result.getInt(4));
				s.setEmail(result.getString(5));
				s.setCityname(result.getString(6));
				styList.add(s);
				
			}
		      
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		return styList;
	}

	@Override
	public Boolean updateStudent(Student updatedStudent, int id) {
		boolean status = false;
		try {
			String sql = "update students set firstName=?, lastName=?, phoneNumber=?,email=?, cityname=? where id = ?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, updatedStudent.getFirstName());
			preparedStatement.setString(2, updatedStudent.getLastName());
			preparedStatement.setInt(3, updatedStudent.getPhoneNumber());
			preparedStatement.setString(4, updatedStudent.getEmail());
			preparedStatement.setString(5, updatedStudent.getCityname());
			preparedStatement.setInt(6, id);
			int returndata = preparedStatement.executeUpdate();
			
			if(returndata > 0) {
				status = true;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Boolean deleteStudent(int id) {
		
		boolean status = false;
		try {
			String sql = "delete from students where id = ?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			int returndata = preparedStatement.executeUpdate();
			
			if(returndata > 0) {
				status = true;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return status;
	}

}
