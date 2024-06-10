package dom;

public class Practicewordsvowelsspclcounts {

	public static void main(String[] args) {
		
		
		String str = "it can also be successfully used as a daily exercise& to get$";
		
		int wordcount =0, vowelscount=0, spclcount =0;
		
		str = str.toLowerCase();
		char chr[] = new char[str.length()];
		
		for(int i =0;i<str.length();i++)
		{
			char ch  = str.charAt(i);
			
			if(ch == 'a' || ch== 'e' || ch=='i' || ch=='o' || ch=='u') {
				vowelscount++;
			}
			else
				spclcount++;
			
		
		
		if(((i>0) && chr[i]!=' ') && (chr[i-1]== ' ') || ( (chr[0]!=' ')&& (i==0)) )
			//if( ((i>0)&&(ch[i]!=' ')&&(ch[i-1]==' ')) || ((ch[0]!=' ')&&(i==0)) )
           wordcount++;
		
		}
		
		System.out.println(wordcount);
		System.out.println(vowelscount);
		System.out.println(spclcount);
	}

}
