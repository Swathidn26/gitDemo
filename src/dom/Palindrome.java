package dom;

public class Palindrome {
	public static void main(String[]args) {
		String str = "radara";
		String pal = "";
		
		for(int i=str.length()-1;i>=0;i--) {
			pal = pal+str.charAt(i);
			
		}
		if(pal.equals(str)) {
			System.out.println("given string is palindrome");
		}
		else {
			System.out.println("Given string is not a palinrome");
		}
		
	}

}
