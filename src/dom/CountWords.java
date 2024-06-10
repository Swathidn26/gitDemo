package dom;

public class CountWords {

	public static void main(String[] args) {
		
		String str = "this is java code ";
		
		int wordcount =0, state = 0;
		
		char ch [] = new char[str.length()];
		
		// Traverse all characters of the input string
		
		for(int i =0;i<str.length();i++)
		{
			
			ch[i]=str.charAt(i);
			
			if( ((i>0)&&(ch[i]!=' ')&&(ch[i-1]==' ')) || ((ch[0]!=' ')&&(i==0)) ) 
				
				wordcount++;
			
		}
		System.out.println(wordcount);
	}

}



