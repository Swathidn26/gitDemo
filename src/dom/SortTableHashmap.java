package dom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class SortTableHashmap {

	public static void main(String[] args) {
		HashMap<String, Integer> m = new HashMap<>();
		m.put("Russia", 145934462);
        m.put("China", 143932776);
        m.put("USA", 331002651);
        m.put("Canada", 37742154);
        m.put("Brazil", 212559417);
        m.put("Australia", 25499884);
        m.put("India", 1380004385);
        m.put("Argentina", 45195774);
        
        ArrayList<String> sortkeys = new ArrayList<String>(m.keySet());
        Collections.sort(sortkeys,Collections.reverseOrder());
        
        
        for(String str : sortkeys) {
        	System.out.println("Key = " +str + ", Value = " +m.get(str));
        }

        
	}

}
