package com.cp_yash.jdbcdemo.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TestInsertDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter employee id");
		int eid=scanner.nextInt();
		//System.out.println("Enter employee name");
		//scanner.nextLine();
		//String enm=scanner.nextLine();
		//System.out.println("Enter Salary");
		//int empsal=scanner.nextInt();
		try 
		{
			Connection con=DBUtil.getconnection();
			//String insert="INSERT INTO emp1  (emp_id,emp_name,emp_sal) VALUES(?,?,?)";
			String insert="INSERT INTO emp1 where emp_id=?";
			String update="UPDATE emp1 SET emp_sal=? WHERE emp_id=?";
			String delete="DELETE FROM emp1 where emp_id=?";
			PreparedStatement pst=con.prepareStatement(delete);
			pst.setInt(1,eid);
			//pst.setInt(2, empsal);
			int data=pst.executeUpdate();
			System.out.println("DATA IS deleted");
		}
		catch (SQLException | IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
