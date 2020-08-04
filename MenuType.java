package CP317;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MenuType {
	public int id;
	public String name;
	public String category;
	public String status;
	public float price = 0;
	public float cost = 0;
	
	public MenuType(String name, String category, String status, float price, float cost) {
		this.name = name;
		this.category = category;
		this.status = status;
		this.price = price;
		this.cost = cost;
	}
	
	
	//GOOD
	//Edits an attribute of a menu item
	public void editItem(String attrib, String value) {
		try {
			Connection conn = MenuDatabase.databaseConnect();
			
			String sql = "UPDATE Menu SET " + attrib + " = ? WHERE id = ?";

			PreparedStatement statement = conn.prepareStatement(sql);
			
			if (attrib.equals("price") | attrib.equals("cost")) {
				statement.setFloat(1, Float.parseFloat(value));
			}
			else {
				statement.setString(1, value);
			}

			statement.setInt(2,this.id);
			
			statement.executeUpdate();
			statement.close();
			conn.close();
			
		}
		catch(Exception e) {
			System.out.println("Error in editItem");
			e.printStackTrace();
		}
	}
	
	//GOOD
	//Deletes a menuitem from the database
	public void removeItem() {
		try {
			Connection conn = MenuDatabase.databaseConnect();
			
			String sql = "DELETE FROM Menu WHERE name = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1,this.name);
			
			statement.executeUpdate();
			statement.close();
			conn.close();
			
		}
		catch(Exception e) {
			System.out.println("Error in removeItem");
			e.printStackTrace();
		}
	}
}



