package application.database.api;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import application.database.entities.Location;

public class LocationRepository {
	
	private static LinkedList<String> props = new LinkedList<String>() {
		{			
			add("ID");
			add("breedTime");
			add("region");
			add("maxAge");
		}
	};
	
	public static List<Location> getAllLocations() throws SQLException {
		List<Location> locations = new LinkedList<Location>();

		ResultSet results = SqlQuery.SQL_selectProperties(DatabaseMetadata.Tables.Locations, props);
		
		while(results.next())
		{
			locations.add(new Location(results.getInt(1), results.getString(2), results.getInt(3), results.getString(4)));
		}
		
		return locations;
	}
	
	public static Location getLocationById(int id) throws SQLException {
		Location dt = null;
		
		ResultSet results = SqlQuery.SQL_selectByIdWithProperties(DatabaseMetadata.Tables.DuckTypes, id, props);

		if(results.next()) {
			dt = new Location(results.getInt(1), results.getString(2), results.getInt(3), results.getString(4));
		}
		
		return dt;
	}
}
