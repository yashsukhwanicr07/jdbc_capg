package com.cp_yash.jdbcdemo.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestTransactionDemo 
{ 

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Connection con=null;
		try 
		{
			 con=DBUtil.getconnection();
			con.setAutoCommit(false);
			String update1="Update emp1 SET emp_name='yashu' where emp_id=112";
			String update2="UPDATE emp1 set emp_sal=20000 where emp_id=112";
			Statement st=con.createStatement();
			st.addBatch(update1);
			st.addBatch(update2);
			int[] arr=st.executeBatch();
			con.commit();
			System.out.println("updated successfully");
		} catch (SQLException | IOException e) 
		{
			// TODO Auto-generated catch block
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}

}
