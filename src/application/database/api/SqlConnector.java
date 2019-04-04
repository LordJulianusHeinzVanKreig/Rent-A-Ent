package application.database.api;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class SqlConnector {
	public static Connection Connection;
	public static String Database;
	
	public static boolean connect(String hostName, String port, String database, String user, String pass)
	{ 
		try 
		{
			Database = database;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection = (Connection) DriverManager.getConnection("jdbc:mysql://" + hostName + ":" + port + "/?user=" + user + "&password=" + pass);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			System.err.println ("Cannot connect to database.");
			return false;
		}
	}
	
	public static void disconnect()
	{
		try 
		{
			Connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println ("Database access error.");
		}
	}
}
