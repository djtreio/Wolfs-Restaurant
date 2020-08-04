package CP317;

import java.sql.*;



class BookingInfo{
	public int id;
	public int size;
	public String time;
	public String name;
	public String date;
	public String notes;
	public String email;
	public String phone;
	
}

public class ReservationsDatabase {
	
	public static int bookingid;
	public static BookingInfo booking;
	
	
	private static final String ConnectionString = "jdbc:sqlite:wolfs.sql";
	//Bookings test
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookingInfo booking = new BookingInfo();
		
		booking.time= "10:15";
		booking.name = "Name "+ (Math.round((Math.random() * 50 + 10)*100.0)/100.0);
		booking.size = (int)(Math.round((Math.random() * 20)*100.0)/100.0);
		 
		
		addBooking(booking);

		BookingInfo[] bookings = getBookings();
		
		for(int i = 0; i < bookings.length; i++) {
			System.out.println(bookings[i].id + " " + bookings[i].size + " " + bookings[i].name + " "+ bookings[i].time);
		}
	}
	//Adds a booking to the Bookings table
	public static void addBooking(BookingInfo bookings) {
		try {
			
		Connection conn = databaseConnect();
		
		String sql = "INSERT INTO Bookings (size, name, time, date, email, phone, notes) VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, bookings.size);
		statement.setString(2, bookings.name);
		statement.setString(3, bookings.time);
		statement.setString(4, bookings.date);
		statement.setString(5, bookings.email);
		statement.setString(6, bookings.phone);
		statement.setString(7, bookings.notes);
		
		
		statement.executeUpdate();
		
		statement.close();
		conn.close();
		}
		catch(Exception e) {
			System.out.println("Error in addBooking");
			e.printStackTrace();
		}
	}

	
	//Updates and changes any data specfied in a booking
	public static void setBooking(BookingInfo bookings) {
		try {
			
		Connection conn = databaseConnect();
		
		String sql = "UPDATE Bookings SET size = ?, name = ?, time = ?, date = ?, email = ?, phone = ?, notes = ? WHERE id = ?";
		
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, bookings.size);
		statement.setString(2, bookings.name);
		statement.setString(3, bookings.time);
		statement.setString(4, bookings.date);
		statement.setString(5, bookings.email);
		statement.setString(6, bookings.phone);
		statement.setString(7, bookings.notes);
		statement.setInt(8, bookings.id);
		
		
		statement.executeUpdate();
		
		statement.close();
		conn.close();
		}
		catch(Exception e) {
			System.out.println("Error in addBooking");
			e.printStackTrace();
		}
	}
	//removes sepcified booking from database, based on id

	public static void removeBooking(int itemid) {
		try {
			
			Connection conn = databaseConnect();
			
			String sql = "DELETE FROM Bookings WHERE id = ?";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, itemid);
			
			statement.executeUpdate();
			
			statement.close();
			conn.close();
			}
			catch(Exception e) {
				System.out.println("Error in RemoveBooking");
				e.printStackTrace();
			}
	}

	//Retrieves all bookings from database
	public static BookingInfo[] getBookings() {

		try {
			
			Connection conn = databaseConnect();
			Statement statement = conn.createStatement();
			
			String sql = "SELECT COUNT(*) FROM Bookings";
			ResultSet result = statement.executeQuery(sql);
			int count = result.getInt(1);
			
			BookingInfo[] bookings;
			bookings = new BookingInfo[count];			
			
			
			sql = "SELECT * FROM Bookings ORDER BY id DESC";
			
			result = statement.executeQuery(sql);
			
			int i = 0;
			while (result.next()) {
				bookings[i] = new BookingInfo();
				bookings[i].id = result.getInt("id");
				bookings[i].size = result.getInt("size");
				bookings[i].time = result.getString("time");
				bookings[i].name = result.getString("name");
				bookings[i].phone = result.getString("phone");
				bookings[i].email = result.getString("email");
				bookings[i].date = result.getString("date");
				bookings[i].notes = result.getString("notes");
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
	//Retrieves specific booking from database
	public static BookingInfo getBooking(int id) {
		try {
			
			Connection conn = databaseConnect();

			BookingInfo booking = new BookingInfo();

			
			String sql = "SELECT * FROM Bookings WHERE id = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1,id);
			
			ResultSet result = statement.executeQuery();
			
			booking.id = result.getInt("id");
			booking.size = result.getInt("size");
			booking.time = result.getString("time");
			booking.name = result.getString("name");
			booking.phone = result.getString("phone");
			booking.email = result.getString("email");
			booking.date = result.getString("date");
			booking.notes = result.getString("notes");

			
			
                
			statement.close();
			conn.close();
			
			return booking;
			}
			catch(Exception e) {
				System.out.println("Error in getBooking");
				e.printStackTrace();
			}
		
		return null;
	}
	
	
	//COnnects to database
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
