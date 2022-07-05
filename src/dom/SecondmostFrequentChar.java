package dom;

public class SecondmostFrequentChar {

	
		static final int noOfChars = 256;
		
		static char getSecondchar(String str) {
			
			int chr[] = new int[noOfChars];
			int i;
			for(i=0;i<str.length();i++)
				(chr[str.charAt(i)])++;
			
			int first =0, second=0;
			for(i=0;i<noOfChars;i++) {
				if(chr[i]>chr[first]) {
					second=first;
					first=i;
				}
				else if(chr[i]>chr[second] && chr[i]!=chr[first])
					second=i;
				}
			return (char) second;
			}
		
		
		
		public static void main(String[] args) {
			
			String str1 = "SwathiPallaviiiii";
			System.out.println("Given String: " +str1);
			char res = getSecondchar(str1);
			if(res!='\0')
				System.out.println("second most frequent character found in the string: "+res);
			else
				System.out.println("No second most frequent character found in the string");
		

	}

}
