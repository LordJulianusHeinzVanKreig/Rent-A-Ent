
package application.database.api;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import application.database.entities.Customer;
import application.database.entities.DuckType;

public class CustomerRepository {
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

	
	
	public static List<Customer> getAllCustomer() throws SQLException {
		List<Customer> dts = new LinkedList<Customer>();
		

		ResultSet results = SqlQuery.SQL_selectProperties(DatabaseMetadata.Tables.Customers, props);

		while (results.next()) {
			dts.add(new Customer(results.getInt(1), results.getString(2), results.getString(3), results.getString(4),
					results.getInt(5), results.getString(6), results.getString(7), 1));
		}

		return dts;
	}

	public static Customer getCustomerbyID(int id) throws SQLException {
		Customer dt = null;

		ResultSet results = SqlQuery.SQL_selectByIdWithProperties(DatabaseMetadata.Tables.Customers, id, props);

		if (results.next()) {
			dt = new Customer(results.getInt(1), results.getString(2), results.getString(3), results.getString(4),
					results.getInt(5), results.getString(6), results.getString(7), 1);
		}

		return dt;
	}

	public static void addCustomer(Customer customer) {
		LinkedList<String> data = new LinkedList<String>();
		data.add("NULL");
		data.add("'" + customer.getFirstName() + "'");
		data.add("'" + customer.getLastName() + "'");
		data.add("'" + customer.getHouseNumber() + "'");
		data.add("'" + Integer.toString(customer.getZipCode()) + "'");
		data.add("'" + customer.getStreet() + "'");
		data.add("'" + customer.getPhoneNumber() + "'");
		
		SqlQuery.SQL_insertProperties(DatabaseMetadata.Tables.Customers, props, data);
	}
	
	public static void deleteCustomer(Customer customer) {
		SqlQuery.SQL_DeletebyID(DatabaseMetadata.Tables.Customers, customer.getId());
	}
}
