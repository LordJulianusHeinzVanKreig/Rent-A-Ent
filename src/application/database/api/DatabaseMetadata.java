package application.database.api;

public class DatabaseMetadata {
//	public enum Tables {
//		DuckTypes("ducktypes");
//		private String TableName;
//		private Tables(String name) {
//			this.TableName = name;
//		}
//		@Override
//		public String toString() {
//			return this.TableName;
//		}
//	}
	
	public class Tables {
		public static final String DuckTypes = "ducktype";
		public static final String Locations = "location";
		public static final String Ducks = "ducks";
	}
}
