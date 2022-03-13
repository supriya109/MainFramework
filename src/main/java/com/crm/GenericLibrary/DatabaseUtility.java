package com.crm.GenericLibrary; 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	
	Connection con=null;

	public void connectToDb() throws SQLException
	{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection(IPathConstants.DbUrl,IPathConstants.DbUsername,IPathConstants.Dbpassword);
	}
	
	public void closeDB() throws SQLException {
		con.close();
		}
public String executeQueryAndgetData(String query,int coulmnIndex,String expData) throws Throwable
{
	String data=null;
	
	boolean flag = false;
	ResultSet result = con.createStatement().executeQuery(query);
	while(result.next())
	{
		data=result.getString(coulmnIndex);
		if(data.equalsIgnoreCase(expData))
		{
			flag=true;//flag rising
			break;
		}
			
		}
	if(flag)
	{
		System.out.println(data+"--->data verified");
		return expData;
	}
	else
	{
		System.out.println("data not verified");
		return "";
	}

	}
}