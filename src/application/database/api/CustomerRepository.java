package application.database.api;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import application.database.entities.Customer;
import application.database.entities.DuckType;

public class CustomerRepository {
	public static List<Customer> getAllCustomer() throws SQLException {
		List<Customer> dts = new LinkedList<Customer>();
		List<String> props = new LinkedList<String>();

		props.add("ID");
		props.add("firstName");
		props.add("lastName");
		props.add("houseNumber");
		props.add("zipCode");
		props.add("street");
		props.add("phoneNumber");

		ResultSet results = SqlQuery.SQL_selectProperties(DatabaseMetadata.Tables.Customers, props);

		while (results.next()) {
			dts.add(new Customer(results.getInt(1), results.getString(2), results.getString(3), results.getString(4),
					results.getInt(5), results.getString(6), results.getString(7), 1));
		}

		return dts;
	}

	public static Customer getCustomerbyID(int id) throws SQLException {

		List<String> props = new LinkedList<String>();
		props.add("ID");
		props.add("firstName");
		props.add("lastName");
		props.add("houseNumber");
		props.add("zipCode");
		props.add("street");
		props.add("phoneNumber");

		Customer dt = null;

		ResultSet results = SqlQuery.SQL_selectByIdWithProperties(DatabaseMetadata.Tables.Customers, id, props);

		if (results.next()) {
			dt = new Customer(results.getInt(1), results.getString(2), results.getString(3), results.getString(4),
					results.getInt(5), results.getString(6), results.getString(7), 1);
		}

		return dt;
	}
}
