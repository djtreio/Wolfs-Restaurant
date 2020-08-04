package CP317;

import java.sql.*;



public class MenuDatabase {
	private static final String ConnectionString = "jdbc:sqlite:Wolfs.sql";

	//Testing function
	public static void main(String[] args) {
		//Test addMenuItem
		MenuType menuItem = new MenuType("Item "+ (Math.round((Math.random() * 50 + 10)*100.0)/100.0),"Food","y",(float)(Math.round((Math.random() * 50 + 10)*100.0)/100.0),(float)(Math.round((Math.random() * 20)*100.0)/100.0));
		addMenuItem(menuItem);
		
		//Test getMenuItems
		MenuType[] menuItems = getMenuItems();
		for(int i = 0; i < menuItems.length; i++) {
			System.out.println(menuItems[i].id + " " + menuItems[i].name);
		}
		
		//Test getMenuItem
		int searchname = 11;
		MenuType result = getMenuItem(searchname);
		System.out.println("\n" + result.id + " " + result.name);
		
		searchname = 14;
		result = getMenuItem(searchname);
		System.out.println("\n" + result.id + " " + result.name);
		
		//Test editMenuItem
		MenuType toEdit = getMenuItem(15);
		toEdit.editItem("price", "500");
		result = getMenuItem(16);
		System.out.println("\n" + result.id + " " + result.name + " " + result.price);
		
		//Test removeMenuItem
		MenuType toRemove = getMenuItem(17);
		toRemove.removeItem();
	}
	
	//Adds a menutype item to the menu database
	//Params: Item to be added to menu database
	//Returns: void
	public static void addMenuItem(MenuType menuItem) {
		try {
			
		Connection conn = databaseConnect();
		
		//Prepare sql statement to add a row in the database
		String sql = "INSERT INTO Menu (price, cost, name, category) VALUES (?, ?, ?, ?)";
		
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setFloat(1, menuItem.price);
		statement.setFloat(2, menuItem.cost);
		statement.setString(3, menuItem.name);
		statement.setString(4, menuItem.category);
		
		//Execute statement
		statement.executeUpdate();
		
		statement.close();
		conn.close();
		}
		catch(Exception e) {
			System.out.println("Error in addMenuItem");
			e.printStackTrace();
		}
	}
	
	//Retrieves a menutype item from the database
	//Params: id of item to be retrieved
	//Returns: Menutype item of the item to be returned, or null if it not found
	public static MenuType getMenuItem(int id) {
		MenuType menuItem = new MenuType("Null","","n",0,0);

		try {
			Connection conn = databaseConnect();
			
			//prepare sql statement
			String sql = "SELECT * FROM Menu WHERE id = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			
			ResultSet result = statement.executeQuery();
			
			menuItem.id = result.getInt("id");
			menuItem.name = result.getString("name");
			menuItem.category = result.getString("category");
			menuItem.price = result.getFloat("price");
			menuItem.status = result.getString("status");
			menuItem.cost = result.getFloat("cost");

			//Print error message if item is not found in database
			if (menuItem.id == 0) {
				System.out.println("No menu item found with name " + Integer.toString(id));
			}
			
			statement.close();
			conn.close();
			return menuItem;
			
		}
		catch(Exception e) {
			System.out.println("Error in getMenuItem");
			e.printStackTrace();
			return menuItem;
		}
	}
	
	//Returns a Menu item using its name
	//Params: Name of menu item
	//Returns: Menu item that was requested, or null if not found
	public static MenuType getMenuItem(String name) {
		MenuType menuItem = new MenuType("Null","","n",0,0);

		try {
			Connection conn = databaseConnect();
			
			//prepare sql statement
			String sql = "SELECT * FROM Menu WHERE name = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, name);
			
			ResultSet result = statement.executeQuery();
			
			menuItem.id = result.getInt("id");
			menuItem.name = result.getString("name");
			menuItem.category = result.getString("category");
			menuItem.price = result.getFloat("price");
			menuItem.status = result.getString("status");
			menuItem.cost = result.getFloat("cost");

			//Print error message if not found
			if (menuItem.id == 0) {
				System.out.println("No menu item found with name " + name);
			}
			
			statement.close();
			conn.close();
			return menuItem;
			
		}
		catch(Exception e) {
			System.out.println("Error in getMenuItem");
			e.printStackTrace();
			return menuItem;
		}
	}
	
	//Retrieves all menu items that should be on the menu
	//Params: None
	//Returns: Array with all menutype items that should be on the menu(status = y)
	public static MenuType[] getMenuItems() {
		try {
			Connection conn = databaseConnect();
			Statement statement = conn.createStatement();
			
			//Prepare sql statement
			String sql = "SELECT COUNT(*) FROM Menu WHERE status = \"y\"";
			ResultSet result = statement.executeQuery(sql);
			int count = result.getInt(1);
			
			MenuType[] menuItems;
			menuItems = new MenuType[count];			
			
			//Add a condition here to only select items with status = y
			sql = "SELECT * FROM Menu WHERE status = \"y\"";
			
			result = statement.executeQuery(sql);
			
			//Place items in an array
			int i = 0;
			while (result.next()) {
				menuItems[i] = new MenuType(result.getString("name"),result.getString("category"),result.getString("status"),result.getFloat("price"),result.getFloat("cost"));
				menuItems[i].id = result.getInt("id");
				i++;
			}
			
			statement.close();
			conn.close();
			
			return menuItems;
			}
			catch(Exception e) {
				System.out.println("Error in getOrders");
				e.printStackTrace();
			}
		return null;
	}
	
	//Connects to the database
	//Params: None, uses ConnectionString
	//Returns: database connection item
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
