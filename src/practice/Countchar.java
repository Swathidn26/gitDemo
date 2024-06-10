package practice;

public class Countchar {

	public static void main(String[] args) {
		String str = "Swathi Dhananjay Naik";
		int count =0;
		
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)!=' ')
			{
				count++;
			}
		}
		System.out.println(count);

	}

}
