package inventoryAllocator;

import java.util.HashMap;

public class ResultObject {
	
	String warehouseName;
	HashMap<String, Integer> items;
	
	/**
	 * Constructor
	 * @param warehouseName - name of the warehouse
	 * @param items - items being ordered
	 */
	public ResultObject(String warehouseName, HashMap<String, Integer> items) {
		this.warehouseName = warehouseName;
		this.items = items;
	}
	
	/**
	 * Returns warehouse name
	 * @return - warehouse name 
	 */
	public String getWarehouseName() {
		return this.warehouseName;
	}
	
	/**
	 * Returns how much of an item is stocked
	 * @param item - what item is being looked for
	 * @return - how many of that item are in the warehouse
	 */
	public int getItemCount(String item) {
		return items.get(item);
	}
	
	/**
	 * Add item or change number of existing item
	 * @param item - which item
	 * @param inventory - how much of the item
	 */
	public void addItem(String item, int inventory) {
		if(items.get(item) != null) {
			items.put(item , inventory + items.get(item));
		}
		else {
			items.put(item, inventory);
		}
	}
	
	/**
	 * Returns string interpretation of the object
	 */
	@Override 
	public String toString() {
		return this.warehouseName + ":" + this.items.toString();
	}
	
	
	
}
