package application.database.api;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
}
