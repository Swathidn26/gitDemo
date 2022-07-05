package dom;

import java.util.HashMap;
import java.util.Map;

public class HashMapexample {

	public static void main(String[] args) {

		HashMap<Integer,String> map = new HashMap<Integer,String>();
		map.put(1, "Mango");
		map.put(2, "Apple");
		map.put(3, "Orange");
		
		System.out.println("Iterating hashmap");
		for(Map.Entry m: map.entrySet()) {
			System.out.println(m.getKey()+" " +m.getValue());
		}
		

	}

}
