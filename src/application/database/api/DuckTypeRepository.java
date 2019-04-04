package application.database.api;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import application.database.entities.DuckType;

public class DuckTypeRepository {
	
	public static List<DuckType> getAllDuckTypes() throws SQLException {
		List<DuckType> dts = new LinkedList<DuckType>();
		ResultSet results = SqlQuery.SQL_selectAll(DatabaseMetadata.Tables.DuckTypes);
		
		while(results.next())
		{
			dts.add(new DuckType(results.getInt(4), results.getDate(1), results.getString(2), results.getInt(3)));
		}
		
		return dts;
	}
	
	public static DuckType getDuckTypeById(int id) throws SQLException {
		DuckType dt = null;
		
		ResultSet results = SqlQuery.SQL_selectAll(DatabaseMetadata.Tables.DuckTypes);

		if(results.next()) {
			dt = new DuckType(results.getInt(4), results.getDate(1), results.getString(2), results.getInt(3));
		}
		
		return dt;
	}
}
