package com.xyz.ecommercedao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.xyz.bean.User;
/* This java class is used to perform Data Access Operation */
public class EcommerceDAO {
	Connection con;
	PreparedStatement pre;
	Statement stat;
	ResultSet res;
	
	public EcommerceDAO()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
			System.out.println("Database Connected....");
			//pre.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public int registerUser(User u)
	{
		System.out.println("In Register");
		int ra=0;
		try
		{
			pre=con.prepareStatement("insert into users1 values(?,?,?)");
			pre.setString(1, u.getLoginId());
			pre.setString(2,u.getPassword());
			pre.setString(3, u.getEmail());
			ra=pre.executeUpdate();
			pre.close();
			
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ra;
	}
	
	public boolean validateUser(String lid,String pswd){
		System.out.println("In Validate");
		boolean isAuthorized = false;
		try
		{
			pre=con.prepareStatement("select * from users1 where loginid = ? and password = ?" );
			pre.setString(1,lid);
			pre.setString(2,pswd);
			res=pre.executeQuery();
			while(res.next()){
					isAuthorized = true;
				}
			pre.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return isAuthorized;
	}

	
	public ResultSet retrieveProducts()

	{
		System.out.println("Retrieving All Product");
		try
		{
			System.out.println("try block");
			pre=con.prepareStatement("select * from products" );
			res=pre.executeQuery();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return res;
	}
	public ResultSet retrieve(String pname)
	{
		System.out.println("Retrieving"+pname);
		try
		{
			pre=con.prepareStatement("select * from products where name= ?" );
			pre.setString(1,pname);
			res=pre.executeQuery();
			System.out.println("Result Retrieved...");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return res;
	}

}
