package dom;

public class paracticestatic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "radara";
		String pal="";
		
		for(int i=str.length()-1;i>=0;i--)
		{
			pal=pal+str.charAt(i);
		}
		if(pal.equals(str))
		{
			System.out.println("Palindrome");
		}
		else
		{
			System.out.println("not a palindrome");
		}
		

	}

}
