package dom;

public class CountStrings {

	public static void main(String[] args) {
		String str = "The best of both words";
		int count = 0;
		
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)!=' ') {
				count++;
			}
		}
		System.out.print("the number of Characters present is: "+count);

	}

}
