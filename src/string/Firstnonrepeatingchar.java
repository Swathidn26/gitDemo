package string;

import java.util.HashMap;

public class Firstnonrepeatingchar {

	public static char firstNonRepeat(String s) {

		HashMap<Character, Integer> char_count = new HashMap<>();
		char [] arr = s.toCharArray();
		for(char c: arr) {
			
			if(char_count.containsKey(c)) {
				char_count.put(c, char_count.get(c) + 1);
			} else {
				char_count.put(c, 1);
			}
		}

		for(char c: arr) {
			 
			if(char_count.get(c)== 1)
				return c;
		}
		return '_';


	}
		
		
	public static void main(String[] args) {
		System.out.println(firstNonRepeat("GeeksForGeeks"));

	}

}