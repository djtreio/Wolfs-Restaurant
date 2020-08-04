package CP317;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Class for storing table states
class TablesInfo {
	public int T1;
	public int T2;
	public int T3;
	public int T4;
	public int T5;
	public int T6;
	public int T7;
	public int T8;
	public int T9;
	public int T10;
	public int T11;
	public int T12;
}

public class TablesDatabase {
	//database used for tables
	private static final String ConnectionString = "jdbc:sqlite:wolfs.sql";
	
	//main testing function
	public static void main(String[] args) {
		//Set all tables to ready
		TablesInfo tables = new TablesInfo();
		tables.T1 = 0;
		tables.T2 = 0;
		tables.T3 = 0;
		tables.T4 = 0;
		tables.T5 = 0;
		tables.T6 = 0;
		tables.T7 = 0;
		tables.T8 = 0;
		tables.T9 = 0;
		tables.T10 = 0;
		tables.T11 = 0;
		tables.T12 = 0;
		
		//add table states to db
		addTables(tables);
	}
	
	/**
	 * add current table states to database
	 * @param tables - TablesInfo with properties to set to database
	 */
	public static void addTables(TablesInfo tables) {
		try {
			//db connection
			Connection conn = databaseConnect();
			
			//SQL update table update code
			String sql = "UPDATE Tables SET T1 = ?, T2 = ?, T3 = ?, T4 = ?, T5 = ?, T6 = ?, T7 = ?, T8 = ?, T9 = ?, T10 = ?, T11 = ?, T12 = ? WHERE id = 0";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, tables.T1);
			statement.setInt(2, tables.T2);
			statement.setInt(3, tables.T3);
			statement.setInt(4, tables.T4);
			statement.setInt(5, tables.T5);
			statement.setInt(6, tables.T6);
			statement.setInt(7, tables.T7);
			statement.setInt(8, tables.T8);
			statement.setInt(9, tables.T9);
			statement.setInt(10, tables.T10);
			statement.setInt(11, tables.T11);
			statement.setInt(12, tables.T12);

			statement.executeUpdate();

			statement.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("Error in addTables");
			e.printStackTrace();
		}
	}
	
	/**
	 * get all table states from database
	 * takes results from SQL statement and stores in TablesInfo list
	 */
	public static TablesInfo getTables() {
		try {

			Connection conn = databaseConnect();
			Statement statement = conn.createStatement();

			TablesInfo tables = new TablesInfo();
			
			//SQL code selecting all current states from Tables db
			String sql = "SELECT * FROM Tables";

			ResultSet result = statement.executeQuery(sql);

			tables.T1 = result.getInt("T1");
			tables.T2 = result.getInt("T2");
			tables.T3 = result.getInt("T3");
			tables.T4 = result.getInt("T4");
			tables.T5 = result.getInt("T5");
			tables.T6 = result.getInt("T6");
			tables.T7 = result.getInt("T7");
			tables.T8 = result.getInt("T8");
			tables.T9 = result.getInt("T9");
			tables.T10 = result.getInt("T10");
			tables.T11 = result.getInt("T11");
			tables.T12 = result.getInt("T12");


			statement.close();
			conn.close();

			return tables;
		} catch (Exception e) {
			System.out.println("Error in getBooking");
			e.printStackTrace();
		}

		return null;
	}
	
	/**
	 * connect to database and return the connection object for the database
	 */
	public static Connection databaseConnect() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection(ConnectionString);

			if (conn != null) {
				return conn;
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

}
