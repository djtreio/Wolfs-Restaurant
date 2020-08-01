import java.sql.*;
import java.util.*;
import java.util.Date;
import java.text.*;
import java.math.*;

class OrderType{
	public int id;
	public float price = 0;
	public float discount = 0;
	public float finalPrice = 0;
}

class ItemType{
	public int id;
	public int orderid;
	public String name;
	
}

public class OrderDatabase {
	private static final String ConnectionString = "jdbc:sqlite:wolfs.sql";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OrderType order = new OrderType();

		order.price = (float)(Math.round((Math.random() * 50 + 10)*100.0)/100.0);
		order.discount = (float)(Math.round((Math.random() * 20)*100.0)/100.0);
		order.finalPrice = order.price - order.discount;
		
		addOrder(order);
		
		OrderType[] orders = getOrders();
		
		for(int i = 0; i < orders.length; i++) {
			System.out.println(orders[i].id + " " + orders[i].price + " " + orders[i].discount + " " + orders[i].finalPrice);
		}
	}
	
	public static void addOrder(OrderType order) {
		try {
			
		Connection conn = databaseConnect();
		
		String sql = "INSERT INTO Orders (price, discount, finalprice) VALUES (?, ?, ?)";
		
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setFloat(1, order.price);
		statement.setFloat(2, order.discount);
		statement.setFloat(3, order.finalPrice);
		
		statement.executeUpdate();
		
		statement.close();
		conn.close();
		}
		catch(Exception e) {
			System.out.println("Error in addOrder");
			e.printStackTrace();
		}
	}
	
	public static OrderType[] getOrders() {
		try {
			
			Connection conn = databaseConnect();
			Statement statement = conn.createStatement();
			
			String sql = "SELECT COUNT(*) FROM Orders";
			ResultSet result = statement.executeQuery(sql);
			int count = result.getInt(1);
			
			OrderType[] orders;
			orders = new OrderType[count];			
			
			
			sql = "SELECT * FROM Orders";
			
			result = statement.executeQuery(sql);
			
			int i = 0;
			while (result.next()) {
				orders[i] = new OrderType();
				orders[i].id = result.getInt("id");
				orders[i].price = result.getFloat("price");
				orders[i].discount = result.getFloat("discount");
				orders[i].finalPrice = result.getFloat("finalprice");
				i++;
			}
			
			/**
			while (result.next()) {  
                System.out.println(result.getInt("id") +  "\t" +   
                		result.getFloat("price") + "\t" +  
                		result.getFloat("discount") + "\t" + 
                		result.getFloat("finalprice"));  
			}
			**/
                
			statement.close();
			conn.close();
			
			return orders;
			}
			catch(Exception e) {
				System.out.println("Error in getOrders");
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
