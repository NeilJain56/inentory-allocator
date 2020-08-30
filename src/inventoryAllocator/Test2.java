package inventoryAllocator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

class Test2 {
	//Checks case where ordered amount equals warehouse inventory
	@Test
	void testInventoryAllocator() {
		// items ordered
		HashMap<String, Integer> orderedItems = new HashMap<String, Integer>();
		orderedItems.put("Apple", 5);

		// inventory available
		ArrayList<Warehouse> inventoryList = new ArrayList<Warehouse>();
		HashMap<String, Integer> inventoryItems = new HashMap<String, Integer>();
		inventoryItems.put("Apple", 5);
		Warehouse nj = new Warehouse("nj", inventoryItems);
		inventoryList.add(nj);

		// actual result
		ArrayList<ResultObject> result = InventoryAllocator.inventoryAllocator(orderedItems, inventoryList);

		// expected result
		ArrayList<ResultObject> answer = new ArrayList<ResultObject>();
		HashMap<String, Integer> answerMap = new HashMap<String, Integer>();
		answerMap.put("Apple", 5);
		ResultObject temp = new ResultObject("nj", answerMap);
		answer.add(temp);
		
		assertEquals(answer.toString(), result.toString());
	}

}
