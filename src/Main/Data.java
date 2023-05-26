package Main;

import java.util.Map;
import java.util.HashMap;

public class Data<E> {
	Map<String, E> data;
	
	public Data() {
		data = new HashMap<String, E>();
	}
	
	public int size() {
		return data.size();
	}
	
	public void create(String tipe, E value) {
		validationTest(tipe, value);
		if(!data.containsKey(tipe))
			data.put(tipe, value);
		
	}
	
	public E read(String tipe) {
		if(data.containsKey(tipe))
			return data.get(tipe);
		throw new ReadNullException(); 
	}
	
	public void update(String tipe, E value) {
		validationTest(tipe, value);
		if(data.containsKey(tipe))
			data.replace(tipe, value);
		else
			data.put(tipe, value);
	}
	
	public void delete(String tipe) {
		data.remove(tipe);
	}
	
	private void validationTest(String tipe, E value) {
		if(inputValidationTest(tipe) || inputValidationTest(value))
			throw new InvalidParameterException();
	}
	
	private boolean inputValidationTest(String tipe) {
		return tipe == null || tipe.isBlank();
	}
	
	private boolean inputValidationTest(E value) {
		return value == null;
	}
}
