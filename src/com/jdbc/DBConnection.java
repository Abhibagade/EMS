package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBConnection {

	public static Connection buildConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/maharashtra";
		String user="root";
		String pass="ycpcdac";
		Connection conn=DriverManager.getConnection(url, user, pass);
		return conn;
	}
	
	public static PreparedStatement getInserted() throws ClassNotFoundException, SQLException
	{
		Connection conn=buildConnection();
		System.out.println("Connected");
		
		String q="insert into Employee values(?, ?, ?)";
		PreparedStatement pstmt=conn.prepareStatement(q);
		Scanner sc=new Scanner(System.in);
		System.out.println("Employee Registration");
		System.out.println("Enter Id");
		int id=sc.nextInt();
		System.out.println("Enter Name");
		String name=sc.next();
		System.out.println("Enter location");
		String loc=sc.next();
		
		pstmt.setInt(1, id);
		pstmt.setString(2, name);
		pstmt.setString(3, loc);
	
		pstmt.executeUpdate();
		System.out.println("Data inserted");
		
		return pstmt;
	}
	
	public static PreparedStatement getUpdated() throws ClassNotFoundException, SQLException
	{
		Connection conn=DBConnection.buildConnection();
		
		String q="update employee set emp_name=?, emp_loc=? where emp_id=?";
		PreparedStatement pstmt=conn.prepareStatement(q);
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter id you want to update");
		int id=sc.nextInt();
		System.out.println("Enter new Name");
		String name=sc.next();
		System.out.println("Enter new Location");
		String loc=sc.next();
		pstmt.setString(1, name);
		pstmt.setString(2, loc);
		pstmt.setInt(3, id);
		
		pstmt.executeUpdate();
		System.out.println();
		System.out.println("Data updated");
		return pstmt;	
	}
	
	public static PreparedStatement getDeleted() throws SQLException, ClassNotFoundException
	{
		Connection conn=DBConnection.buildConnection();
		String q="delete from employee where emp_id=?";
		PreparedStatement pstmt=conn.prepareStatement(q);
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter id you want to delete");
		int id=sc.nextInt();
		pstmt.setInt(1, id);
		
		pstmt.executeUpdate();
		System.out.println("Data deleted");
		return pstmt;
	}
	
	public static void getShow() throws ClassNotFoundException, SQLException
	{
		Connection con = DBConnection.buildConnection();
		System.out.println("Connected");
		Statement stmt=con.createStatement();
		String q="Select * from Employee";
		ResultSet rs=stmt.executeQuery(q);
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
		}
	}
}
