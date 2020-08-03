import java.sql.*;
import java.util.*;
import java.util.Date;
import java.time.LocalTime;
import java.text.*;
import java.math.*;


public class ReservationsDatabase {
	private static final String ConnectionString = "jdbc:sqlite:/Users/deepi/Desktop/wolf.db";
	//Bookings test
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookingInfo booking = new BookingInfo();
		Random generator = new Random();
		
		booking.time= new Time((long)generator.nextInt(24*60*60*1000));
		booking.name = "Name "+ (Math.round((Math.random() * 50 + 10)*100.0)/100.0);
		booking.size = (int)(Math.round((Math.random() * 20)*100.0)/100.0);
		 
		
		addBooking(booking);

		BookingInfo[] bookings = getBooking();
		
		for(int i = 0; i < bookings.length; i++) {
			System.out.println(bookings[i].id + " " + bookings[i].size + " " + bookings[i].name + " "+ bookings[i].time);
		}
	}
	
	public static void addBooking(BookingInfo bookings) {
		try {
			
		Connection conn = databaseConnect();
		
		String sql = "INSERT INTO Bookings (id, size, name) VALUES (?, ?, ?)";
		
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, bookings.id);
		statement.setFloat(2, bookings.size);
		statement.setString(3, bookings.name);
		
		statement.executeUpdate();
		
		statement.close();
		conn.close();
		}
		catch(Exception e) {
			System.out.println("Error in addBooking");
			e.printStackTrace();
		}
	}
	
	public static BookingInfo[] getBooking() {
		try {
			
			Connection conn = databaseConnect();
			Statement statement = conn.createStatement();
			
			String sql = "SELECT COUNT(*) FROM Bookings";
			ResultSet result = statement.executeQuery(sql);
			int count = result.getInt(1);
			
			BookingInfo[] bookings;
			bookings = new BookingInfo[count];			
			
			
			sql = "SELECT * FROM Bookings";
			
			result = statement.executeQuery(sql);
			
			int i = 0;
			while (result.next()) {
				bookings[i] = new BookingInfo();
				bookings[i].id = result.getInt("id");
				bookings[i].size = result.getInt("size");
				bookings[i].time = result.getTime("time");
				bookings[i].name = result.getString("name");
				i++;
			}
			

                
			statement.close();
			conn.close();
			
			return bookings;
			}
			catch(Exception e) {
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
