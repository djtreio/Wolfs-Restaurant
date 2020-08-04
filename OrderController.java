package CP317;


public class OrderController {
	
	public static int orderid = 0;
	public static OrderType order;
	public static int itemid = 0;
	public static ItemType item;

	public static void main(String[] args) {
		

	}
	
	public static OrderType[] GetOrders() {
		return OrderDatabase.getOrders();
	}
	
	public static OrderType GetOrder(int orderid) {
		return OrderDatabase.getOrder(orderid);
	}
	
	public static void CreateOrder() {
		OrderType neworder = new OrderType();
		neworder.price = 0;
		neworder.discount = 0;
		neworder.finalPrice = 0;
		OrderDatabase.addOrder(neworder);
	}
	
	public static void EditOrder(OrderType order) {
		OrderDatabase.setOrder(order);
	}
	
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
	
	public static ItemType[] GetItems(int orderid) {
		return OrderDatabase.getItems(orderid);
	}
	
	public static ItemType GetItem(int orderid, int itemid) {
		return OrderDatabase.getItem(orderid,itemid);
	}
	
	public static void RemoveItem(int orderid, int itemid) {
		OrderDatabase.removeItem(orderid,itemid);
	}
	

}
