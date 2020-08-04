import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TablesDatabase {
	private static final String ConnectionString = "jdbc:sqlite:/Users/deepi/Desktop/wolf.db";

	public static void main(String[] args) {

	}

	public static void addTables(TablesInfo tables) {
		try {

			Connection conn = databaseConnect();

			String sql = "REPLACE INTO Tables (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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

	public static TablesInfo[] getTables() {
		try {

			Connection conn = databaseConnect();
			Statement statement = conn.createStatement();

			String sql = "SELECT COUNT(*) FROM Tables";
			ResultSet result = statement.executeQuery(sql);
			int count = result.getInt(1);

			TablesInfo[] tables;
			tables = new TablesInfo[count];

			sql = "SELECT * FROM Tables";

			result = statement.executeQuery(sql);

			int i = 0;
			while (result.next()) {
				tables[i] = new TablesInfo();
				tables[i].T1 = result.getInt("T1");
				tables[i].T2 = result.getInt("T2");
				tables[i].T3 = result.getInt("T3");
				tables[i].T4 = result.getInt("T4");
				tables[i].T5 = result.getInt("T5");
				tables[i].T6 = result.getInt("T6");
				tables[i].T7 = result.getInt("T7");
				tables[i].T8 = result.getInt("T8");
				tables[i].T9 = result.getInt("T9");
				tables[i].T10 = result.getInt("T10");
				tables[i].T11 = result.getInt("T11");
				tables[i].T12 = result.getInt("T12");

				i++;
			}

			statement.close();
			conn.close();

			return tables;
		} catch (Exception e) {
			System.out.println("Error in getBooking");
			e.printStackTrace();
		}

		return null;
	}

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
