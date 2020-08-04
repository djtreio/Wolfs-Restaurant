package CP317;


import java.sql.*;


public class CredentialDatabase {

    private static final String ConnectionString = "jdbc:sqlite:wolfs.sql";

    public static String getCredential(EmployeeType employee) {
        try {
            Connection conn = databaseConnect();

            String sql = "SELECT credential FROM Credentials WHERE employeeid = ?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, employee.id);

            ResultSet result = statement.executeQuery();
            String credential = result.getString(1);
            
            statement.close();
            conn.close();
            
            return credential;
        } catch (Exception e) {
            System.out.println("Error in getCredential");
            e.printStackTrace();
        }
        return null;
    }

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

    public static void addCredential(EmployeeType employee, String newCredential) {
        try {
            Connection conn = databaseConnect();

            String sql = "INSERT INTO Credentials (employeeid, credentials) VALUES (?, ?)";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, employee.id);
            statement.setString(2, newCredential);
            

            statement.executeUpdate();

            statement.close();
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
