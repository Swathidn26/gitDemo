package dom;

import java.util.HashMap;
import java.util.Map;

public class PracticeOccurance {

	public static void main(String[] args) {
		String str = "swathi";
		char [] chr = str.toCharArray();
		
		HashMap<Character, Integer> charcount = new HashMap<Character, Integer>();
		for(char c : chr) {
			if(charcount.containsKey(c) && c!=' ') {
				charcount.put(c, charcount.get(c)+1);
			}
			
			else
			{
				charcount.put(c, 1);
			}
			
			}
		for(Map.Entry entry : charcount.entrySet()) {
			System.out.println(entry.getKey()+ " " +entry.getValue());
		}

	}

}
