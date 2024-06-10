package practice;

import java.util.HashMap;
import java.util.Map;

public class Charoccurance {

	public static void main(String[] args) {
		String str = "Swathi";
		char[] ch= str.toCharArray();
		
		HashMap<Character, Integer> ip = new HashMap<Character, Integer>();
		for(char c:ch)
		{
			if(ip.containsKey(c) && (c!=' '))
			{
				ip.put(c, ip.get(c)+1);
			}
			else
			{
				ip.put(c, 1);
			}
		}
		for(Map.Entry entry : ip.entrySet())
		{
		System.out.println(	entry.getKey() + " " +entry.getValue());
				
		}

	}

}
