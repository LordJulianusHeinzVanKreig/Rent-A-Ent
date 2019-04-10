package application.database.api;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import application.database.entities.Duck;
import application.database.entities.DuckType;

public class DuckTypeRepository {
	
	private static LinkedList<String> props = new LinkedList<String>() {
		{			
			add("ID");
			add("Name");
			add("breedTime");
			add("region");
			add("maxAge");
		}
	};
	
	public static List<DuckType> getAllDuckTypes() throws SQLException {
		List<DuckType> dts = new LinkedList<DuckType>();
		
		ResultSet results = SqlQuery.SQL_selectProperties(DatabaseMetadata.Tables.DuckTypes, props);
		
		while(results.next())
		{
			dts.add(new DuckType(results.getInt(1), results.getString(2), results.getInt(3), results.getString(4), results.getInt(5)));
		}
		
		return dts;
	}
	
	public static DuckType getDuckTypeById(int id) throws SQLException {
		DuckType dt = null;
		
		ResultSet results = SqlQuery.SQL_selectByIdWithProperties(DatabaseMetadata.Tables.DuckTypes, id, props);

		if(results.next()) {
			dt = new DuckType(results.getInt(1), results.getString(2), results.getInt(3), results.getString(4), results.getInt(5));
		}
		
		return dt;
	}
	
	public static void addDuckType(DuckType duckType) {
		LinkedList<String> data = new LinkedList<String>();
		data.add("NULL");
		data.add("'" + duckType.getName() + "'");
		data.add("'" + duckType.getBreedTime() + "'");
		data.add("'" + duckType.getRegion() + "'");
		data.add("'" + duckType.getMaxAge() + "'");
		
		SqlQuery.SQL_insertProperties(DatabaseMetadata.Tables.DuckTypes, props, data);
	}
	
	public static void deleteDuckTypebyId(DuckType ducktype) {
		SqlQuery.SQL_DeletebyID(DatabaseMetadata.Tables.DuckTypes, ducktype.getId());
	}
}
