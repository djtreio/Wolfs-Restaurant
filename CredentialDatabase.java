package CP317;

import java.sql.*;

public class CredentialDatabase {

	private static final String ConnectionString = "jdbc:sqlite:wolfs.sql";

	/**
	 * Gets the credentials for the given EmployeeType
	 * @param employee
	 * @return
	 */
	public static String getCredential(EmployeeType employee) {

		try {

			Connection conn = databaseConnect();
			
			Statement statement = conn.createStatement();

			String sql = "SELECT credential FROM Credentials WHERE employeeid = " + employee.id;

			ResultSet result = statement.executeQuery(sql);

			String credential = null;
			
			if (result.next()) {
				
				credential = result.getString("credential");
			
			}
			
			statement.close();

			conn.close();

			return credential;

		} catch (Exception e) {

			System.out.println("Error in getCredential");

			e.printStackTrace();

		}

		return null;

	}

	/**
	 * Removes the credentials for the given EmployeeType
	 * @param employee
	 */
	public static void removeCredential(EmployeeType employee) {

		try {

			Connection conn = databaseConnect();

			String sql = "DELETE FROM Credentials WHERE employeeid = ?";

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, employee.id);

			statement.executeUpdate();

			statement.close();

			conn.close();

		} catch (Exception e) {

			System.out.println("Error in removeCredential");

			e.printStackTrace();

		}

	}

	/**
	 * Changes the credentials for the given EmployeeType to be newCredential
	 * @param employee
	 * @param newCredential
	 */
	public static void setCredential(EmployeeType employee, String newCredential) {

		try {

			Connection conn = databaseConnect();

			String sql = "UPDATE Credentials SET credential = ? WHERE employeeid = ?";

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, newCredential);

			statement.setInt(2, employee.id);

			statement.executeUpdate();

			statement.close();

			conn.close();

		} catch (Exception e) {

			System.out.println("Error in editCredential");

			e.printStackTrace();

		}

	}

	/**
	 * Creates a new credential for the given EmployeeType with value newCredential
	 * @param employee
	 * @param newCredential
	 */
	public static void addCredential(EmployeeType employee, String newCredential) {

		try {

			Connection conn = databaseConnect();

			Statement uniqueCheckStatement = conn.createStatement();

			String sql = "SELECT * FROM Credentials WHERE employeeid = " + employee.id;

			ResultSet result = uniqueCheckStatement.executeQuery(sql);

			if (!result.next()) {

				sql = "INSERT INTO Credentials (employeeid, credential) VALUES (?, ?)";

				PreparedStatement statement = conn.prepareStatement(sql);

				statement.setInt(1, employee.id);

				statement.setString(2, newCredential);

				statement.executeUpdate();

				statement.close();
			}

			uniqueCheckStatement.close();
			conn.close();

		} catch (Exception e) {

			System.out.println("Error in addCredential");

			e.printStackTrace();

		}

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