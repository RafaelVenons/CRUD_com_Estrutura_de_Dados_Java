package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Main.Data;
import Main.InvalidParameterException;
import Main.ReadNullException;

class InvalidParametrsText {

private Data<Double> data;
	
	@BeforeEach
	void initialize() {
		data = new Data<Double>();
	}
	
	@Test
	void testCreatingFirstInvalidParameter() {
		try {
			data.create(null, 1.0);
			fail("Aceitou String null");
		}catch(InvalidParameterException e) {}
		try {
			data.create("", 1.0);
			fail("Aceitou String vazia");
		}catch(InvalidParameterException e) {}
		try {
			data.create("  ", 1.0);
			fail("Aceitou String vazia");
		}catch(InvalidParameterException e) {}
	}

	@Test
	void testCreatingSecondInvalidParameter() {
		try {
			data.create("Batata",null);
			fail("Aceitou String null");
		}catch(InvalidParameterException e) {}
	}
	
	@Test
	void testReadInvalidParameter() {
		try {
			data.read(null);
			fail("Aceitou String null");
		}catch(ReadNullException e) {}
		try {
			data.read("");
			fail("Aceitou String vazia");
		}catch(ReadNullException e) {}
		try {
			data.read("  ");
			fail("Aceitou String vazia");
		}catch(ReadNullException e) {}
	}
	
	@Test
	void testUpdateFirstInvalidParameter() {
		try {
			data.update(null, 5.0);
			fail("Aceitou String null");
		}catch(InvalidParameterException e) {}
		try {
			data.update("", 5.0);
			fail("Aceitou String vazia");
		}catch(InvalidParameterException e) {}
		try {
			data.update("  ", 5.0);
			fail("Aceitou String vazia");
		}catch(InvalidParameterException e) {}
	}
	
	@Test
	void testUpdateSecondInvalidParameter() {
		try {
			data.update("Batata", null);
			fail("Aceitou String null");
		}catch(InvalidParameterException e) {}
	}
	
	@Test
	void testDeleteInvalidParameter() {
		data.create("Batata", 5.0);
		data.delete(null);
		data.delete("");
		data.delete("  ");
		assertEquals(1, data.size());
	}
}
