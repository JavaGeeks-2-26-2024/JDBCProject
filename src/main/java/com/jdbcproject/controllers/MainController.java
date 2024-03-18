package com.jdbcproject.controllers;

import java.sql.Connection;
import java.util.Scanner;


import com.jdbcproject.services.StudentService;
import com.jdbcproject.util.SQLConnection;

public class MainController {

	public static void main(String[] args) {

		Connection con = SQLConnection.createConnection();

		StudentService studentService = new StudentService(con);

		Scanner sc = new Scanner(System.in);
		System.out.println("-------------******-----Welcome to our Binary School-------******--------------");

		int option = 0;
        boolean stop = false;
		
         while(!stop) {
        		System.out.println("1. create student");
        		System.out.println("2. get all student");
        		System.out.println("3. update student");
        		System.out.println("4. delete student");
        		System.out.println("5. Exit");
        	option = sc.nextInt();
        	sc.nextLine();
     		switch (option) {
     		case 1:
     			studentService.createStudent(sc);
     			break;
     		case 2:
                 studentService.getAllstudents();
     			break;
     		case 3:
                  studentService.updateStudent(sc);
     			break;
     		case 4:
     			studentService.deleteStudent(sc);
     			break;
     		case 5:
     			stop = true;
     			System.out.println("Exit done");
     			sc.close();
     			break;
     		}
         }

		SQLConnection.closeConnection(con);

	}

}
