package inventoryAllocator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InventoryAllocator {

	/* This is a sample main class to test further if you wish
	 * Steps:
	 * 	Create the order (HashMap of key: item and value: amount of that item)
	 *  Create the warehouse inventory (ArrayList of warehouse objects which contain the name of the warehouse and a 
	 *  hashmap or all inventory)
	 *  Then send to method
	 */
	public static void main(String[] args) {
		
		/*HashMap<String, Integer> orderedItems = new HashMap<String, Integer>();
		orderedItems.put("Apple", 5);
		orderedItems.put("Banana", 5);
		
		ArrayList<Warehouse> inventoryList = new ArrayList<Warehouse>();
		HashMap<String, Integer> inventoryItems = new HashMap<String, Integer>();
		inventoryItems.put("Apple", 5);
		inventoryItems.put("Banana", 4);
		Warehouse nj = new Warehouse("nj", inventoryItems);
	
		HashMap<String, Integer> inventoryItems2 = new HashMap<String, Integer>();
		inventoryItems2.put("Apple", 5);
		inventoryItems2.put("Banana", 4);
		Warehouse az = new Warehouse("az", inventoryItems2);
		
		inventoryList.add(nj);
		inventoryList.add(az);
		
		inventoryAllocator(orderedItems, inventoryList);*/
	}
	
	/**
	 * This method takes in an order and inventory and provides the cheapest way to get those items
	 * @param orderedItems - map of all items ordered
	 * @param inventoryList - arraylist of warehouse objects with all inventory
	 * @return ArrayList of which items need to be shipped from where and how many are needed from each location
	 */
	public static ArrayList<ResultObject> inventoryAllocator(HashMap<String, Integer> orderedItems, ArrayList<Warehouse> inventoryList){
		ArrayList<ResultObject> result = new ArrayList<ResultObject>();
		
		//error checking for invalid input
		if(orderedItems == null || inventoryList == null || orderedItems.size() == 0 || inventoryList.size() == 0) {
			return result;
		}
		
		//run through all ordered items
		for(Map.Entry<String, Integer> orderedItem : orderedItems.entrySet()) {
			String item = (String)orderedItem.getKey();
			int amount = ((int)orderedItem.getValue());
			
			//if the order can be made add it to the result list
			if(orderIsPossible(item, amount, inventoryList)) {
				ArrayList<ResultObject> temp = order(item, amount, inventoryList);
				for(int i =0; i < temp.size(); i++) {
					result.add(temp.get(i));
				}
			}
			else {
				//otherwise return that the order is not possible 
				ArrayList<ResultObject> orderNotPossible = new ArrayList<ResultObject>();	
				return orderNotPossible; 
			}
			
		}
		
		
		
		//merge maps
		for(int i = 0; i < result.size(); i++) {
			for(int j = i + 1; j < result.size(); j++) {
				if(result.get(i).warehouseName.equals(result.get(j).warehouseName)) {
					result.get(i).items.putAll(result.get(j).items);
					result.remove(j);
					j--;
				}
			}
		}
		
		//for console purposes and checking
		System.out.println(result);
		
		return result;
		
	}
	
	/**
	 * This method determines the optimal order that can be made 
	 * @param item - which item is being ordered
	 * @param amount - how much of the item is being ordered
	 * @param inventoryList - what is the inventory left after all the orders already made
	 * @return - A list of how the order can be completed with the inventory given
	 */
	public static ArrayList<ResultObject> order(String item, int amount, ArrayList<Warehouse> inventoryList) {
		
		ArrayList<ResultObject> resultingOrder = new ArrayList<ResultObject>();
		ResultObject temp;
		
		//iterate through inventory
		for(int i = 0; i < inventoryList.size(); i++) {
			//if enough of the item has been found break the loop
			if(amount == 0) {
				break;
			}
			else {
				//check if the item exists at the warehouse
				if(inventoryList.get(i).inventory.get(item) != null) {
					//more inventory than needed
					if(inventoryList.get(i).inventory.get(item) >= amount) {
			
						HashMap<String, Integer> tempMap = new HashMap<String, Integer>();
						tempMap.put(item, amount);
					    temp = new ResultObject(inventoryList.get(i).warehouseName, tempMap);
					    resultingOrder.add(temp);
					    inventoryList.get(i).setInventory(item, inventoryList.get(i).inventory.get(item) - amount);
					    amount = 0;
					}
					//less inventory than needed
					else if(inventoryList.get(i).inventory.get(item) < amount) {
					
						
						HashMap<String, Integer> tempMap = new HashMap<String, Integer>();
						tempMap.put(item, inventoryList.get(i).inventory.get(item));
						temp = new ResultObject(inventoryList.get(i).warehouseName, tempMap);
						resultingOrder.add(temp);
						amount = amount - inventoryList.get(i).inventory.get(item);
						inventoryList.get(i).setInventory(item, 0);
						
					}
				}
			}
		}
		
		return resultingOrder;
	}
	
	/**
	 * This method checks whether an order is possible or not
	 * @param item - which item is being ordered
	 * @param amount - how much of the item is being ordered
	 * @param inventoryList - what inventory do the warehouses have
	 * @return - true if the order can be made 
	 */
	public static boolean orderIsPossible(String item, int amount, ArrayList<Warehouse> inventoryList) {
		
		for(int i =0; i < inventoryList.size(); i++) {
			if(inventoryList.get(i).inventory.get(item) != null) {
				amount -= inventoryList.get(i).inventory.get(item);
			}
		}
		
		if(amount <= 0) {
			return true;
		}
		
		return false;
	}
}
