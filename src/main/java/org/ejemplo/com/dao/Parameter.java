package org.ejemplo.com.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Parameter {
	private Map<String, String> collation;
	
	public Parameter() {
		collation = new HashMap<>();
	}
	
	public Parameter Add (String name, String value) {
		collation.put(name, value);
		return this;
	}
	
	public Set<Entry<String, String>> getParameters(){
		return collation.entrySet();
	}

}
