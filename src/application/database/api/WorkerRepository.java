package application.database.api;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import application.database.entities.Customer;
import application.database.entities.Duck;
import application.database.entities.DuckType;
import application.database.entities.Location;
import application.database.entities.Worker;

public class WorkerRepository {
	private static LinkedList<String> props = new LinkedList<String>() {
		{
			add("ID");
			add("firstName");
			add("lastName");
			add("houseNumber");
			add("zipCode");
			add("street");
			add("phoneNumber");
		}
	};

	public static List<Worker> getAllWorker() throws SQLException {
		List<Worker> dts = new LinkedList<Worker>();
		
		ResultSet results = SqlQuery.SQL_selectProperties(DatabaseMetadata.Tables.Workers, props);

		while (results.next())
			;
		dts.add(new Worker(results.getInt(1), results.getString(2), results.getString(3), results.getString(4),
				results.getInt(5), results.getString(6), results.getString(7), 0, 0));

		return dts;
	}

	public static Worker getWorkerbyID(int id) throws SQLException {

		Worker dt = null;

		ResultSet results = SqlQuery.SQL_selectByIdWithProperties(DatabaseMetadata.Tables.Workers, id, props);

		if (results.next()) {
			dt = new Worker(results.getInt(1), results.getString(2), results.getString(3), results.getString(4),
					results.getInt(5), results.getString(6), results.getString(7), 0, 0);
		}
		return dt;

	}

	public static  List<Worker> getWorkersfromLocation(Location location) throws SQLException {
		
		List<Worker> dts = new LinkedList<Worker>();
		ResultSet results = SqlQuery.SQL_selectPropertiesWhere(DatabaseMetadata.Tables.Workers, props, "locationID = " + location.getId());
		
		while(results.next())
		{
		
			dts.add(new Worker(results.getInt(1), results.getString(2), results.getString(3), results.getString(4),
					results.getInt(5), results.getString(6), results.getString(7), 0,0 ));
		}
		
		
		return dts;

	}

}
