package application.database.api;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import application.database.entities.Duck;
import application.database.entities.DuckType;

public class DuckTypeRepository {
	
	private static LinkedList<String> props = new LinkedList<String>() {
		{			
			add("ID");
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
			dts.add(new DuckType(results.getInt(1), results.getDate(2), results.getString(3), results.getInt(4)));
		}
		
		return dts;
	}
	
	public static DuckType getDuckTypeById(int id) throws SQLException {
		DuckType dt = null;
		
		ResultSet results = SqlQuery.SQL_selectByIdWithProperties(DatabaseMetadata.Tables.DuckTypes, id, props);

		if(results.next()) {
			dt = new DuckType(results.getInt(1), results.getDate(2), results.getString(3), results.getInt(4));
		}
		
		return dt;
	}
	public static void deleteDuckTypebyId(DuckType ducktype) {
		SqlQuery.SQL_DeletebyID(DatabaseMetadata.Tables.DuckTypes, ducktype.getId());
	}
}
