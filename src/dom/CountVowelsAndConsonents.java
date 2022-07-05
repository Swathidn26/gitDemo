package dom;

public class CountVowelsAndConsonents {

	public static void main(String[] args) {
		String str = "This is a really simple sentence";
		int vcount = 0, ccount =0;
		str = str.toLowerCase();
		
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='a' || str.charAt(i)=='e' || str.charAt(i)=='i'|| str.charAt(i)=='o'||str.charAt(i)=='u') {
				vcount++;
			}
			else if(str.charAt(i)>'a' && str.charAt(i)<='z') {
				ccount++;
			}
			
		}
		System.out.print("Number of vowels present in sentence is: " +vcount);
		System.out.println();
		System.out.print("Number of vowels present in sentence is: " +ccount);
		
				

	}

}
