package dom;

public class Palindromenumbers {

	public static void main(String[] args) {
		int num = 545;
		int r,temp, sum=0;
		
		temp = num;
		
		while(num>0)
		{
			r = num%10;
			num = num/10;
			sum = (sum*10)+r;
		}
		if(temp==sum)
		{
			System.out.println("Palindrome");
		}
		else
		{
			System.out.println("not a palindrome");
		}
	}

}
