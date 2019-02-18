package com.cp_yash.jdbcdemo.main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil 
{
	private static String url=null;
	private static String usn=null;
	private static String psw=null;
	private static String driver=null;
	private static  Connection con=null;
	
	public static Connection getconnection() throws SQLException, IOException 
	{
		Properties myprops=getProps();
		url=myprops.getProperty("dburl");
		usn=myprops.getProperty("dbunm");
		psw=myprops.getProperty("dbpwd");
		if(con==null)
		{
			con=DriverManager.getConnection(url, usn, psw);
		}
		return con;
		
	}
	public static Properties getProps() throws IOException
	{
		Properties dbprops=new Properties();
		FileReader fr=new FileReader("dbinfo.properties");
		dbprops.load(fr);
		return dbprops;
	}

}
