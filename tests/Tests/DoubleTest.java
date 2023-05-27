package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Data.Data;

class DoubleTest {
	private Data<Double> data;
	
	@BeforeEach
	void initialize() {
		data = new Data<Double>();
	}
	
	@Test
	void testEmptyData() {
		assertEquals(0, data.size());
	}

	@Test
	void testCreateAUnitOfData() {
		assertEquals(true, data.create("Batata", 5.0));
		assertEquals(1, data.size());
	}
	
	@Test
	void testCreateMultipleDatas() {
		assertEquals(true, data.create("Batata", 5.0));
		assertEquals(true, data.create("Tomate", 7.0));
		assertEquals(true, data.create("Cebola", 9.0));
		assertEquals(3, data.size());
	}
	
	@Test
	void testCreateRepeatingDatas() {
		assertEquals(true, data.create("Batata", 5.0));
		assertEquals(false, data.create("Batata", 7.0));
		assertEquals(false, data.create("Batata", 9.0));
		assertEquals(1, data.size());
		assertEquals(5.0, data.read("Batata"));
	}
	
	@Test
	void testRead() {
		assertEquals(true, data.create("Batata", 5.0));
		assertEquals(5.0, data.read("Batata"));
	}
	
	@Test
	void testReadNullData() {
		assertEquals(null,data.read("Batata"));
	}
	
	@Test
	void testUpdate() {
		assertEquals(true, data.create("Batata", 5.0));
		assertEquals(true, data.update("Batata", 10.0));
		assertEquals(10.0, data.read("Batata"));
	}
	
	@Test
	void testUpdateWithoutCreate() {
		assertEquals(false, data.update("Batata", 5.0));
		assertEquals(5.0, data.read("Batata"));
	}
	
	@Test
	void testDelete() {
		assertEquals(true, data.create("Batata", 5.0));
		assertEquals(5.0,data.read("Batata"));
		assertEquals(true, data.delete("Batata"));	
		assertEquals(0, data.size());
		assertEquals(null,data.read("Batata"));
	}
	
	@Test
	void testDeleteNonexistentObject() {
		assertEquals(true, data.create("Batata", 5.0));
		assertEquals(false, data.delete("Tomate"));		 
		assertEquals(1, data.size());
	}
}
