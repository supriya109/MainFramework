package com.practice;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCQueryUpdate {
@Test
public void sampleupdate()
{
	Driver driverRef=new Driver();
	DriverManager.registerDriver(driverRef);
	
	 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
	
	Statement stat = con.createStatement();
	
	int result = stat.executeUpdate("insert into students values('Adarsh',11,'japan')");
	
	if(result==1)
	{
		System.out.println("data added succesfully");
	}
	else
	{
		System.out.println("data not added");
	}

	
	finally
	{
		//step:close the database
		Connection con;
		con.close();
		System.out.println("connection closed");
	}
	}

}
