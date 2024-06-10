package dom;

public class CountVowelswordsspclchar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "it can also be successfully used as a daily exercise& to get$";
				
		
		
		
		int wordcount = 0, vowelscount =0, spclcharcount=0;
		
		char ch[] = new char[str.length()];
		
		for(int i=0;i<str.length();i++) {
			
			char chr = str.charAt(i);
			
			ch[i] = str.charAt(i);
			if(((chr>='a' && chr <='z') || chr>='A' && chr<='Z'))
{
	
	
	chr = Character.toLowerCase(chr);
	if(chr == 'a' || chr=='e' || chr =='i' || chr=='o' || chr=='u') 
		vowelscount++;
	
		
	
}
			else
				spclcharcount++;

			if( ((i>0)&&(ch[i]!=' ')&&(ch[i-1]==' ')) || ((ch[0]!=' ')&&(i==0)) ) {
				wordcount++;
								
			}
			

			
		}
		
		System.out.println(wordcount);
		System.out.println(vowelscount);
		System.out.println(spclcharcount);

	}
	

}
