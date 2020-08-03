
public class MenuController {
	private static final String ConnectionString = "jdbc:sqlite:/Users/braedensmith/Desktop/Wolfs.db";
	
	public static void main(String[] args) {
		
	}
	
	//Changes status of an item to y(meaning on menu)
	public static void addToMenu(MenuType item) {
		item.editItem("status", "y");
		MenuType newitem = MenuDatabase.getMenuItem(item.name);
		
		//Add newitem to GUI(Jackson, let me know when you get here I'll help implement this. Not sure how do to it since you've made the GUI
		
	}
	
	public static void removefromMenu(MenuType item) {
		item.editItem("status", "n");
		//Fix GUI
	}
	
	public static void getMenu() {
		MenuType[] menuItems = MenuDatabase.getMenuItems();
		//Place at appropriate spot on GUI
	}
}
