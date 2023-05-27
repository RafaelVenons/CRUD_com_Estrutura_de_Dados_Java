package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Data.Data;
import Data.InvalidParameterException;

class InvalidParametrsTest {

private Data<Double> data;
	
	@BeforeEach
	void initialize() {
		data = new Data<Double>();
	}
	
	@Test
	void testCreatingFirstInvalidParameter() {
		try {
			assertEquals(false, data.create(null, 1.0));
			fail("Aceitou String null");
		}catch(InvalidParameterException e) {}
		try {
			assertEquals(false, data.create("", 1.0));
			fail("Aceitou String vazia");
		}catch(InvalidParameterException e) {}
		try {
			assertEquals(false, data.create("  ", 1.0));
			fail("Aceitou String vazia");
		}catch(InvalidParameterException e) {}
	}

	@Test
	void testCreatingSecondInvalidParameter() {
		try {
			assertEquals(false, data.create("Batata",null));
			fail("Aceitou String null");
		}catch(InvalidParameterException e) {}
	}
	
	@Test
	void testReadInvalidParameter() {
		assertEquals(null, data.read(null));
		assertEquals(null, data.read(""));
		assertEquals(null, data.read("  "));
	}
	
	@Test
	void testUpdateFirstInvalidParameter() {
		try {
			assertEquals(false, data.update(null, 5.0));
			fail("Aceitou String null");
		}catch(InvalidParameterException e) {}
		try {
			assertEquals(false, data.update("", 5.0));
			fail("Aceitou String vazia");
		}catch(InvalidParameterException e) {}
		try {
			assertEquals(false, data.update("  ", 5.0));
			fail("Aceitou String vazia");
		}catch(InvalidParameterException e) {}
	}
	
	@Test
	void testUpdateSecondInvalidParameter() {
		try {
			assertEquals(false, data.update("Batata", null));
			fail("Aceitou String null");
		}catch(InvalidParameterException e) {}
	}
	
	@Test
	void testDeleteInvalidParameter() {
		assertEquals(true, data.create("Batata", 5.0));
		assertEquals(false, data.delete(null));
		assertEquals(false, data.delete(""));
		assertEquals(false, data.delete("  "));
		assertEquals(1, data.size());
	}
}
