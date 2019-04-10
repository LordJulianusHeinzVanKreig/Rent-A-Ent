 package application.database.api;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import application.database.entities.Customer;
import application.database.entities.Duck;
import application.database.entities.DuckType;
import application.database.entities.Location;

public class DuckRepository {
	private static LinkedList<String> props = new LinkedList<String>() {
		{			
			add("ID");
			add("age");
			add("name");
			add("description");
			add("temperament");
			add("gender");
			add("ducktypeID");
			add("locationID");
			add("customerID");
		}
	};
	
	public static List<Duck> getAllDucks() throws SQLException {
		List<Duck> dts = new LinkedList<Duck>();
		
		ResultSet results = SqlQuery.SQL_selectProperties(DatabaseMetadata.Tables.Ducks, props);
		
		while(results.next())
		{
			DuckType dt = DuckTypeRepository.getDuckTypeById(results.getInt(7));
			dts.add(new Duck(results.getInt(1), results.getInt(2), results.getString(3), results.getString(4), results.getInt(5), results.getBoolean(6), dt));
		}
		
		return dts;
	}
	
	public static List<Duck> getAllDucksFromLocation(Location location) throws SQLException {
		List<Duck> dts = new LinkedList<Duck>();
		
		ResultSet results = SqlQuery.SQL_selectPropertiesWhere(DatabaseMetadata.Tables.Ducks, props, "locationID = " + location.getId());
		
		while(results.next())
		{
			DuckType dt = DuckTypeRepository.getDuckTypeById(results.getInt(7));
			dts.add(new Duck(results.getInt(1), results.getInt(2), results.getString(3), results.getString(4), results.getInt(5), results.getBoolean(6), dt));
		}
		
		return dts;
	}
	
	public static List<Duck> getAllDucksFromCustomer(Customer customer) throws SQLException {
		List<Duck> dts = new LinkedList<Duck>();
		
		ResultSet results = SqlQuery.SQL_selectPropertiesWhere(DatabaseMetadata.Tables.Ducks, props, "customerID = " + customer.getId());
		
		while(results.next()) {
			DuckType dt = DuckTypeRepository.getDuckTypeById(results.getInt(7));
			dts.add(new Duck(results.getInt(1), results.getInt(2), results.getString(3), results.getString(4), results.getInt(5), results.getBoolean(6), dt));
		}
		
		return dts;
	}
	
	public static Duck getDuckById(int id) throws SQLException {
		Duck duck = null;
		
		ResultSet results = SqlQuery.SQL_selectByIdWithProperties(DatabaseMetadata.Tables.Ducks, id, props);

		if(results.next()) {
			DuckType dt = DuckTypeRepository.getDuckTypeById(results.getInt(7));
			duck = new Duck(results.getInt(1), results.getInt(2), results.getString(3), results.getString(4), results.getInt(5), results.getBoolean(6), dt);
		}
		
		return duck;
	}
	
	public static void addDuck(Duck duck, Location location) {
		LinkedList<String> data = new LinkedList<String>();
		data.add("NULL");
		data.add("'" + Integer.toString(duck.getAge()) + "'");
		data.add("'" + duck.getName() + "'");
		data.add("'" + duck.getDescription() + "'");
		data.add("'" + Integer.toString(duck.getTemperament()) + "'");
		data.add(Boolean.toString(duck.isGender()));
		data.add("'" + Integer.toString(duck.getType().getId()) + "'");
		data.add("'" + Integer.toString(location.getId()) + "'");
		data.add("NULL");
		
		SqlQuery.SQL_insertProperties(DatabaseMetadata.Tables.Ducks, props, data);
	}
}
