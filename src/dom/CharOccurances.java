package dom;

import java.util.HashMap;
import java.util.Map;

public class CharOccurances {

	public static void main(String[] args) {
		String str = "SwathiDhananjay";
		
		HashMap<Character,Integer> inputchar = new HashMap<Character,Integer>();
		char [] strarr = str.toCharArray();
		
		for(char c : strarr) {
			if(inputchar.containsKey(c) && c!=' ') {
				
				inputchar.put(c, inputchar.get(c)+1);
			}
			else {
				inputchar.put(c, 1);
			}
		}
		for(Map.Entry entry: inputchar.entrySet()) {
			System.out.println(entry.getKey() +" " + entry.getValue());
		}

		
	}

}
