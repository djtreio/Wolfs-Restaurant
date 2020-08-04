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

        EmployeeType newEmployee = new EmployeeType();

        newEmployee.name = "Robert Wolf";
        newEmployee.role = "Admin";
        newEmployee.email = "RWolf@wolfs.ca";
        newEmployee.phone = "905-844-2323";
        String newCredential = "regergerger";
        
        addEmployee(newEmployee, newCredential);
        
        EmployeeType[] employees = getEmployees();
        
        for(int i = 0; i < employees.length; i++) {
			System.out.println(employees[i].id + " " + employees[i].name + " " + employees[i].position + " " + employees[i].role);
		}

    }

    public static void addEmployee(EmployeeType employee, String newCredential) {
        try {
            Connection conn = databaseConnect();

            String sql = "INSERT INTO Employees (name, role, email, position, phone) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, employee.name);
            statement.setString(2, employee.role);
            statement.setString(3, employee.email);
            statement.setString(4, employee.position);
            statement.setString(5, employee.phone);

            statement.executeUpdate();

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

    public static EmployeeType getEmployee(int id) {
        try {
            Connection conn = databaseConnect();

            String sql = "SELECT * FROM Employees WHERE id = ?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet result = statement.executeQuery();


            EmployeeType employee = new EmployeeType();
            employee.id = id;
            employee.name = result.getString("name");
            employee.position = result.getString("position");
            employee.role = result.getString("role");
            employee.email = result.getString("email");
            employee.phone = result.getString("phone");

            statement.close();
            conn.close();
            
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

    public static String getCredential(EmployeeType employee) {
        String credential = CredentialDatabase.getCredential(employee);
        return credential;
    }

    public static void editCredential(EmployeeType employee, String newCredential) {
    	if (credentials == "-1") {
    		CredentialDatabase.addCredential(employee, newCredential);
    	}
    	else {
    		CredentialDatabase.setCredential(employee, newCredential);
    	}
        
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
