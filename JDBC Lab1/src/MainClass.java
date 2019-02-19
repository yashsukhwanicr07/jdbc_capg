import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class MainClass 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Connection conn=null;
		try 
		{
			conn=Util.getConnection();
			String create1="CREATE TABLE yash(num1_value NUMBER(10))";
			String create2="CREATE TABLE shivam(num2_value NUMBER(10))";
			String delete="DELETE FROM yash where num1_value IN(SELECT num2_value from shivam)";
			Statement st=conn.createStatement();
			//st.execute(create1);
			//st.execute(create2);
			//System.out.println("tables created");
			int data=st.executeUpdate(delete);
			System.out.println("Data Deleted");
			
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
