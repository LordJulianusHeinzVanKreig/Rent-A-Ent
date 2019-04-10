package application.database.api;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlQuery {
	public static ResultSet SQL_selectAll(String tabelle) {
		ResultSet rs = null;

		try {

			String abfrage = "SELECT * FROM " + SqlConnector.Database + "." + tabelle + ";";
			rs = SqlConnector.Connection.createStatement().executeQuery(abfrage);

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return rs;
	}

	public static ResultSet SQL_selectById(String tabelle, int id) {
		ResultSet rs = null;

		try {

			String abfrage = "SELECT * FROM " + SqlConnector.Database + "." + tabelle + " where ID = " + id + ";";
			rs = SqlConnector.Connection.createStatement().executeQuery(abfrage);

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return rs;
	}

	public static ResultSet SQL_selectByIdWithProperties(String tabelle, int id, List<String> properties) {
		ResultSet rs = null;

		try {

			String abfrage = "SELECT " + buildPropertiesString(properties) + " FROM " + SqlConnector.Database + "."
					+ tabelle + " where ID = " + id + ";";
			rs = SqlConnector.Connection.createStatement().executeQuery(abfrage);

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return rs;
	}

	public static ResultSet SQL_selectProperties(String tabelle, List<String> properties) {
		ResultSet rs = null;

		try {

			String abfrage = "SELECT " + buildPropertiesString(properties) + " FROM " + SqlConnector.Database + "."
					+ tabelle + ";";
			rs = SqlConnector.Connection.createStatement().executeQuery(abfrage);

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return rs;
	}

	public static ResultSet SQL_selectPropertiesWhere(String tabelle, List<String> properties, String whereCondition) {
		ResultSet rs = null;

		try {

			String abfrage = "SELECT " + buildPropertiesString(properties) + " FROM " + SqlConnector.Database + "."
					+ tabelle + " where " + whereCondition + ";";
			rs = SqlConnector.Connection.createStatement().executeQuery(abfrage);

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return rs;
	}

	public static ResultSet SQL_insertProperties(String tabelle, List<String> properties, List<String> data) {
		ResultSet rs = null;

		try {
			String abfrage = "INSERT INTO " + SqlConnector.Database + "." + tabelle + " ("
					+ buildPropertiesString(properties) + ") VALUES (" + buildDataString(data) + ");";
			SqlConnector.Connection.createStatement().execute(abfrage);
			// rs = SqlConnector.Connection.createStatement().executeQuery(abfrage);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return rs;
	}

	private static String buildPropertiesString(List<String> properties) {
		String props = "";
		for (int i = 0; i < properties.size() - 1; i++) {
			props += properties.get(i) + ", ";
		}
		props += properties.get(properties.size() - 1);
		return props;
	}

	public static boolean SQL_DeletebyID(String tabelle, int id) {
		boolean rs;
		String abfrage = "DELETE FROM " + SqlConnector.Database + "." + tabelle + " WHERE ID = "  + id
				+ "" + ";";
		try {
			rs = SqlConnector.Connection.createStatement().execute(abfrage);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

	private static String buildDataString(List<String> data) {
		String dataString = "";
		for (int i = 0; i < data.size() - 1; i++) {
			dataString += data.get(i) + ", ";
		}
		dataString += data.get(data.size() - 1);
		return dataString;
	}
}
