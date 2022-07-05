package dom;

import java.util.ArrayList;

public class AlternateOddnumbers {

	public static void main(String[] args) {

		ArrayList<Integer> al = new ArrayList<Integer>();
		ArrayList<Integer> bl = new ArrayList<Integer>();
		for(int i =1;i<100;i=i+1) {
			if(i%2!=0) {
				
				al.add(i);
				
				
			}
		}
		System.out.println(al);
		
			
			
	}

}
