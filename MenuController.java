package CP317;


public class MenuController {

	public static String itemName;
	public static int menuid;
	public static MenuType menu;
	
	
	public static void main(String[] args) {
		
	}
	
	//Changes status of an item to y(meaning on menu)
	public static void addToMenu(MenuType item) {
		item.editItem("status", "y");
		MenuDatabase.addMenuItem(item);
		
		//Add newitem to GUI(Jackson, let me know when you get here I'll help implement this. Not sure how do to it since you've made the GUI
		
	}
	
	public static void setMenuItem(MenuType item) {
		if (menuid == -1) {
			addToMenu(item);

		}
		else {
			item.editItem("name", item.name);
			item.editItem("category", item.category);
			item.editItem("price", Float.toString(item.price));
		}
	}
	
	public static void removefromMenu(MenuType item) {
		item.editItem("status", "n");
		//Fix GUI
	}
	
	public static MenuType[] getMenu() {
		MenuType[] menuItems = MenuDatabase.getMenuItems();
		return menuItems;
	}
}
