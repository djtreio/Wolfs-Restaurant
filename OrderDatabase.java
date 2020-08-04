package CP317;
import java.sql.*;


class OrderType{
	public int id;
	public float price = 0;
	public float discount = 0;
	public float finalPrice = 0;
}

class ItemType{
	public int id;
	public int orderid;
	public String name = "";
	public String side;
	public String allergy;
	public float price;
	public float discount;
	public String notes;
	
}

public class OrderDatabase {
	private static final String ConnectionString = "jdbc:sqlite:wolfs.sql";

	public static void main(String[] args) {
		//testOrders();
		
		//testItems();
		
		//OrderType order = getOrder(40);
		//System.out.println(order.id + " " + order.price + " " + order.discount + " " + order.finalPrice);
		
		ItemType item = getItem(40, 6);
		System.out.println(item.id + " " + item.orderid + " " + item.name + " " + item.side + " " + item.allergy + " " + item.price + " " + item.discount + " " + item.notes);
		
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
	
	public static void addItem(ItemType item) {
		try {
			
		Connection conn = databaseConnect();
		
		String sql = "INSERT INTO Items (orderid, name, side, allergy, price, discount, notes) VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setFloat(1, item.orderid);
		statement.setString(2, item.name);
		statement.setString(3, item.side);
		statement.setString(4, item.allergy);
		statement.setFloat(5, item.price);
		statement.setFloat(6, item.discount);
		statement.setString(7, item.notes);
		
		statement.executeUpdate();
		
		statement.close();
		conn.close();
		}
		catch(Exception e) {
			System.out.println("Error in addItem");
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
			
			
			sql = "SELECT * FROM Orders ORDER BY id DESC";
			
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
	
	public static ItemType[] getItems(int orderid) {
		try {
			
			Connection conn = databaseConnect();
			
			
			String sql = "SELECT COUNT(*) FROM Items WHERE orderid = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, orderid);
			
			ResultSet result = statement.executeQuery();
			int count = result.getInt(1);
			
			ItemType[] items;
			items = new ItemType[count];			
			
			
			sql = "SELECT * FROM Items WHERE orderid = ?";
			statement = conn.prepareStatement(sql);
			statement.setInt(1, orderid);
			
			result = statement.executeQuery();
			
			int i = 0;
			while (result.next()) {
				items[i] = new ItemType();
				items[i].id = result.getInt("id");
				items[i].orderid = result.getInt("orderid");
				items[i].name = result.getString("name");
				items[i].side = result.getString("side");
				items[i].allergy = result.getString("allergy");
				items[i].price = result.getFloat("price");
				items[i].discount = result.getFloat("discount");
				items[i].notes = result.getString("notes");
				i++;
			}
                
			statement.close();
			conn.close();
			
			return items;
			}
			catch(Exception e) {
				System.out.println("Error in getItems");
				e.printStackTrace();
			}
		
		return null;
	}
	
	
	public static OrderType getOrder(int orderid) {
		try {
			Connection conn = databaseConnect();

			OrderType order;		
			
			String sql = "SELECT * FROM Orders WHERE id = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, orderid);
			
			ResultSet result = statement.executeQuery();
			
			order = new OrderType();
			order.id = result.getInt("id");
			order.price = result.getFloat("price");
			order.discount = result.getFloat("discount");
			order.finalPrice = result.getFloat("finalprice");
			
                
			statement.close();
			conn.close();
			
			return order;
			}
			catch(Exception e) {
				System.out.println("Error in getOrder");
				e.printStackTrace();
			}
		
		return null;
	}
	
	public static ItemType getItem(int orderid, int itemid) {
		try {
			
			Connection conn = databaseConnect();
			
			ItemType item;			
			
			String sql = "SELECT * FROM Items WHERE orderid = ? AND id = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setInt(1, orderid);
			statement.setInt(2, itemid);
			
			ResultSet result = statement.executeQuery();
			
			item = new ItemType();
			if (result.next()) {
			item.id = result.getInt("id");
			item.orderid = result.getInt("orderid");
			item.name = result.getString("name");
			item.side = result.getString("side");
			item.allergy = result.getString("allergy");
			item.price = result.getFloat("price");
			item.discount = result.getFloat("discount");
			item.notes = result.getString("notes");
			}
                
			statement.close();
			conn.close();
			
			return item;
			}
			catch(Exception e) {
				System.out.println("Error in getItem");
				e.printStackTrace();
			}
		
		return null;
	}
	
	
	public static void setOrder(OrderType order) {
		try {
			
		Connection conn = databaseConnect();
		
		String sql = "UPDATE Orders SET price = ?, discount = ?, finalprice = ? WHERE id = ?";
		
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setFloat(1, order.price);
		statement.setFloat(2, order.discount);
		statement.setFloat(3, order.finalPrice);
		statement.setInt(4, order.id);
		
		statement.executeUpdate();
		
		statement.close();
		conn.close();
		}
		catch(Exception e) {
			System.out.println("Error in setOrder");
			e.printStackTrace();
		}
	}
	
	public static void setItem(ItemType item) {
		try {
			
		Connection conn = databaseConnect();
		
		String sql = "UPDATE Items SET name = ?, side = ?, allergy = ?, price = ?, discount = ?, notes = ? WHERE id = ?";
		
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, item.name);
		statement.setString(2, item.side);
		statement.setString(3, item.allergy);
		statement.setFloat(4, item.price);
		statement.setFloat(5, item.discount);
		statement.setString(6, item.notes);
		statement.setInt(7, item.id);
		
		statement.executeUpdate();
		
		statement.close();
		conn.close();
		}
		catch(Exception e) {
			System.out.println("Error in setItem");
			e.printStackTrace();
		}
	}
	
	public static void removeItem(int orderid, int itemid) {
		try {
			
			Connection conn = databaseConnect();
			
			String sql = "DELETE FROM Items WHERE id = ? AND orderid = ?";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, itemid);
			statement.setInt(2, orderid);
			
			statement.executeUpdate();
			
			statement.close();
			conn.close();
			}
			catch(Exception e) {
				System.out.println("Error in removeItem");
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
	
	/**
	private static void testOrders() {
		OrderType order = new OrderType();

		order.price = (float)(Math.round((Math.random() * 50 + 10)*100.0)/100.0);
		order.discount = (float)(Math.round((Math.random() * 20)*100.0)/100.0);
		order.finalPrice = order.price - order.discount;
				
		addOrder(order);
				
		OrderType[] orders = getOrders();
				
		for(int i = 0; i < orders.length; i++) {
			System.out.println(orders[i].id + " " + orders[i].price + " " + orders[i].discount + " " + orders[i].finalPrice);
		}
				
		order = orders[orders.length-1];
				
		order.price = (float)(Math.round((Math.random() * 50 + 10)*100.0)/100.0);
		order.discount = (float)(Math.round((Math.random() * 20)*100.0)/100.0);
		order.finalPrice = order.price - order.discount;
				
		setOrder(order);
				
		orders = getOrders();
				
		System.out.println();
		for(int i = 0; i < orders.length; i++) {
			System.out.println(orders[i].id + " " + orders[i].price + " " + orders[i].discount + " " + orders[i].finalPrice);
		}
	}
	**/
	
	/**
	private static void testItems() {
		ItemType item = new ItemType();
		
		item.orderid = 38;
		item.name = "pasta";
		item.side = "fries";
		item.allergy = "none";
		item.price = (float)(Math.round((Math.random() * 10 + 5)*100.0)/100.0);
		item.discount = (float)(Math.round((Math.random() * 5)*100.0)/100.0);
		item.notes = "no peppers or onions";

				
		addItem(item);
				
		ItemType[] items = getItems(item.orderid);
				
		for(int i = 0; i < items.length; i++) {
			System.out.println(items[i].id + " " + items[i].orderid + " " + items[i].name + " " + items[i].side + " " + items[i].allergy + " " + items[i].price + " " + items[i].discount + " " + items[i].notes);
		}
				
		item = items[items.length-1];
				
		item.name = "burger";
		item.side = "salad";
		item.allergy = "cucumbers";
		item.price = (float)(Math.round((Math.random() * 10 + 5)*100.0)/100.0);
		item.discount = (float)(Math.round((Math.random() * 5)*100.0)/100.0);
		item.notes = "extra pickles";

				
		setItem(item);
				
		items = getItems(item.orderid);
				
		System.out.println();
		for(int i = 0; i < items.length; i++) {
			System.out.println(items[i].id + " " + items[i].orderid + " " + items[i].name + " " + items[i].side + " " + items[i].allergy + " " + items[i].price + " " + items[i].discount + " " + items[i].notes);
		}
		
		removeItem(item.id, item.orderid);
		
		
		items = getItems(item.orderid);
		
		System.out.println();
		for(int i = 0; i < items.length; i++) {
			System.out.println(items[i].id + " " + items[i].orderid + " " + items[i].name + " " + items[i].side + " " + items[i].allergy + " " + items[i].price + " " + items[i].discount + " " + items[i].notes);
		}
	}
	
**/
}
