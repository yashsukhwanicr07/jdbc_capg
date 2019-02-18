package com.cp_yash.jdbcdemo.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestSelectEmpDemo {

	public static void main(String[] args)  
	{
		Connection con=null;
		Statement st;
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "Capgemini123");
			st=con.createStatement();
			ResultSet rs=st.executeQuery("Select * from emp1");
			System.out.println("ID\t\t Name \t\t salary\t\t DOJ");
			while(rs.next())
			{
				System.out.println(rs.getInt(1) +"\t\t"+rs.getString(2)+"\t\t"+rs.getInt(3)+"\t\t"+rs.getDate(4));
			}
		} catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
