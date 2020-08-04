package CP317;


public class MenuController {

	public static String itemName;
	public static int menuid;
	public static MenuType menu;
	
	
	public static void main(String[] args) {
		
	}
	
	//Changes status of an item to y(meaning on menu)
	//Params: Item to add to menu
	//Returns: void
	public static void addToMenu(MenuType item) {
		//Change status of item
		item.editItem("status", "y");
		//Add to menu
		MenuDatabase.addMenuItem(item);
		
	}
	
	//Sets the variables of an item on the menu
	//Params: Item to set variables of
	//Returns: void
	public static void setMenuItem(MenuType item) {
		//Check if item is not on menu
		if (menuid == -1) {
			addToMenu(item);

		}
		//Edit the variabels
		else {
			item.editItem("name", item.name);
			item.editItem("category", item.category);
			item.editItem("price", Float.toString(item.price));
		}
	}
	
	//Removes an item from the menu
	//Params: Item to remove from menu
	//Returns: void
	public static void removefromMenu(MenuType item) {
		item.editItem("status", "n");
	}
	
	//Retrieves list of items that should be on menu
	//Params: None
	//Returns: array of MenuType items, containing menu items
	public static MenuType[] getMenu() {
		MenuType[] menuItems = MenuDatabase.getMenuItems();
		return menuItems;
	}
}
