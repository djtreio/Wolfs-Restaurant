
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.text.*;
import java.math.*;

public class EmployeeDatabase {

    private static final String ConnectionString = "jdbc:sqlite:wolfs.sql";

    public static void main(String[] args) {

        EmployeeType newEmployee = new EmployeeType();

        newEmployee.firstName = "Robert";
        newEmployee.lastName = "Wolf";
        newEmployee.role = "Admin";
        String newCredential = "regergerger";
        
        addEmployee(newEmployee, newCredential);
        
        EmployeeType[] employees = getEmployees();
        
        for(int i = 0; i < employees.length; i++) {
			System.out.println(employees[i].id + " " + employees[i].firstName + " " + employees[i].lastName + " " + employees[i].role);
		}

    }

    public static void addEmployee(EmployeeType employee, String newCredential) {
        try {
            Connection conn = databaseConnect();

            String sql = "INSERT INTO Employees (firstName, lastName, role) OUTPUT Inserted.id VALUES (?, ?, ?)";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, employee.firstName);
            statement.setString(2, employee.lastName);
            statement.setString(3, employee.lastName);

            int id = statement.executeUpdate();

            employee.id = id;

            statement.close();
            conn.close();

            CredentialDatabase.addCredential(employee, newCredential);

        } catch (Exception e) {
            System.out.println("Error in addEmployee");
            e.printStackTrace();
        }
    }

    public static EmployeeType[] getEmployees() {
        try {
            Connection conn = databaseConnect();
            Statement statement = conn.createStatement();

            String sql = "SELECT COUNT(*) FROM Employees";

            ResultSet result = statement.executeQuery(sql);

            int count = result.getInt(1);
            EmployeeType[] employees = new EmployeeType[count];

            sql = "SELECT * FROM Employees";

            result = statement.executeQuery(sql);

            int i = 0;

            while (result.next()) {

                employees[i] = new EmployeeType();
                employees[i].id = result.getInt("id");
                employees[i].firstName = result.getString("firstName");
                employees[i].lastName = result.getString("lastName");
                employees[i].role = result.getString("role");

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

    public static EmployeeType getEmployee(int id) {
        try {
            Connection conn = databaseConnect();

            String sql = "SELECT * FROM Employees WHERE id = ?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet result = statement.executeQuery(sql);

            statement.close();
            conn.close();

            EmployeeType employee = new EmployeeType();
            employee.id = id;
            employee.firstName = result.getString("firstName");
            employee.lastName = result.getString("lastName");
            employee.role = result.getString("role");

            return employee;

        } catch (Exception e) {
            System.out.println("Error in getEmployee");
            e.printStackTrace();
        }

        return null;
    }

    public static void removeEmployee(EmployeeType employee) {
        try {
            Connection conn = databaseConnect();

            String sql = "DELETE FROM Employees WHERE id = ?";

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1, employee.id);

            statement.executeUpdate();

            statement.close();
            conn.close();

            CredentialDatabase.removeCredential(employee);

        } catch (Exception e) {
            System.out.println("Error in removeEmployee");
            e.printStackTrace();
        }
    }

    public static void setEmployee(EmployeeType employee) {
        try {
            Connection conn = databaseConnect();

            String sql = "UPDATE Employees SET firstName = ?, lastName = ?, role = ? WHERE id = ?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, employee.firstName);
            statement.setString(2, employee.lastName);
            statement.setString(3, employee.role);
            statement.setInt(4, employee.id);

            statement.executeUpdate();

            statement.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Error in setEmployee");
            e.printStackTrace();
        }
    }

    public static String getCredential(EmployeeType employee) {
        String credential = CredentialDatabase.getCredential(employee);
        return credential;
    }

    public static void editCredential(EmployeeType employee, String newCredential) {
        CredentialDatabase.setCredential(employee, newCredential);
    }

    public static boolean comparePassword(EmployeeType employee, String enteredPassword) {
        String storedPassword = getCredential(employee);

        boolean result = false;
        if (storedPassword.equals(enteredPassword)) {
            result = true;
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
