package inventoryAllocator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

class Test1 {

	//This test tests when 1 item is ordered and there is not enough inventory 
	@Test
	void testInventoryAllocator() {
		//items ordered
		HashMap<String, Integer> orderedItems = new HashMap<String, Integer>();
		orderedItems.put("Apple", 5);
		
		//inventory available
		ArrayList<Warehouse> inventoryList = new ArrayList<Warehouse>();
		HashMap<String, Integer> inventoryItems = new HashMap<String, Integer>();
		inventoryItems.put("Apple", 1);
		Warehouse nj = new Warehouse("nj", inventoryItems);
		inventoryList.add(nj);
		
		//actual result
		ArrayList<ResultObject> result = InventoryAllocator.inventoryAllocator(orderedItems, inventoryList);
		
		//expected result
		ArrayList<ResultObject> answer = new ArrayList<ResultObject>();
		assertEquals( answer , result);
	}

}
