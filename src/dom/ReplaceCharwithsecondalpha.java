package dom;

public class ReplaceCharwithsecondalpha {

	public static void main(String[] args) {
		String str = "dhananjayaswathi";
		int k = 28;
		String news ="";
		System.out.println("original string : "  +str);
		for(int i=0;i<str.length();++i) {
			//ASCII VALUE
			
			int val = str.charAt(i);
			int dup = k;
			
			if(val + k > 122 && val!=' ') {
				k-=(122-val);
				k=k % 26;
				
				news += (char)(96+k);
			}
			else
			{
				news += (char)(val+k);
			}
			k=dup;
		}
		System.out.println("output : " +news);

	}

}
