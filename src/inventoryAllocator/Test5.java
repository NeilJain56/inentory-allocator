package inventoryAllocator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

class Test5 {
	//Checks across 2 warehouses however is not possible
	@Test
	void testInventoryAllocator() {
		// items ordered
		HashMap<String, Integer> orderedItems = new HashMap<String, Integer>();
		orderedItems.put("Apple", 5);

		// inventory available
		ArrayList<Warehouse> inventoryList = new ArrayList<Warehouse>();
		HashMap<String, Integer> inventoryItems = new HashMap<String, Integer>();
		inventoryItems.put("Apple", 3);
		Warehouse nj = new Warehouse("nj", inventoryItems);
		inventoryList.add(nj);

		ArrayList<Warehouse> inventoryList2 = new ArrayList<Warehouse>();
		HashMap<String, Integer> inventoryItems2 = new HashMap<String, Integer>();
		inventoryItems2.put("Apple", 1);
		Warehouse az = new Warehouse("az", inventoryItems2);
		inventoryList.add(az);

		// actual result
		ArrayList<ResultObject> result = InventoryAllocator.inventoryAllocator(orderedItems, inventoryList);

		// expected result
		ArrayList<ResultObject> answer = new ArrayList<ResultObject>();
		

		assertEquals(answer.toString(), result.toString());
	}

}
