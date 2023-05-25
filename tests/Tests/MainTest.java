package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Main.Data;
import Main.ReadNullException;

class MainTest {
	private Data data;
	
	@BeforeEach
	void initialize() {
		data = new Data();
	}
	
	@Test
	void testEmptyData() {
		assertEquals(0, data.size());
	}

	@Test
	void testCreateAUnitOfData() {
		data.create("Batata", 5.0);
		assertEquals(1, data.size());
	}
	
	@Test
	void testCreateMultipleDatas() {
		data.create("Batata", 5.0);
		data.create("Tomate", 7.0);
		data.create("Cebola", 9.0);
		assertEquals(3, data.size());
	}
	
	@Test
	void testCreateRepeatingDatas() {
		data.create("Batata", 5.0);
		data.create("Batata", 5.0);
		data.create("Batata", 5.0);
		assertEquals(1, data.size());
		assertEquals(15.0, data.read("Batata"));
	}
	
	@Test
	void testRead() {
		data.create("Batata", 5.0);
		assertEquals(5.0, data.read("Batata"));
	}
	
	@Test
	void testReadNullData() {
		try {
			data.read("Batata");
			fail("Aceitou ler variavel não criada");
		}catch(ReadNullException e) {}
	}
	
	@Test
	void testUpdate() {
		data.create("Batata", 5.0);
		data.update("Batata", 10.0);
		 assertEquals(10.0, data.read("Batata"));
	}
	
	@Test
	void testUpdateWithoutCreate() {
		data.update("Batata", 5.0);
		 assertEquals(5.0, data.read("Batata"));
	}
	
	@Test
	void testDelete() {
		data.create("Batata", 5.0);
		data.delete("Batata");		 
		try {
			data.read("Batata");
			fail("Não Deletou variavel");
		}catch(ReadNullException e) {}
	}
}
