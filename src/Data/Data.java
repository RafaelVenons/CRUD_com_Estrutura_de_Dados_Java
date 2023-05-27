package Data;

import java.util.Map;
import java.util.HashMap;
import java.util.function.BiConsumer;

public class Data<E> {
	private Map<String, E> data;
	
	public Data() {
		data = new HashMap<String, E>();
	}
	
	public int size() {
		return data.size();
	}
	
	public boolean contains(String tipe) {
		tipe = validationTest(tipe);
		return data.containsKey(tipe);
	}
	
	public boolean create(String tipe, E value) {
		tipe = validationTest(tipe, value);
		if(data.containsKey(tipe))
			return false;
		data.put(tipe, value);
		return true;
	}
	
	public E read(String tipe) {
		tipe = validationTest(tipe);
		if(data.containsKey(tipe))
			return data.get(tipe);
		return null; 
	}
	
	public boolean update(String tipe, E value) {
		tipe = validationTest(tipe, value);
		if(data.containsKey(tipe)) {
			data.replace(tipe, value);
			return true;
		}
		data.put(tipe, value);
		return false;
	}
	
	public boolean delete(String tipe) {
		tipe = validationTest(tipe);
		if(!data.containsKey(tipe))
			return false;
		data.remove(tipe);
		return true;
	}
	
	private String validationTest(String tipe, E value) {
		if(inputValidationTest(tipe) || inputValidationTest(value))
			throw new InvalidParameterException();
		return tipe.strip();
	}
	
	private String validationTest(String tipe) {
		if(inputValidationTest(tipe))
			return null;
		return tipe.strip();
	}
	
	private boolean inputValidationTest(String tipe) {
		return tipe == null || tipe.isBlank();
	}
	
	private boolean inputValidationTest(E value) {
		return value == null;
	}
	
	public void forEach(BiConsumer<String, E> action) {
        data.forEach(action);
    }
}
