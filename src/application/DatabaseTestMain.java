package application;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.database.api.DuckTypeRepository;
import application.database.api.SqlConnector;
import application.database.api.SqlQuery;
import application.database.entities.DuckType;

public class DatabaseTestMain {
	public static void main(String[] args) {
		System.out.println("lel");
		SqlConnector.connect("localhost", "3306", "rentaent", "admin", "heinzketchup");
//		ArrayList<String[]> ergs = SqlQuery.SQL_selectAll("ducktype");
//		
//		for (String[] strings : ergs) {
//			for (int i = 0; i < strings.length; i++) {
//				System.out.print(strings[i] + "    ");
//			}
//			System.out.println();
//		}
		try {
			List<DuckType> ds = DuckTypeRepository.getAllDuckTypes();
			
			for (DuckType duckType : ds) {
				System.out.println(duckType.getId());
			}
		} catch (SQLException e) {
		}
		
	}
}
