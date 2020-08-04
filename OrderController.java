package CP317;


public class OrderController {
	
	public static int orderid = 0;
	public static OrderType order;
	public static int itemid = 0;
	public static ItemType item;

	public static void main(String[] args) {
		

	}
	/**
	 * gets all orders from database
	 */
	public static OrderType[] GetOrders() {
		return OrderDatabase.getOrders();
	}
	
	/**
	 * gets order from database matching orderid
	 * @param orderid - the order id of wanted order
	 */
	public static OrderType GetOrder(int orderid) {
		return OrderDatabase.getOrder(orderid);
	}
	
	/**
	 * creates empty order and adds to database
	 */
	public static void CreateOrder() {
		OrderType neworder = new OrderType();
		neworder.price = 0;
		neworder.discount = 0;
		neworder.finalPrice = 0;
		OrderDatabase.addOrder(neworder);
	}
	
	/**
	 * edit order in database with new properties
	 * @param order - ordertype with properties to set to database
	 */
	public static void EditOrder(OrderType order) {
		OrderDatabase.setOrder(order);
	}
	
	/**
	 * first checks menu database to see if item exists in the menu and if so get price. if not, price is $18 by default
	 * then checks if the orderid is -1; if so, the AddButton was pressed so it will create the order. if not it updates a current order
	 * @param item - itemtype to set new item to
	 */
	public static void SetItem(ItemType item) {
		String name = item.name;
		MenuType menu = MenuDatabase.getMenuItem(name);
		if (menu.price == 0) {
			item.price = 18;
		}
		else {
			item.price = menu.price;
		}
		
		if (item.id == -1) {
			OrderDatabase.addItem(item);
		}
		else {
			OrderDatabase.setItem(item);
		}
	}
	
	/**
	 * sets order properties of selected order
	 * @param order - ordertype with new properties to set
	 */
	public static void SetOrder(OrderType order) {
		ItemType[] items = GetItems(order.id);
		float total = 0;
		for (int i=0;i<items.length;i++) {
			total += items[i].price - items[i].discount;
		}
		order.price = total;
		order.finalPrice = order.price - order.discount;
		OrderDatabase.setOrder(order);
	}
	
	/**
	 * gets all items matching orderid
	 * @param orderid - selected orderid to look for in database
	 */
	public static ItemType[] GetItems(int orderid) {
		return OrderDatabase.getItems(orderid);
	}
	
	/**
	 * gets specific item matchin itemmid and orderid
	 * @param orderid - the id of the order selected
	 * @param itemid - the id of the item selected
	 */
	public static ItemType GetItem(int orderid, int itemid) {
		return OrderDatabase.getItem(orderid,itemid);
	}
	
	/**
	 * removes item matching itemid and orderid
	 * @param orderid - the id of the order selected
	 * @param itemid - the id of the item selected
	 */
	public static void RemoveItem(int orderid, int itemid) {
		OrderDatabase.removeItem(orderid,itemid);
	}
	

}
