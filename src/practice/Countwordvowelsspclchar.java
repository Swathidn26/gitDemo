package practice;

public class Countwordvowelsspclchar {

	public static void main(String[] args) {
		String str = "it can also be successfully used as a daily exercise& to get$";
		int vowels=0,words=0,spcl=0,consonent=0;
		
		str=str.toLowerCase();
		char [] chr = new char[str.length()];
		for(int i=0;i<str.length();i++)
		{
			char ch = str.charAt(i);
			
			if(((i>0) && (chr[i]!=' ') && (chr[i-1]==' ')) || ((chr[0]!=' ') && (i==0)))
            
{
	words++;
}
			
			
			if (ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u')
			{
				vowels++;
			}
			else if(ch>'a' && ch<'z')
			{
				spcl++;
			}
		}
		
		
		System.out.println(vowels);
		System.out.println(spcl);
		System.out.println(words);

	}

}
