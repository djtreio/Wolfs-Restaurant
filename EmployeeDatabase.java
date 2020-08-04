package CP317;

import java.sql.*;

class EmployeeType {

	public int id;

	public String name;

	public String role;

	public String email;

	public String position;

	public String phone;

}

public class EmployeeDatabase {

	public static int empid;

	public static EmployeeType employee;

	public static String role;

	public static String credentials;

	private static final String ConnectionString = "jdbc:sqlite:wolfs.sql";

	public static void main(String[] args) {

		// Test addEmployee()
		
		EmployeeType newEmployee = new EmployeeType();

		newEmployee.name = "Robert Wolf";

		newEmployee.role = "Admin";

		newEmployee.email = "RWolf@wolfs.ca";

		newEmployee.phone = "905-844-2323";
		
		newEmployee.position = "Owner";

		String newCredential = "regergerger";

		addEmployee(newEmployee, newCredential);

		
		
		EmployeeType newEmployee2 = new EmployeeType();

		newEmployee2.name = "Helena Wolf";

		newEmployee2.role = "Waiter";

		newEmployee2.email = "HelenaWolf@wolfs.ca";
		
		newEmployee2.position = "Head";

		newEmployee2.phone = "416-784-7643";

		String newCredential2 = "passpass";

		addEmployee(newEmployee2, newCredential2);
		
		
		
		EmployeeType newEmployee3 = new EmployeeType();

		newEmployee3.name = "Something Wolf";

		newEmployee3.role = "Cook";

		newEmployee3.email = "SWolf@wolfs.ca";
		
		newEmployee3.position = "Manager";

		newEmployee3.phone = "979-798-4679";

		String newCredential3 = "somethingwolfpass";

		addEmployee(newEmployee3, newCredential3);
		
		
		
		EmployeeType[] employees = getEmployees();

		for (int i = 0; i < employees.length; i++) {

			System.out.println(
					employees[i].id + " " + employees[i].name + " " + employees[i].role + " " + employees[i].email + " " + employees[i].position + " " + employees[i].phone);

		}
		
		// Test getEmployee()
		
		EmployeeType employee = getEmployee(23);
		
		EmployeeType nonExistentEmployee = getEmployee(10000124);
		
		System.out.println(
				employee.id + " " + employee.name + " " + employee.role + " " + employee.email + " " + employee.position + " " + employee.phone);
		
		System.out.println(
				nonExistentEmployee.id + " " + nonExistentEmployee.name + " " + nonExistentEmployee.role + " " + nonExistentEmployee.email + " " + nonExistentEmployee.position + " " + nonExistentEmployee.phone);

		// Test removeEmployee
		
		employee = getEmployee(1);
		
		removeEmployee(employee);
		
		removeEmployee(nonExistentEmployee);
		
		// Test setEmployee
		
		employee = getEmployee(64);
		
		employee.name = "New Name";
		
		employee.position = "Janitor";
		
		setEmployee(employee);
		
		employee = getEmployee(64);
		
		System.out.println(
				employee.id + " " + employee.name + " " + employee.role + " " + employee.email + " " + employee.position + " " + employee.phone);
		
		// Test editCredential()
		
		System.out.println(getCredential(employee));
		
		String newPassword = "newpassword";
		
		editCredential(employee, newPassword);
		
		editCredential(nonExistentEmployee, newPassword);
		
		System.out.println(getCredential(employee));
		
		System.out.println(getCredential(nonExistentEmployee));
		
		// Test comparePassword()
		
		String inputtedPassword = "newpassword";
		
		System.out.println(comparePassword(employee, inputtedPassword));
		
		editCredential(employee, "incorrectPassword");
		
		System.out.println(comparePassword(employee, inputtedPassword));
		
		System.out.println(comparePassword(nonExistentEmployee, inputtedPassword));

	}

	/**
	 * Add the given employee to the Employees database. Also adds the given newCredentials to the Credentials database with reference to the given employee.
	 * @param employee
	 * @param newCredential
	 */
	public static void addEmployee(EmployeeType employee, String newCredential) {

		try {

			Connection conn = databaseConnect();

			// Insert the employee into the Employees database
			
			String sql = "INSERT INTO Employees (name, role, email, position, phone) VALUES (?, ?, ?, ?, ?)";

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, employee.name);

			statement.setString(2, employee.role);

			statement.setString(3, employee.email);

			statement.setString(4, employee.position);

			statement.setString(5, employee.phone);

			statement.executeUpdate();
			
			// Get the id of the newly inserted employee and set the id to the auto-generated value

			Statement getIDStatement = conn.createStatement();

			sql = "SELECT id FROM Employees ORDER BY id DESC LIMIT 1";

			ResultSet result = getIDStatement.executeQuery(sql);

			employee.id = result.getInt("id");

			getIDStatement.close();

			statement.close();

			conn.close();

			// Insert newCredential into the Credentials database
			
			CredentialDatabase.addCredential(employee, newCredential);

		} catch (Exception e) {

			System.out.println("Error in addEmployee");

			e.printStackTrace();

		}

	}

	/**
	 * Returns an array of all EmployeeTypes in the Employees database
	 * @return
	 */
	public static EmployeeType[] getEmployees() {

		try {

			Connection conn = databaseConnect();

			// Get results from the Employee database
			
			Statement statement = conn.createStatement();

			String sql = "SELECT COUNT(*) FROM Employees";

			ResultSet result = statement.executeQuery(sql);

			int count = result.getInt(1);

			EmployeeType[] employees = new EmployeeType[count];

			sql = "SELECT * FROM Employees";

			result = statement.executeQuery(sql);

			// Create an array of employeeTypes from result
			
			int i = 0;

			while (result.next()) {

				employees[i] = new EmployeeType();

				employees[i].id = result.getInt("id");

				employees[i].name = result.getString("name");

				employees[i].position = result.getString("position");

				employees[i].role = result.getString("role");

				employees[i].email = result.getString("email");

				employees[i].phone = result.getString("phone");

				i++;

			}

			statement.close();

			conn.close();

			return employees;

		} catch (Exception e) {

			System.out.println("Error in getEmployees");

			e.printStackTrace();

		}

		return null;

	}

	/**
	 * Returns the EmployeeType from the Employees database for the corresponding id provided
	 * @param id
	 * @return
	 */
	public static EmployeeType getEmployee(int id) {

		try {

			Connection conn = databaseConnect();
			
			Statement statement = conn.createStatement();

			String sql = "SELECT * FROM Employees WHERE id = " + id;

			ResultSet result = statement.executeQuery(sql);

			EmployeeType employee = new EmployeeType();

			employee.id = id;

			if (result.next()) {
				
				employee.name = result.getString("name");
	
				employee.position = result.getString("position");
	
				employee.role = result.getString("role");
	
				employee.email = result.getString("email");
	
				employee.phone = result.getString("phone");
				
			} else {
				
				employee.name = null;
				
				employee.position = null;
	
				employee.role = null;
	
				employee.email = null;
	
				employee.phone = null;
			
			}
			
			statement.close();

			conn.close();

			return employee;

		} catch (Exception e) {

			System.out.println("Error in getEmployee");

			e.printStackTrace();

		}

		return null;

	}

	/**
	 * Removes the given EmployeeType from the Employees database
	 * @param employee
	 */
	public static void removeEmployee(EmployeeType employee) {

		try {

			Connection conn = databaseConnect();

			// Delete employee from the Employees database
			
			String sql = "DELETE FROM Employees WHERE id = ?";

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, employee.id);

			statement.executeUpdate();

			statement.close();

			conn.close();
			
			// Remove the credentials for the newly deleted employee

			CredentialDatabase.removeCredential(employee);

		} catch (Exception e) {

			System.out.println("Error in removeEmployee");

			e.printStackTrace();

		}

	}

	/**
	 * Updates the EmployeeType at the employee's id with the given EmployeeTypes data
	 * @param employee
	 */
	public static void setEmployee(EmployeeType employee) {

		try {

			Connection conn = databaseConnect();

			String sql = "UPDATE Employees SET name = ?, position = ?, role = ?, email = ?, phone = ? WHERE id = ?";

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, employee.name);

			statement.setString(2, employee.position);

			statement.setString(3, employee.role);

			statement.setString(4, employee.email);

			statement.setString(5, employee.phone);

			statement.setInt(6, employee.id);

			statement.executeUpdate();

			statement.close();

			conn.close();

		} catch (Exception e) {

			System.out.println("Error in setEmployee");

			e.printStackTrace();

		}

	}

	/**
	 * Gets the credentials corresponding to the given EmployeeType
	 * @param employee
	 * @return
	 */
	public static String getCredential(EmployeeType employee) {

		String credential = CredentialDatabase.getCredential(employee);

		return credential;

	}

	/**
	 * Changes the credentials for the given EmployeeTpye to newCredentials
	 * @param employee
	 * @param newCredential
	 */
	public static void editCredential(EmployeeType employee, String newCredential) {

		if (credentials == "-1") {

			CredentialDatabase.addCredential(employee, newCredential);

		}

		else {

			CredentialDatabase.setCredential(employee, newCredential);

		}

	}

	/**
	 * Compares the credentials for the given EmployeeType and enteredPassword. Returns true if they match, false if they don't
	 * @param employee
	 * @param enteredPassword
	 * @return
	 */
	public static boolean comparePassword(EmployeeType employee, String enteredPassword) {

		String storedPassword = getCredential(employee);

		boolean result = false;

		if (storedPassword != null) {
			
			if (storedPassword.equals(enteredPassword)) {
	
				result = true;
	
			}
			
		}

		return result;

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