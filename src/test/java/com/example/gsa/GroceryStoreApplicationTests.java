package com.example.gsa;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class GroceryStoreApplicationTests {

	@Test
	void testNonNUll() {
		GroceryStoreApplication groceryStoreApplication = new GroceryStoreApplication();
		Assert.isTrue(groceryStoreApplication!=null,"Object is not null");
	}

}
