package com.jdbc;

import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeManagementSystem {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("********************************");
		System.out.println("*Employee* *Management* *System*");
		System.out.println("********************************");
		int k;
		do {
			System.out.println("Welcome to Employee Register Console App");
			System.out.println("Enter 1 for Inserting Employee Data");
			System.out.println("Enter 2 for Update Employee Data");
			System.out.println("Enter 3 for Delete Employee Data");
			System.out.println("Enter 4 for Display Data");
			System.out.println("Enter your choice");
			int choice=sc.nextInt();
			
			switch (choice) {
			case 1 :
				try {
					DBConnection.getInserted();
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				break;
			case 2 :
				try {
					DBConnection.getUpdated();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
			case 3:
				try {
					DBConnection.getDeleted();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 4:
				try {
					DBConnection.getShow();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			System.out.println("Enter 0 for Continue, Press any another key for exit");
			k=sc.nextInt();
		}while(k==0);
		
		System.out.println("Thank you Visit Again...");
	}
}
