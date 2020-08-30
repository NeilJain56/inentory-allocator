package inventoryAllocator;

import java.util.ArrayList;
import java.util.HashMap;

public class Warehouse {

	String warehouseName;
	
	HashMap<String, Integer> inventory;
	
	/**
	 * Constructor
	 * @param warehouseName - name of the warehouse
	 * @param inventory - inventory in the warehouse
	 */
	public Warehouse(String warehouseName, HashMap<String, Integer> inventory) {
		this.warehouseName = warehouseName;
		this.inventory = inventory;
	}
	
	/**
	 * Returns warehouse name
	 * @return warehouse name
	 */
	public String getWarehouseName() {
		return this.warehouseName;
	}
	
	/**
	 * Returns inventory amount of an item
	 * @param item - which item is being looked for
	 * @return return amount
	 */
	public int getInventory(String item) {
		return this.inventory.get(item);
	}
	
	/**
	 * Sets inventory for a given item
	 * @param item - which item
	 * @param newInventory - amount of that item
	 */
	public void setInventory(String item, int newInventory) {
		this.inventory.put(item, newInventory);
	}
	
	/**
	 * String interpretation of the item
	 */
	public String toString() {
		return this.warehouseName + ": " + this.inventory;
	}
	
}
