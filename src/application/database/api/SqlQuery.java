package application.database.api;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlQuery {
	public static ResultSet SQL_selectAll(String tabelle)
	{
		ResultSet rs = null;
		
		try 
		{
			
			String abfrage = "SELECT * FROM " + SqlConnector.Database + "." + tabelle + ";";
			rs = SqlConnector.Connection.createStatement().executeQuery(abfrage);
			
		}
		catch (SQLException ex) 
		{
			Logger.getLogger(SqlQuery.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return rs;
	}
	
	public static ResultSet SQL_selectById(String tabelle, int id) {
		ResultSet rs = null;
		
		try 
		{
			
			String abfrage = "SELECT * FROM " + SqlConnector.Database + "." + tabelle + " where ID = " + id + ";";
			rs = SqlConnector.Connection.createStatement().executeQuery(abfrage);
			
		}
		catch (SQLException ex) 
		{
			Logger.getLogger(SqlQuery.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return rs;		
	}
	
	public static ResultSet SQL_selectByIdWithProperties(String tabelle, int id, List<String> properties) {
		ResultSet rs = null;
		
		try 
		{		
			
			String abfrage = "SELECT " + buildPropertiesString(properties) + " FROM " + SqlConnector.Database + "." + tabelle + " where ID = " + id + ";";
			rs = SqlConnector.Connection.createStatement().executeQuery(abfrage);
			
		}
		catch (SQLException ex) 
		{
			Logger.getLogger(SqlQuery.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return rs;		
	}
	
	public static ResultSet SQL_selectProperties(String tabelle, List<String> properties)
	{
		ResultSet rs = null;
		
		try 
		{
			
			String abfrage = "SELECT " + buildPropertiesString(properties) + " FROM " + SqlConnector.Database + "." + tabelle + ";";
			rs = SqlConnector.Connection.createStatement().executeQuery(abfrage);
			
		}
		catch (SQLException ex) 
		{
			Logger.getLogger(SqlQuery.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return rs;
	}
	
	private static String buildPropertiesString(List<String> properties) {
		String props = "";
		for (int i = 0; i < properties.size() - 1; i++) {
			props += properties.get(i) + ", ";
		}
		props += properties.get(properties.size()-1);
		return props;
	}
}
