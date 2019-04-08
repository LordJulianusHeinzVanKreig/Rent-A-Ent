package application.database.api;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import application.database.entities.Worker;

public class WorkerRepository {
	private static LinkedList<String> props = new LinkedList<String>() {
		{
		props.add("ID");
		props.add("firstName");
		props.add("lastName");
		props.add("houseNumber");
		props.add("zipCode");
		props.add("street");
		props.add("phoneNumber");
	}
	};
	public static List<Worker> getAllDuckTypes() throws SQLException {
		List<Worker> dts = new LinkedList<Worker>();
		List<String> props = new LinkedList<String>();

																										
		ResultSet results = SqlQuery.SQL_selectAll(DatabaseMetadata.Tables.Workers);

		while (results.next());
			dts.add(new Worker(results.getInt(1), results.getString(2), results.getString(3), results.getString(4), results.getInt(5), results.getString(6), results.getString(7), results.getInt(8), results.getInt(9)));
		

		return dts;
	}

}
