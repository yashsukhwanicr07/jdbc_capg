import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util 
{
	static String username=null;
	static String password=null;
	static String url=null;
	String driver=null;
	static Connection conn=null;
	public static Connection getConnection() throws SQLException
	{
		Properties myproperties=getProperties();
		url=myproperties.getProperty("dburl");
		username=myproperties.getProperty("dbunm");
		password=myproperties.getProperty("dbpsw");
		if(conn==null)
		{
			conn=DriverManager.getConnection(url, username, password);
		}
		return conn;
	}
	public static Properties getProperties()
	{
		Properties dbproperties=new Properties();
		try 
		{
			FileReader fr=new FileReader("dbinfo.properties");
			dbproperties.load(fr);
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dbproperties;
	}
	
	

}
