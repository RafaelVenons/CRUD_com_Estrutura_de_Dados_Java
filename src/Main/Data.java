package Main;

import java.util.Map;
import java.util.HashMap;

public class Data {
	Map<String, Double> data;
	
	public Data() {
		data = new HashMap<String, Double>();
	}
	
	public int size() {
		return data.size();
	}
	
	public void create(String tipe, double amount) {
		if(!data.containsKey(tipe))
			data.put(tipe, amount);
		else
			data.replace(tipe, data.get(tipe) + amount);
	}
	
	public Double read(String tipe) {
		if(data.containsKey(tipe))
			return data.get(tipe);
		throw new ReadNullException(); 
	}
	
	public void update(String tipe, double amount) {
		if(data.containsKey(tipe))
			data.replace(tipe, amount);
		else
			data.put(tipe, amount);
	}
	
	public void delete(String tipe) {
		data.remove(tipe);
	}
}
