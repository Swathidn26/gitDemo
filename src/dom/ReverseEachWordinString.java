package dom;

public class ReverseEachWordinString {
	
	public static void main(String[]args) {
		String s1 = "This is java";
		String s2 = "";
		char []ch = s1.toCharArray();
		
		for(int i=0;i<s1.length();i++) {
			String temp ="";
			while(i<ch.length && ch[i]!=' ') {
				temp = ch[i]+temp;
				i++;
			}
			s2 = s2+temp+' ';
		}
		System.out.println(s1);
		System.out.println(s2);
	}

}
