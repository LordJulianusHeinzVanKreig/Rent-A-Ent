package application.database.api;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import application.database.entities.Duck;
import application.database.entities.Location;
import application.database.entities.Worker;

public class LocationRepository {

	private static LinkedList<String> props = new LinkedList<String>() {
		{
			add("ID");
			add("street");
			add("zipCode");
			add("houseNumber");
			add("LeaderID");
		}
	};

	public static List<Location> getAllLocations() throws SQLException {
		List<Location> locations = new LinkedList<Location>();

		ResultSet results = SqlQuery.SQL_selectProperties(DatabaseMetadata.Tables.Locations, props);

		while (results.next()) {
			Worker leader = WorkerRepository.getWorkerbyID(results.getInt(5));
			locations.add(new Location(results.getInt(1), results.getString(2), results.getInt(3), results.getString(4),
					leader));
		}

		return locations;
	}

	public static Location getLocationById(int id) throws SQLException {
		Location dt = null;

		ResultSet results = SqlQuery.SQL_selectByIdWithProperties(DatabaseMetadata.Tables.Locations, id, props);

		if (results.next()) {
			Worker leader = WorkerRepository.getWorkerbyID(results.getInt(5));
			dt = new Location(results.getInt(1), results.getString(2), results.getInt(3), results.getString(4), leader);
		}

		return dt;
	}
	
	public static void addLocation(Location location) {
		LinkedList<String> data = new LinkedList<String>();
		data.add("NULL");
		data.add("'" + location.getStreet() + "'");
		data.add("'" + location.getZipCode() + "'");
		data.add("'" + location.getHouseNumber() + "'");
		data.add("NULL");
		
		SqlQuery.SQL_insertProperties(DatabaseMetadata.Tables.Locations, props, data);
	}
	
	public static void deleteLocation(Location location) {
		SqlQuery.SQL_DeletebyID(DatabaseMetadata.Tables.Locations, location.getId());
	}
}
